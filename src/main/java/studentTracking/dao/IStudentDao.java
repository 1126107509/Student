package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Student;

import java.util.List;

/**
 * 学生dao层接口
 */
public interface IStudentDao {
    /**
     * z
     * 根据老师id和学生姓名查询学生信息
     * @param teacherId 老师id
     * @param stuName 学生姓名
     * @param classState 班级状态
     * @return 学生信息列表
     */
    List<Student> getAllStuByTeacher(@Param("teacherId") long teacherId,
                                     @Param("stuName") String stuName,
                                     @Param("classState") long classState);

    /**
     * z
     * 根据老师id和学生姓名分页查询所属学生信息
     * @param page 页码
     * @param limit 每页条数
     * @param teacherId 老师id
     * @param stuName 学生姓名
     * @param classState 班级状态
     * @return 学生信息列表
     */
    List<Student> getStuByTeacher(@Param("page") int page,
                                  @Param("limit") int limit,
                                  @Param("teacherId") long teacherId,
                                  @Param("stuName") String stuName,
                                  @Param("classState") long classState);

    /**
     * z
     * 根据学生id查询学生信息
     * @param stuId 学生id
     * @return 学生信息
     */
    Student getStuByStuId(long stuId);
}
