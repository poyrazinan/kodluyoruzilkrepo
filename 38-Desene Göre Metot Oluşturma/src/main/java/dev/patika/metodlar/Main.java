package dev.patika.metodlar;

import java.util.Scanner;

public class Main {

    static int num;

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Sayı girin: ");
        num = scan.nextInt();
        extractionProcess(num, true);
        System.out.println();
    }

    static int extractionProcess(int temp, boolean isExtraction) {
        System.out.print(temp + " ");
        if (isExtraction) {
            if (temp <= 0)
                extractionProcess(temp+5, false);
            else
                extractionProcess(temp-5, true);
        }
        else {
            if (temp == num)
                return 1;
            else
                extractionProcess(temp+5, false);
        }
        return 1;
    }
}
