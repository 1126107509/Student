package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IScoreDao;
import studentTracking.model.Score;
import studentTracking.service.IScoreService;

import java.util.List;

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
}
