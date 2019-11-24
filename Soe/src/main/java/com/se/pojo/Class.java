package com.se.pojo;

public class Class {
    private String teacherId;
    private String classId;

    @Override
    public String toString() {
        return classId;
    }

    public Class() {
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassId() {
        return classId;
    }

    public Class(String teacherId, String classId) {
        this.teacherId = teacherId;
        this.classId = classId;
    }
}
