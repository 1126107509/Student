package studentTracking.controller;

import com.alibaba.fastjson.JSONObject;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import studentTracking.dao.IScoreDao;
import studentTracking.model.*;
import studentTracking.model.Class;
import studentTracking.model.Student;
import studentTracking.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class TeacherController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IScoreService scoreService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IClassService classService;
    @Autowired
    private ISchoolEvaluationService schoolEvaluationService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/studentList")
    public String studentList(String classState, String teacherId, String teacherName, Model model) {
        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("courseList", courseList);
        model.addAttribute("teacherId", teacherId);
        model.addAttribute("teacherName", teacherName);
        if ("0".equals(classState)) {
            model.addAttribute("classState", "0");
        } else {
            model.addAttribute("classState", "1");
        }
        return "teacher/studentList";
    }

    @RequestMapping("/index")
    public String index() {
        return "teacher/index";
    }

    @RequestMapping("/teacherInfo")
    public String teacherInfo() {
        return "teacher/teacherInfo";
    }

    @RequestMapping("/studentInfo")
    public String studentInfo() {
        return "teacher/studentInfo";
    }

    @RequestMapping("/addStudent")
    public String addStudent() {
        return "teacher/addStudent";
    }

    @RequestMapping("/modifyPwdForward")
    public String modifyPwdForward(String userId, Model model) {
        long uId = Long.parseLong(userId);
        User user = userService.getUserByUserId(uId);
        model.addAttribute("user", user);
        return "forward:toModifyPwd";
    }

    /**
     * 跳转到修改密码界面
     * @return
     */
    @RequestMapping("/toModifyPwd")
    public String toModifyPwd() {
        return "teacher/modifyPwd";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "forward:/WEB-INF/view/login.html";
    }

    @RequestMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(String userName, String password) {
        long userId = userService.getUserByLogin(userName, password);
        return Long.toString(userId);
    }

    @RequestMapping("/loginJudge")
    public String loginJudge(String userId, Model model) {
        User user = userService.getUserByUserId(Long.parseLong(userId));
        model.addAttribute("user", user);
        if (user.getFlag() == 1) {
            return "forward:index";
        } else if (user.getFlag() == 2) {
            return "";
        } else {
            return "";
        }
    }

    /**
     * 根据老师id获取学生信息将其封装进json并返回
     * @param page
     * @param limit
     * @param teacherId
     * @return
     */
    @RequestMapping("/getStuByTeacher")
    @ResponseBody
    public Object getStuByTeacher(int page, int limit, String teacherId, String stuName, String classState) {
        //将前台数据进行处理
        long tId = 0;
        if ("".equals(teacherId)) {
            tId = 0;
        } else {
            tId = Long.parseLong(teacherId);
        }
        if (stuName == null) {
            stuName = "";
        }
        long cState = Long.parseLong(classState);
        page = (page - 1) * limit;

        //根据老师id和学生姓名查询到的所有学生信息
        List<Student> studentList = studentService.getAllStuByTeacher(tId, stuName,cState);
        //根据老师id和学生姓名分页查询到的所有学生信息
        List<Student> studentListByPage = studentService.getStuByTeacher(page, limit, tId, stuName,cState);
        //查询出所有课程
        List<Course> courseList = courseService.getAllCourse();
        //将需要的数据封装到mapList
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (int i = 0; i < studentListByPage.size(); i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("stuId", studentListByPage.get(i).getStuId());
            map.put("stuName", studentListByPage.get(i).getStuName());
            map.put("sex", studentListByPage.get(i).getSex());
            map.put("university", studentListByPage.get(i).getUniversity());
            map.put("birthPlace", studentListByPage.get(i).getBirthPlace());
            map.put("className", classService.getClassByCId(studentListByPage.get(i).getClassId()).getClassName());
            if (studentListByPage.get(i).getSchoolEvaluation() == null
                    || "".equals(studentListByPage.get(i).getSchoolEvaluation().getEvaluateContent())
                    || studentListByPage.get(i).getSchoolEvaluation().getEvaluateScore() == 0) {
                map.put("schoolEvaluation", "未评价");
            } else {
                map.put("schoolEvaluation", "已评价");
            }
            //获得当前学生的所有成绩
            List<Score> scoreList = studentListByPage.get(i).getScoreList();
            //遍历将其放入map
            for (Course course : courseList) {
                for (Score score : scoreList) {
                    if (course.getCourseId() == score.getCourseId()) {
                        map.put("" + course.getCourseId(), score.getScore());
                    }
                }
            }
            mapList.add(map);
        }

        //将其封装进json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", studentList.size());
        jsonObject.put("data", JSONArray.fromObject(mapList));
        return jsonObject;
    }

    /**
     * 根据学号获取学生信息
     * @param stuId 学号
     * @param model
     * @return
     */
    @RequestMapping("/getStuByStuId")
    public String getStuByStuId(String stuId, String teacherName, Model model) {
        long sId = Integer.parseInt(stuId);
        //学生信息
        Student student = studentService.getStuByStuId(sId);
        model.addAttribute("student", student);
        //课程及成绩信息
        List<Course> courseList = courseService.getAllCourse();
        List<Score> scoreList = student.getScoreList();
        Object[][] courseAndScore = new Object[3][courseList.size()];
        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            courseAndScore[0][i] = course.getCourseId();
            courseAndScore[1][i] = course.getCourseName();
            for (int j = 0; j < scoreList.size(); j++) {
                Score score = scoreList.get(j);
                if ((Long) courseAndScore[0][i] == score.getCourseId()) {
                    courseAndScore[2][i] = score.getScore();
                }
            }
        }
        model.addAttribute("courseAndScore", courseAndScore);
        //班期信息
        Class classInfo = classService.getClassByCId(student.getClassId());
        model.addAttribute("classInfo", classInfo);
        //培训学校评价信息
        SchoolEvaluation schoolEvaluation = student.getSchoolEvaluation();
        model.addAttribute("school", schoolEvaluation);
        //教师姓名
        model.addAttribute("teacherName", teacherName);
        //课程名称
        model.addAttribute("courseList", courseList);
        return "forward:studentInfo";
    }

    /**
     * 编辑学生分数
     * @param stuId
     * @param courseId
     * @param score
     * @return
     */
    @RequestMapping("/editScore")
    @ResponseBody
    public String editScore(String stuId, String courseId, String score) {
        //对获得的前台数据进行处理
        long sId = Long.parseLong(stuId);
        long cId = Long.parseLong(courseId);
        double sc = Double.parseDouble(score);

        //获得当前学生的信息
        Student student = studentService.getStuByStuId(sId);
        //获得当前学生的成绩
        List<Score> scoreList = student.getScoreList();
        boolean flag = false;
        //遍历成绩列表，判断前台传过来的成绩是否存在
        for (Score scoreT : scoreList) {
            if (cId == scoreT.getCourseId()) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }

        //如果成绩存在进行成绩的更新，不存在则进行添加
        if (flag) {
            if (scoreService.updateScore(sId, cId, sc)) {
                return "修改成功";
            } else {
                return "修改失败";
            }
        } else {
            if (scoreService.addScore(sId, cId, sc)) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        }
    }

    /**
     * 学校评价内容
     * @param evaluateId
     * @param stuId
     * @param evaluatePerson
     * @param evaluateScore
     * @param evaluateContent
     * @return
     */
    @RequestMapping("/schoolEvaluate")
    @ResponseBody
    public String schoolEvaluate(String evaluateId, String stuId,
                                 String evaluatePerson, String evaluateScore,
                                 String evaluateContent) {
        //处理前台数据
        long eId = Long.parseLong(evaluateId);
        long sId = Long.parseLong(stuId);
        double eScore = Double.parseDouble(evaluateScore);

        if (eId == 0) {
            if (schoolEvaluationService.addSchoolEvaluate(sId, evaluatePerson, eScore, evaluateContent)) {
                return "评价成功";
            } else {
                return "评价失败";
            }
        } else {
            if (schoolEvaluationService.updateSchoolEvaluate(eId, sId, evaluatePerson, eScore, evaluateContent)) {
                return "修改评价成功";
            } else {
                return "修改评价失败";
            }
        }
    }

    @RequestMapping("/modifyPwd")
    @ResponseBody
    public String modifyPwd(String userId, String newPwd) {
        long uId = Long.parseLong(userId);
        if (userService.modifyPwdByUserId(uId, newPwd)) {
            return "修改密码成功";
        } else {
            return "修改密码失败";
        }
    }

    /**
     * 根据教师id获得教师信息进行转发
     * @param teacherId
     * @param model
     * @return
     */
    @RequestMapping("/getTeacherById")
    public String getTeacherById(String teacherId, Model model) {
        long tId = Long.parseLong(teacherId);
        Teacher teacher = teacherService.getTeacherById(tId);
        model.addAttribute("teacher", teacher);
        return "forward:teacherInfo";
    }

    @RequestMapping("/updateTeacherById")
    @ResponseBody
    public String updateTeacherById(Teacher teacher) {
        if (teacherService.updateTeacherById(teacher)) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping("/saveTeacherImg")
    @ResponseBody
    public String saveTeacherImg(MultipartFile file, HttpServletRequest request) {
        //创建目录用来存放上传文件
        String path = request.getServletContext().getRealPath("/static/img");
        File fileDir = new File(path);
        //文件不存在或者不是文件夹则创建
        if (!fileDir.exists() || !fileDir.isDirectory()) {
            fileDir.mkdir();
        }
        //获得文件原名称
        String oldName = file.getOriginalFilename();
        //生成唯一的新名字
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newName = uuid + "-" + oldName;
        //根据文件名称和路径创建文件对象
        File img = new File(path, newName);
        //保存文件
        try {
            file.transferTo(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("img", "img/" + newName);
        return jsonObject.toString();
    }
}
