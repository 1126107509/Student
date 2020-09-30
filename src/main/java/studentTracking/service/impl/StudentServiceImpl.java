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
}
