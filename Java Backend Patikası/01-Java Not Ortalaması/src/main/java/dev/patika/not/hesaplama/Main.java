package dev.patika.not.hesaplama;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {

        int mat, turkce, fizik, kimya, tarih, muzik;

        Scanner scanner = new Scanner(System.in);

        awaitInput("Matematik");
        mat = scanner.nextInt();

        awaitInput("Türkçe");
        turkce = scanner.nextInt();

        awaitInput("Fizik");
        fizik = scanner.nextInt();

        awaitInput("Kimya");
        kimya = scanner.nextInt();

        awaitInput("Tarih");
        tarih = scanner.nextInt();

        awaitInput("Müzik");
        muzik = scanner.nextInt();

        double diff = (mat + turkce + fizik + kimya + tarih + muzik) / 6D;

        PrintStream printStream = (diff >= 60) ? System.out.printf("Sınıf geçildi. Ortalama: " + diff) :
                System.out.printf("Sınıf geçilemedi. Ortalama: " + diff);

    }

    private static void awaitInput(String lesson) {
        System.out.print(lesson + " Notunuzu girin: ");
    }

}
