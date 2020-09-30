package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IStudentDao;
import studentTracking.model.Student;
import studentTracking.service.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;

    /**
     * z
     * 根据老师id和学生姓名查询学生信息
     * @param teacherId  老师id
     * @param stuName    学生姓名
     * @param classState 班级状态
     * @return 学生信息列表
     */
    @Override
    public List<Student> getAllStuByTeacher(long teacherId, String stuName, long classState) {
        return studentDao.getAllStuByTeacher(teacherId, stuName, classState);
    }

    /**
     * z
     * 根据老师id和学生姓名分页查询所属学生信息
     * @param page       页码
     * @param limit      每页条数
     * @param teacherId  老师id
     * @param stuName    学生姓名
     * @param classState 班级状态
     * @return 学生信息列表
     */
    @Override
    public List<Student> getStuByTeacher(int page, int limit, long teacherId, String stuName, long classState) {
        return studentDao.getStuByTeacher(page, limit, teacherId, stuName, classState);
    }

    /**
     * z
     * 根据学生id查询学生信息
     * @param stuId 学生id
     * @return 学生信息
     */
    @Override
    public Student getStuByStuId(long stuId) {
        return studentDao.getStuByStuId(stuId);
    }

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
