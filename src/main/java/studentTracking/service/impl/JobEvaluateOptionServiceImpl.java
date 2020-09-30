package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IJobEvaluateOptionDao;
import studentTracking.model.JobEvaluateOption;
import studentTracking.service.IJobEvaluateOptionService;

import java.util.List;

/**
 * 评价项service实现层
 */
@Service
public class JobEvaluateOptionServiceImpl implements IJobEvaluateOptionService {
    @Autowired
    private IJobEvaluateOptionDao jobEvaluateOptionDao;
    /**
     * 林崑鹏
     * 获得所有的评分项
     *
     * @return 评分项列表
     */
    @Override
    public List<JobEvaluateOption> getAllOption() {
        return jobEvaluateOptionDao.getAllOption();
    }
}
