package dev.patika.metodlar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        if (isPalindrom(scanner.nextInt()))
            System.out.println("Sayı palindrom");
        else
            System.out.println("Sayı palindrom değil.");
    }

    static boolean isPalindrom(int num) {
        int temp = num, reverseNumber = 0, lastNumber;
        while (temp != 0) {
            lastNumber = temp % 10;
            reverseNumber = (reverseNumber * 10) + lastNumber;
            temp /= 10;
        }
        if (reverseNumber == num)
            return true;
        else return  false;
    }
}
