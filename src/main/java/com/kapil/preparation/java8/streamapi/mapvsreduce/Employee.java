package com.kapil.preparation.java8.streamapi.mapvsreduce;

import java.util.Set;

public class Employee {
    private int id;
    private String name;
    private String grade;
    private double salary;
    private Set<Address> addresses;

    public Employee(int id, String name, String grade, double salary, Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.salary = salary;
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", salary=" + salary +
                ", addresses=" + addresses +
                '}';
    }
}
