package studentTracking.dao;

import studentTracking.model.EvaluateDate;

import java.util.List;

/**
 * 评价时间节点dao层接口
 */
public interface IEvaluateDateDao {
    /**
     * 林崑鹏
     * 查询所有时间节点
     * @return 时间节点列表
     */
    List<EvaluateDate>  getAllDate();
}
