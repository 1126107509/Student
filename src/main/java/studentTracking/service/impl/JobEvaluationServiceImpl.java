package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IJobEvaluationDao;
import studentTracking.model.JobEvaluation;
import studentTracking.service.IJobEvaluationService;

import java.util.List;

/**
 * 工作评价项业务逻辑实现层
 */
@Service
public class JobEvaluationServiceImpl implements IJobEvaluationService {

    @Autowired
    private IJobEvaluationDao jobEvaluationDao;

    /**
     * 林崑鹏
     * 根据学生id查询学生的所有评价信息
     * @param stuId 学生id
     * @return 评价信息列表
     */
    @Override
    public List<JobEvaluation> getEvaluateByStuId(long stuId) {
        return jobEvaluationDao.getEvaluateByStuId(stuId);
    }

    /**
     * 林崑鹏
     * 插入评价项
     * @param jobEvaluation 评价实体类
     * @return 返回评价结果结果
     */
    @Override
    public boolean insertCommand(JobEvaluation jobEvaluation) {
        return jobEvaluationDao.insertCommand(jobEvaluation);
    }
}
