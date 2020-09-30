package studentTracking.model;

/**
 * 评价时间节点实体类
 */
public class EvaluateDate {

    /**
     * 节点id
     */
    private long dateId;

    /**
     * 节点名称
     */
    private String dateName;

    public long getDateId() {
        return dateId;
    }

    public void setDateId(long dateId) {
        this.dateId = dateId;
    }

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }


}
