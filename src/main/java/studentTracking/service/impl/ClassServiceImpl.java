package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IClassDao;
import studentTracking.dao.ICourseDao;
import studentTracking.model.Class;
import studentTracking.service.IClassService;

@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassDao classDao;
    /**
     * z
     * 通过班期id获取班期信息
     * @param cId 班期id
     * @return 班期信息
     */
    @Override
    public Class getClassByCId(long cId) {
        return classDao.getClassByCId(cId);
    }
}
