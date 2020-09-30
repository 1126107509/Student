package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Score;

import java.util.List;
import java.util.Map;

/**
 * 成绩dao层接口
 */
public interface IScoreDao {
    /**
     * 林崑鹏
     * 根据people查询个人成绩
     * @param peopleId 用户名
     * @return 学生的各科成绩
     */
    List<Map<String,Object>> getPersonScores(long peopleId);

}
