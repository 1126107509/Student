package studentTracking.model;

import java.util.List;

/**
 * 班级实体类
 */
public class Class {
    /**
     * 班级id
     */
    private long classId;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 教师id
     */
    private long teacherId;
    /**
     * 状态
     */
    private long state;
    /**
     * 学生集合
     */
    private List<Student> students;

    public Class() {
    }

    public Class(String className, long teacherId, List<Student> students) {
        this.className = className;
        this.teacherId = teacherId;
        this.students = students;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", students=" + students +
                '}';
    }
}
