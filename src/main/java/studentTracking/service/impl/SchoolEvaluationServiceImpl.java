package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.ISchoolEvaluationDao;
import studentTracking.service.ISchoolEvaluationService;

@Service
public class SchoolEvaluationServiceImpl implements ISchoolEvaluationService {
    @Autowired
    private ISchoolEvaluationDao schoolEvaluationDao;
    /**
     * z
     * 添加评价信息
     * @param stuId           学生id
     * @param evaluatePerson  评价人
     * @param evaluateScore   评价分数
     * @param evaluateContent 评价内容
     * @return 是否添加成功
     */
    @Override
    public boolean addSchoolEvaluate(long stuId, String evaluatePerson, double evaluateScore, String evaluateContent) {
        return schoolEvaluationDao.addSchoolEvaluate(stuId, evaluatePerson, evaluateScore, evaluateContent);
    }

    /**
     * z
     * 修改评价信息
     * @param evaluateId      评价id
     * @param stuId           学生id
     * @param evaluatePerson  评价人
     * @param evaluateScore   评价分数
     * @param evaluateContent 评价内容
     * @return 是否修改成功
     */
    @Override
    public boolean updateSchoolEvaluate(long evaluateId, long stuId, String evaluatePerson, double evaluateScore, String evaluateContent) {
        return schoolEvaluationDao.updateSchoolEvaluate(evaluateId, stuId, evaluatePerson, evaluateScore, evaluateContent);
    }
}
