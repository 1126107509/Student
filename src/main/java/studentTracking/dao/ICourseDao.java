package studentTracking.dao;

import studentTracking.model.Course;

import java.util.List;

/**
 * 课程dao层接口
 */
public interface ICourseDao {
    /**
     * 林崑鹏
     * z
     * 获取所有课程信息
     * @return 课程信息列表
     */
    List<Course> getAllCourse();
}
