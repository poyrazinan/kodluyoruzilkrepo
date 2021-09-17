package dev.patika.bolunebilme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int input;

        List<Integer> contents = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen sayıyı girin: ");
        input = scanner.nextInt();

        for (int floor = 0; floor <= input; floor++) {
            // 3'e ve 4'e bölünenler için Ekok (3,4) = 12
            if (floor%12==0)
                contents.add(floor);
            else continue;
        }

        int avarage = 0;
        for (int content : contents)
            avarage += content;

        avarage /= contents.size();
        System.out.println("Girilen değere kadar olan verilerden 3'e ve 4'e bölünenlerin ortalaması: " + avarage);
    }
}
