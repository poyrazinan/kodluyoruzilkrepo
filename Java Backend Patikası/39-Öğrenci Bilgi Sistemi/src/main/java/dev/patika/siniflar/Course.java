package dev.patika.siniflar;

import org.jetbrains.annotations.NotNull;

public class Course {

    Teacher teacher;
    String name, code, prefix;
    int examNote = 0, performanceNote = 0;
    double examRatio = 0, average = 0;

    public Course(String name, String code, String prefix, int examRatio) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.examRatio = (double) examRatio/100;
    }

    public void calculateAverage() {
        average = (examNote*examRatio) + (performanceNote*(1.0D - examRatio));
    }

    public void addTeacher(@NotNull Teacher teacher) {
        if (prefix.equals(teacher.branch)) {
            this.teacher = teacher;
            System.out.println("Hoca derse eklendi.");
        }
        else
            System.out.println("Hocanın branşı bu derse uygun değil.");
    }

    public void printTeacher() {
        if (teacher == null)
            System.out.println(name + " dersinin hocası yok.");
        else
            System.out.println(name + " dersinin hocası: " + teacher.name);
    }
}
