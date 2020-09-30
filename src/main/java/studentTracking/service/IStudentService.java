package studentTracking.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import studentTracking.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {




    /**
     * 林崑鹏
     * 根据用户表里peopleId查询单个学生信息
     * @param peopleId 用户表的peopleid
     * @return 查询出的单个学生的所有信息
     */
    Student getStuInform(long peopleId);

    /**
     * 林崑鹏
     * 获取学生信息，
     * @param deptId 部门id
     * @return 学生列表
     */
    List<Student> getStu(long deptId);

    /**
     * 林崑鹏
     * 根据部门编号获取员工信息和相应评价
     * @param page 页码
     * @param limit 每页信息条数
     * @param deptId 部门编号
     * @return
     */
    List<Student> getStuByDeptId(@Param("page") int page, @Param("limit") int limit, @Param("deptId") long deptId,@Param("stuName")String stuName);


}
