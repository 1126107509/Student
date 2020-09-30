package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.ICourseDao;
import studentTracking.model.Course;
import studentTracking.service.ICourseService;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseDao courseDao;
    /**
     * z
     * 获取所有课程信息
     * @return 课程信息列表
     */
    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }
}
