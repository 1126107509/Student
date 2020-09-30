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
     * z
     * 添加成绩
     * @param stuId    学生id
     * @param courseId 课程id
     * @param score    成绩
     * @return 是否添加成功
     */
    @Override
    public boolean addScore(long stuId, long courseId, double score) {
        return scoreDao.addScore(stuId, courseId, score);
    }

    /**
     * z
     * 更新成绩
     * @param stuId    学生id
     * @param courseId 课程id
     * @param score    分数
     * @return 是否更新成功
     */
    @Override
    public boolean updateScore(long stuId, long courseId, double score) {
        return scoreDao.updateScore(stuId, courseId, score);
    }

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
