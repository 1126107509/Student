/**
 * @description Todo
 * @author li
 * @date 2020-09-22 17:59
 */
package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.ITeacherDao;
import studentTracking.model.Teacher;
import studentTracking.service.ITeacherService;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherDao teacherDao;
    /**
     * z
     * 通过老师id获得老师信息
     * @param teacherId 老师id
     * @return 老师信息
     */
    @Override
    public Teacher getTeacherById(long teacherId) {
        return teacherDao.getTeacherById(teacherId);
    }

    /**
     * z
     * 根据教师id修改教师信息
     * @param teacher 教师信息
     * @return 是否修改成功
     */
    @Override
    public boolean updateTeacherById(Teacher teacher) {
        return teacherDao.updateTeacherById(teacher);
    }
}
