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
    private String teacherId;
    /**
     * 学生集合
     */
    private List<Student> students;

    public Class() {
    }

    public Class(String className, String teacherId, List<Student> students) {
        this.className = className;
        this.teacherId = teacherId;
        this.students = students;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
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


}
