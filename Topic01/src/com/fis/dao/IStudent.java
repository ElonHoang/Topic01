package com.fis.dao;

import com.fis.model.student.Student;

public interface IStudent {
    public void addStudent(Student s);
    public void removeStudent(int code);
    public void display();
}
