package com.se.pojo;

/**
 * @author DeepBlue
 * @date 2019/11/5  16:29
 */
public class ClassLeader extends User {
    private String classId;
    private String department;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ClassLeader() {
    }

    public ClassLeader(long id, String username, String email, String classId, String department) {
        super(id, username, email);
        this.classId = classId;
        this.department = department;
    }

    public ClassLeader(String identity, String username, String password, String password2, String email) {
        super(identity, username, password, password2, email);
    }
}
