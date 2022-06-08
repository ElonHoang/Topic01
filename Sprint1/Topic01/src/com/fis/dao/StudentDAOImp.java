package com.fis.dao;

import com.fis.model.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements ISortStrategy, IStudent {
    public final int MAX = 100;

    private Student[] students;

    private int count;
    private ISortStrategy sortStrategy;

    private List<Student> stdList = new ArrayList<>();

    public StudentDAOImp(){
        this.count = 0;
        this.students  = new Student[MAX];
        this.sortStrategy = new SelectionSortStrategy();
    }

    @Override
    public void addStudent(Student student){
        stdList.add(student);
    }
    @Override
    public void removeStudent(int code){
        stdList.removeIf(t->t.getCode() == code);
    }

    @Override
    public void display(){
        stdList.forEach(System.out::println);
    }
    @Override
    public void sort(Comparable[] data, int count) {

    }

    public void setSortStrategy(ISortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;
    }

}
