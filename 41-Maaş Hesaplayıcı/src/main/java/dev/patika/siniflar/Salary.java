package dev.patika.siniflar;

public class Salary {

    Employee employee;
    double tax, raiseSalary, taxAmount;
    int bonusPay;

    public Salary(Employee employee) {
        this.employee = employee;
        tax();
        bonus();
        raiseSalary();
    }

    public void run() {
        System.out.println("==============");
        System.out.println("Adı: " + employee.name);
        System.out.println("Maaşı: " + employee.salary);
        System.out.println("Çalışma Saati: " + employee.workHours);
        System.out.println("Başlangıç Yılı: " + employee.hireYear);
        System.out.println("Vergi: " + taxAmount);
        System.out.println("Bonus: " + bonusPay);
        System.out.println("Maaş Artışı: " + raiseSalary);
        System.out.println("Vergi ve Bonuslar ile birlikte maaş: " + (employee.salary - taxAmount + bonusPay));
        System.out.println("Toplam Maaş: " + (employee.salary - taxAmount + bonusPay + raiseSalary));
    }

    public void tax() {
        if (employee.salary < 1000)
            tax = 0.0;
        else
            tax = 0.03;

        if (tax != 0)
            taxAmount = employee.salary*tax;
        else
            taxAmount = employee.salary;
    }

    public void bonus() {
        if (employee.workHours > 40)
            bonusPay = (employee.workHours-40)*30;
        else
            bonusPay = 0;
    }

    public void raiseSalary() {
        int workingYears = 2021-(employee.hireYear);
        if (workingYears < 10)
            raiseSalary = employee.salary*0.05;
        else if (workingYears > 9 && workingYears < 20)
            raiseSalary = employee.salary*0.1;
        else if (workingYears > 19)
            raiseSalary = employee.salary*0.15;
    }
}
