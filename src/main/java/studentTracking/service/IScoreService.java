package studentTracking.service;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Score;

import java.util.List;

public interface IScoreService {
    /**
     * z
     * 添加成绩
     * @param stuId 学生id
     * @param courseId 课程id
     * @param score 成绩
     * @return 是否添加成功
     */
    boolean addScore(long stuId, long courseId, double score);

    /**
     * z
     * 更新成绩
     * @param stuId 学生id
     * @param courseId 课程id
     * @param score 分数
     * @return 是否更新成功
     */
    boolean updateScore(@Param("stuId") long stuId, @Param("courseId") long courseId, @Param("score") double score);

}
