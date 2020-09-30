package studentTracking.dao;

import studentTracking.model.Class;

/**
 *  班级dao层接口
 */
public interface IClassDao {
    /**
     * z
     * 通过班期id获取班期信息
     * @param cId 班期id
     * @return 班期信息
     */
    Class getClassByCId(long cId);
}
