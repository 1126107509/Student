package studentTracking.service;

import studentTracking.model.JobEvaluateOption;
import studentTracking.model.JobEvaluation;

import java.util.List;

public interface IJobEvaluationService {

    /**
     * 林崑鹏
     * 根据学生id查询学生的所有评价信息
     * @param stuId 学生id
     * @return 评价信息列表
     */
    List<JobEvaluation> getEvaluateByStuId(long stuId);

    /**
     * 林崑鹏
     * 插入评价项
     * @param jobEvaluation 评价实体类
     * @return 返回评价结果结果
     */
    boolean insertCommand(JobEvaluation jobEvaluation);
}
