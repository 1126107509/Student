/**
 * @description Todo
 * @author li
 * @date 2020-09-22 00:33
 */
package studentTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import studentTracking.service.ITeacherService;
import studentTracking.service.IUserService;

/**
 * 控制页面跳转控制器
 */
@Controller
public class HtmlController {

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IUserService userService;


    /**
     * 林崑鹏
     * 跳转学生索引界面
     * @return
     */
    @RequestMapping("/stuIndex")
    public String stuIndex() {
        return "forward:/WEB-INF/view/student/stuIndex.html";
    }

    /**
     * 林崑鹏
     * 跳转到部门索引界面
     * @return 相对路径
     */
    @RequestMapping("/deptIndex")
    public String deptIndex() {
        return "forward:/WEB-INF/view/dept/deptIndex.jsp";
    }

}
