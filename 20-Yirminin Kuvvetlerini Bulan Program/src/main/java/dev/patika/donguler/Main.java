package dev.patika.donguler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        List<Integer> inputs = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen bir sayı girin: ");
        int input = scanner.nextInt();

        for (int floor = 0; floor <= input; floor++)
            // Ekok(4, 5) = 20
            if (floor % 20 == 0)
                inputs.add(floor);

        System.out.println("4'e ve 5'e bölünebilen sayılar: \n" + inputs);
    }
}
