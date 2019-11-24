package com.se.pojo;

import java.util.ArrayList;

/**
 * @author DeepBlue
 * @date 2019/11/5  16:28
 */
public class Teacher extends User{
    private String department;
    private ArrayList<Class> classes;

    @Override
    public String toString() {
        return "Teacher{" +
                "classes=" + classes +
                '}';
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public Teacher(long id, String username, String email, String department) {
        super(id, username, email);
        this.department = department;
    }

    public Teacher(long id, String username, String email, String department, ArrayList<Class> classes) {
        super(id, username, email);
        this.department = department;
        this.classes = classes;
    }

    public Teacher(String identity, String username, String password, String password2, String email) {
        super(identity, username, password, password2, email);
    }
}
