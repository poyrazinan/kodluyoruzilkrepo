package dev.patika.siniflar;

public class Student {

    Course mat, fizik, kimya;
    String name, stuNo;
    int classes;
    double average;
    boolean isPass = false;

    public Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }

    public void addBulkNote(int mat, int fizik, int kimya, String type) {
        if (mat >= 0 && mat <= 100) {
            if (type.equalsIgnoreCase("exam"))
                this.mat.examNote = mat;
            else
                this.mat.performanceNote = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            if (type.equalsIgnoreCase("exam"))
                this.fizik.examNote = fizik;
            else
                this.fizik.performanceNote = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.examNote = kimya;
            if (type.equalsIgnoreCase("exam"))
                this.kimya.examNote = kimya;
            else
                this.kimya.performanceNote = kimya;
        }

    }

    public void isPass() {
        if (this.mat.examNote == 0 || this.fizik.examNote == 0 || this.kimya.examNote == 0
                || this.mat.performanceNote == 0 || this.fizik.performanceNote == 0 || this.kimya.performanceNote == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.mat.calculateAverage();
            this.kimya.calculateAverage();
            this.fizik.calculateAverage();
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.average);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.average = (this.fizik.average + this.kimya.average + this.mat.average) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.average > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.examNote);
        System.out.println("Fizik Notu : " + this.fizik.examNote);
        System.out.println("Kimya Notu : " + this.kimya.examNote);
        System.out.println("Matematik Sözlü Notu : " + this.mat.performanceNote);
        System.out.println("Fizik Sözlü Notu : " + this.fizik.performanceNote);
        System.out.println("Kimya Sözlü Notu : " + this.kimya.performanceNote);
    }


}
