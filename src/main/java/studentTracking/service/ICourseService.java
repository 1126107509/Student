package studentTracking.service;

import studentTracking.model.Course;

import java.util.List;

/**
 * 课程service层
 */
public interface ICourseService {

    /**
     * z
     * 林崑鹏
     * 获取所有课程信息
     * @return 课程信息列表
     */
    List<Course> getAllCourse();
}
