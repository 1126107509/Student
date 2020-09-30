package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Student;

import java.util.List;
import java.util.Map;

/**
 * 学生dao层接口
 */
public interface IStudentDao {


    /**
     * 林崑鹏
     * 根据peopleId查询当前学生的所有信息
     * @param peopleId 用户表的peopleid
     * @return 封装了单个学生实体类的student
     */
    Student getStuInform(long peopleId);

    /**
     * 林崑鹏
     * 根据部门id获取学生信息，用于获取部门下的所有学生信息
     * @param deptId 部门id
     * @return 学生列表
     */
    List<Student> getStu(long deptId);

    /**
     * 林崑鹏
     * 根据部门编号获取员工信息
     * @param page 页码
     * @param limit 每页信息条数
     * @param deptId 部门编号
     * @return
     */
    List<Student> getStuByDeptId(@Param("page") int page, @Param("limit") int limit, @Param("deptId") long deptId,@Param("stuName")String stuName);
}
