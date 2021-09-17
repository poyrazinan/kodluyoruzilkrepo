package dev.patika.sinifgecme;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int minGraduate = 55;
        HashMap<String, Integer> lessons = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Matematik notunu girin: ");
        lessons.put("mat", scanner.nextInt());

        System.out.print("Fizik notunuzu girin: ");
        lessons.put("fizik", scanner.nextInt());

        System.out.print("Türkçe notunuzu girin: ");
        lessons.put("turkce", scanner.nextInt());

        System.out.print("Kimya notunuzu girin: ");
        lessons.put("kimya", scanner.nextInt());

        System.out.print("Müzik notunuzu girin: ");
        lessons.put("muzik", scanner.nextInt());

        for (String lesson : ((HashMap<String, Integer>) lessons.clone()).keySet())
            if (lessons.get(lesson) > 100 || lessons.get(lesson) < 0)
                lessons.remove(lesson);

        int average = 0;
        for (Integer grade : lessons.values())
            average += grade;

        average /= lessons.size();

        if (average >= minGraduate)
            System.out.println("Tebrikler sınıfı geçtiniz. Ortalama: " + average);
        else
            System.out.println("Sınıfı geçemediniz. Ortalama: " + average);
    }
}
