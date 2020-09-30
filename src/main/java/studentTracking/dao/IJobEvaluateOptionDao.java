package studentTracking.dao;

import studentTracking.model.JobEvaluateOption;

import java.util.List;

/**
 * 评价分项dao层接口
 */
public interface IJobEvaluateOptionDao {
    /**
     * 林崑鹏
     * 获得所有的评分项
     * @return 评分项列表
     */
    List<JobEvaluateOption> getAllOption();
}
