package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IScoreDao;
import studentTracking.service.IScoreService;

import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    private IScoreDao scoreDao;

    /**
     * 林崑鹏
     * 根据peopleId查询个人成绩
     * @param peopleId 用户名
     * @return 学生的各科成绩
     */
    @Override
    public List<Map<String, Object>> getPersonScores(long peopleId) {
        return scoreDao.getPersonScores(peopleId);
    }
}
