package com.fis.module;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {
    private String userName;
    private String firstName;
    private String lastName;
    private String passWord;
    private LocalDateTime hiringDate;

    public Person(){

    }

    public Person(String userName, String firstName, String lastName, String passWord, LocalDateTime hiringDate) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.hiringDate = hiringDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDateTime hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return userName.equals(person.userName) && firstName.equals(person.firstName) && lastName.equals(person.lastName) && passWord.equals(person.passWord) && hiringDate.equals(person.hiringDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, firstName, lastName, passWord, hiringDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", hiringDate=" + hiringDate +
                '}';
    }
}
