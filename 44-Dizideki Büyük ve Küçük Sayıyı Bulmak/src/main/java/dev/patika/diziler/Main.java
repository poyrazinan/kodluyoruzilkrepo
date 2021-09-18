package dev.patika.diziler;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] list = {56, 34, 1, 8, 101, -2, -33};
        int[] tempList = Arrays.copyOf(list, list.length+1);
        int input, index;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen bir değer girin: ");
        input = scanner.nextInt();

        tempList[tempList.length-1] = input;
        Arrays.sort(tempList);
        index = Arrays.binarySearch(tempList, input);

        if (index == 0)
            System.out.println(input + " En küçük değer.");
        else
            System.out.println("Bir küçük değer " + tempList[index-1]);

        if (index == list.length)
            System.out.println(input + " En büyük değer.");
        else
            System.out.println("Bir büyük değer " + tempList[index+1]);
    }
}
