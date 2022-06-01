package com.fis.dao.studentDAO;

import com.fis.model.student.Student;

public interface IStudent {
    public void addStudent(Student s);
    public void removeStudent(int code);
    public void display();
}
