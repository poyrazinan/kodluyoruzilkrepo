package dev.patika.sicakliketkinligi;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int heat;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Hava sıcaklığını giriniz: ");
        heat = scanner.nextInt();

        boolean kayakResult = (heat < 5) ? measurementResult("Kayak yapmaya gidebilirsiniz.") : false;
        boolean sinemaResukt = (heat > 5 && heat < 15) ? measurementResult("Sinemaya gidebilirsiniz.") : false;
        boolean piknikResult = (heat > 10 && heat < 25) ? measurementResult("Pikniğe gidebilirsiniz.") : false;
        boolean yuzmeResult = (heat > 25) ? measurementResult("Yüzmeye gidebilirsiniz.") : false;
    }

    public static boolean measurementResult(String string) {
        System.out.println(string);
        return true;
    }
}
