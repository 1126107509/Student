package studentTracking.model;

/**
 * 成绩实体类
 */
public class Score {
    /**
     * 学生id
     */
    private long stuId;
    /**
     * 课程id
     */
    private long courseId;
    /**
     * 成绩
     */
    private double score;

    public Score() {
    }

    public Score(long stuId, long courseId, double score) {
        this.stuId = stuId;
        this.courseId = courseId;
        this.score = score;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
