package studentTracking.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IStudentDao;
import studentTracking.model.Student;
import studentTracking.service.IStudentService;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;




    /**
     * 林崑鹏
     * 根据用户表里peopleId查询单个学生信息
     * @param peopleId 用户表的peopleid
     * @return 查询出的单个学生的所有信息
     */
    @Override
    public Student getStuInform(long peopleId) {
        return studentDao.getStuInform(peopleId);
    }

    /**
     * 林崑鹏
     * 获取当前部门下的所有学生信息
     * @param deptId 部门id
     * @return 学生列表
     */
    @Override
    public List<Student> getStu(long deptId) {
        return studentDao.getStu(deptId);
    }

    /**
     * 林崑鹏
     * 根据部门编号获取员工信息和相应评价
     * @param page   页码
     * @param limit  每页信息条数
     * @param deptId 部门编号
     * @return
     */
    @Override
    public List<Student> getStuByDeptId(int page, int limit, long deptId,String stuName) {
        return studentDao.getStuByDeptId(page, limit, deptId,stuName);
    }

}
