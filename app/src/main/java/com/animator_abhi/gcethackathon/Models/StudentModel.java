package com.animator_abhi.gcethackathon.Models;

/**
 * Created by ankur on 14-04-2017.
 */

public class StudentModel {
    String student_name;
    String college;
    String email;
    String intrest;
    String idea;

    public StudentModel(String student_name, String college, String email, String intrest, String idea) {
        this.student_name = student_name;
        this.college = college;
        this.email = email;
        this.intrest = intrest;
        this.idea = idea;
    }

    public StudentModel() {
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntrest() {
        return intrest;
    }

    public void setIntrest(String intrest) {
        this.intrest = intrest;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }
}
