package studentTracking.service;

import studentTracking.model.JobEvaluateOption;

import java.util.List;

/**
 * 评价项service层
 */
public interface IJobEvaluateOptionService {

    /**
     * 林崑鹏
     * 获得所有的评分项
     * @return 评分项列表
     */
    List<JobEvaluateOption> getAllOption();
}
