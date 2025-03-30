package com.aetherwave.gpa_c;

public class Subject {
    private String name;
    private int credit;
    private String grade;

    public Subject(String name, int credit, String grade) {
        this.name = name;
        this.credit = credit == 1 ? 0 : credit;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
