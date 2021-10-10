package dev.patika.metodlar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fibonacci satırını girin: ");
        System.out.println("Değer: " + fibonacci(scanner.nextInt()));
    }

    static int fibonacci(int n) {
        if (n == 2 || n == 1)
            return 1;
        else if (n <= 0)
            return 0;

        return fibonacci(n - 1) + fibonacci( n - 2);
    }
}
