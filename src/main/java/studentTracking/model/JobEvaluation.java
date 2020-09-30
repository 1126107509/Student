package studentTracking.model;

/**
 * 工作评价实体；
 */
public class JobEvaluation {
    /**
     * 日期id
     */
    private long dateId;
    /**
     * 学生id
     */
    private long stuId;
    /**
     * 评分项id
     */
    private long optionId;
    /**
     * 评价人
     */
    private String evaluatePerson;
    /**
     * 评分
     */
    private double evaluateScore;
    /**
     * 总分
     */
    private double totalScore;
    /**
     * 综合评价
     */
    private String jobEvaluateContent;

    public JobEvaluation() {
    }

    public JobEvaluation(long dateId, long stuId, long optionId, String evaluatePerson, double evaluateScore, double totalScore, String jobEvaluateContent) {
        this.dateId = dateId;
        this.stuId = stuId;
        this.optionId = optionId;
        this.evaluatePerson = evaluatePerson;
        this.evaluateScore = evaluateScore;
        this.totalScore = totalScore;
        this.jobEvaluateContent = jobEvaluateContent;
    }

    public long getDateId() {
        return dateId;
    }

    public void setDateId(long dateId) {
        this.dateId = dateId;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public String getEvaluatePerson() {
        return evaluatePerson;
    }

    public void setEvaluatePerson(String evaluatePerson) {
        this.evaluatePerson = evaluatePerson;
    }

    public double getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(double evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public String getJobEvaluateContent() {
        return jobEvaluateContent;
    }

    public void setJobEvaluateContent(String jobEvaluateContent) {
        this.jobEvaluateContent = jobEvaluateContent;
    }
}
