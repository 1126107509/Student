package studentTracking.service;

import studentTracking.model.Class;

public interface IClassService {
    /**
     * z
     * 通过班期id获取班期信息
     * @param cId 班期id
     * @return 班期信息
     */
    Class getClassByCId(long cId);
}
