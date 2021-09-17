package dev.patika.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        List<Integer> integerList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("İlk sayıyı girin: ");
        integerList.add(scanner.nextInt());

        System.out.print("İkinci sayıyı girin: ");
        integerList.add(scanner.nextInt());

        System.out.print("Üçüncü sayıyı girin: ");
        integerList.add(scanner.nextInt());

        Collections.sort(integerList);
        System.out.println("Küçükten büyüğe sıralanmış: " + integerList.toString());
        Collections.reverse(integerList);
        System.out.println("Büyükten küçüğe sıralanmış: " + integerList.toString());
    }
}
