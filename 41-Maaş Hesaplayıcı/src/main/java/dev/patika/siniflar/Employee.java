package dev.patika.siniflar;

public class Employee {

    String name;
    int salary, workHours, hireYear;

    public Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
}
