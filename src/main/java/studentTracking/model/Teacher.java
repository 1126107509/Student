/**
 * @description Todo
 * @author li
 * @date 2020-09-22 17:42
 */
package studentTracking.model;

/**
 * 教师表
 */
public class Teacher {

    //教师id
    private long teacherId;
    //教师名称
    private String tname;
    //教师性别
    private String sex;
    //生日
    private String birthday;
    //电话
    private String phone;
    //身份证
    private String idCard;
    //图片路径
    private String photo;

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
