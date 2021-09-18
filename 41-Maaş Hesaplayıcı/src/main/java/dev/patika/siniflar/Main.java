package dev.patika.siniflar;

public class Main {

    public static void main(String[] args) {
        Employee eren = new Employee("Eren", 2000, 45, 1985);
        Salary payDay = new Salary(eren);
        payDay.run();
    }
}
