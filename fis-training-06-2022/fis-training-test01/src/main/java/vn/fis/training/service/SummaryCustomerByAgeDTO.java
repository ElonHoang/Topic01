package vn.fis.training.service;

import java.util.Objects;

public class SummaryCustomerByAgeDTO {
    private int age;
    private int count;
    //TODO: Setters, Getter, Constructors
    public SummaryCustomerByAgeDTO() {
    }

    public SummaryCustomerByAgeDTO(int age, int count) {
        this.age = age;
        this.count = count;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SummaryCustomerByAgeDTO)) return false;
        SummaryCustomerByAgeDTO that = (SummaryCustomerByAgeDTO) o;
        return age == that.age && count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, count);
    }

    @Override
    public String toString() {
        return "SummaryCustomerByAgeDTO{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }
}
