package studentTracking.controller;

import com.alibaba.fastjson.JSONObject;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import studentTracking.model.EvaluateDate;
import studentTracking.model.JobEvaluateOption;
import studentTracking.model.JobEvaluation;
import studentTracking.model.Student;
import studentTracking.service.IEvaluateDateService;
import studentTracking.service.IJobEvaluateOptionService;
import studentTracking.service.IJobEvaluationService;
import studentTracking.service.IStudentService;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 部门控制器层
 */
@Controller
public class DeptController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IEvaluateDateService evaluateDateService;
    @Autowired
    private IJobEvaluationService jobEvaluationService;
    @Autowired
    private IJobEvaluateOptionService jobEvaluateOptionService;

    /**
     * 林崑鹏
     * 用于访问部门学生列表页面deptAllStu并将相应的数据传入当中
     * @return 地址路径
     */
    @RequestMapping("/deptAllStu")
    public String deptAllStu(Model model,long deptId) {
        List<EvaluateDate> evaluateDates = evaluateDateService.getAllDate();
        model.addAttribute("evaluateDates",evaluateDates);
        model.addAttribute("deptId",deptId);
        return "dept/deptAllStu";
    }

    /**
     * 林崑鹏
     * @return 访问地址的相对路径
     */
    @RequestMapping("/deptCommand")
    public String deptCommand(HttpServletRequest request,long dateId,long stuId,String stuName,Model model) {
        System.out.println("dateId = " + dateId);
        model.addAttribute("dateId",dateId);
        model.addAttribute("stuId",stuId);
        model.addAttribute("stuName",stuName);
        List<JobEvaluateOption> jobEvaluateOptionList = jobEvaluateOptionService.getAllOption();
        request.setAttribute("jobEvaluateOptionList",jobEvaluateOptionList);
        return "dept/deptCommand";
    }

    /**
     * 林崑鹏
     * 将当前部门的学生信息传入前台的动态表格中
     * @param page 页码
     * @param limit 每页信息条数
     * @param deptId 部门id
     * @return 封装了学生信息的json
     */
    @RequestMapping("/getStuBydeptId")
    @ResponseBody
    public Object getStuBydeptId(int page,int limit,String deptId) {
        long peopleId = 0;
        if (deptId == null) {
            peopleId = 0;
        } else {
            peopleId = Integer.parseInt(deptId);
        }
        page = (page - 1) * limit;
        //获取所有学生信息用于获得学生数量
        List<Student> list = studentService.getStu(peopleId);
        //从后台获得当前部门下的所有学生信息
        List<Student> studentList = studentService.getStuByDeptId(page, limit, peopleId,null);
        //获取所有的时间节点
        List<EvaluateDate> evaluateDateList = evaluateDateService.getAllDate();
        //将需要的数据封装到maplist中
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("stuId",studentList.get(i).getStuId());
            map.put("stuName",studentList.get(i).getStuName());
            map.put("sex",studentList.get(i).getSex());
            map.put("className",studentList.get(i).getaClass().getClassName());
            //获取本学生的所有评论信息
            List<JobEvaluation> jobEvaluationList = jobEvaluationService.getEvaluateByStuId(studentList.get(i).getStuId());
            //将评论状态封装到map对象中
            for (EvaluateDate evaluateDate : evaluateDateList) {
                map.put("" + evaluateDate.getDateId(),"未评价");
                for (JobEvaluation jobEvaluation : jobEvaluationList) {
                    if (jobEvaluation.getDateId() == evaluateDate.getDateId()) {
                        map.put("" + evaluateDate.getDateId(),"已评价");
                        break;
                    }
                }
            }
            mapList.add(map);
        }
        //将其封装进json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", list.size());
        jsonObject.put("data", JSONArray.fromObject(mapList));
        return jsonObject;
    }

    /**
     * 林崑鹏
     * 将评鉴时间节点
     * @return json对象
     */
    @RequestMapping("/getAllEvaluate")
    public String getAllEvaluate(Model model){
        List<EvaluateDate> evaluateDates = evaluateDateService.getAllDate();
        model.addAttribute("evaluateDates",evaluateDates);
        return "dept/deptAllStu";
    }

    /**
     * 林崑鹏
     * 给本部门学生添加评价
     */
    @RequestMapping("/insertCommand")
    @ResponseBody
    public String insertCommand(HttpServletRequest request,String dateId,String stuId) {
        boolean isAdd = false;
        //评价时间节点
        long dId = Long.parseLong(dateId);
        //stuId
        long sId = Long.parseLong(stuId);
        //评价人
        String evaluatePerson = request.getParameter("evaluatePerson");
        //总体评分
        double totalScore = Double.parseDouble(request.getParameter("totalScore"));
        //评语
        String jobEvaluateContent = request.getParameter("jobEvaluateContent");
        //获取所有的评价项
        List<JobEvaluateOption> jobEvaluateOptionList = jobEvaluateOptionService.getAllOption();
        //获取评价项
        for (JobEvaluateOption jobEvaluateOption : jobEvaluateOptionList ) {
            long optionId = jobEvaluateOption.getOptionId();
            double evaluateScore = Double.parseDouble(request.getParameter("" + jobEvaluateOption.getOptionId())) ;
            //将评价各项参数封装到实体类中
            JobEvaluation jobEvaluation = new JobEvaluation(dId,sId,optionId,evaluatePerson,evaluateScore,totalScore,jobEvaluateContent);
            //插入数据,并接收插入是否成功的信息
            isAdd = jobEvaluationService.insertCommand(jobEvaluation);
        }

        if (isAdd == true) {
            return "评价成功";
        }else {
            return "评价失败";
        }
    }
}
