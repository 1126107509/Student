package studentTracking.service;

import studentTracking.model.EvaluateDate;

import java.util.List;

public interface IEvaluateDateService {

    /**
     * 林崑鹏
     * 查询所有时间节点
     * @return 时间节点列表
     */
    List<EvaluateDate> getAllDate();
}
