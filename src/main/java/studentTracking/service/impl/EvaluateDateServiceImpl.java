package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IEvaluateDateDao;
import studentTracking.model.EvaluateDate;
import studentTracking.service.IEvaluateDateService;

import java.util.List;

@Service
public class EvaluateDateServiceImpl implements IEvaluateDateService {
    @Autowired
    private IEvaluateDateDao evaluateDateDao;


    /**
     * 查询所有评价时间节点
     *
     * @return 时间节点列表
     */
    @Override
    public List<EvaluateDate> getAllDate() {
        return evaluateDateDao.getAllDate();
    }
}
