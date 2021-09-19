package dev.patika.diziler;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dizide kaç eleman olacağını girin: ");
        arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+1 + ". Elemanı girin: ");
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Sıralanmış eleman listesi: " +  Arrays.toString(arr));
    }
}
