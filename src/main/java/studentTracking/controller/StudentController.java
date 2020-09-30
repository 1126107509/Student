package studentTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import studentTracking.model.Student;
import studentTracking.service.IScoreService;
import studentTracking.service.IStudentService;
import javax.servlet.http.HttpServletRequest;

/**
 * 学生控制器层
 */
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IScoreService scoreService;

    @RequestMapping("/stuScore")
    public String stuScore() {
        return "student/stuScore";
    }

    /**
     * 林崑鹏
     * 查询到学生的个人信息返回到前台页面
     * @param model 用于将student对象传至目标对象
     * @return 学生个人信息展示页面
     */
    @RequestMapping("/getStuInformation")
    public String getStuInformation(Model model) {
        long peopleId = 1;
        Student student = studentService.getStuInform(peopleId);
        System.out.println("student = " + student);
        model.addAttribute("student",student);
        return "student/stuShow";
    }

    /**
     * 林崑鹏
     * 根据用户表的peopleId查询个人成绩信息
     * @param request 学生个人成绩
     * @return
     */
    @RequestMapping("/getStuScore")
    public String getStuScore(HttpServletRequest request) {
        long peopleId = 1;
        request.setAttribute("stuScore",scoreService.getPersonScores(peopleId));
        return "forward:stuScore";
    }
}
