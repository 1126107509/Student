package studentTracking.service;

import studentTracking.model.Course;

import java.util.List;

public interface ICourseService {
    /**
     * z
     * 获取所有课程信息
     * @return 课程信息列表
     */
    List<Course> getAllCourse();
}
