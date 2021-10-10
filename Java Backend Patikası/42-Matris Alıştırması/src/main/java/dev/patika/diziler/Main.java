package dev.patika.diziler;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];

        System.out.println("===================");
        printMatrix(inputMatrix(matrix));
        System.out.println("===================");
        printMatrix(randomMatrix(matrix));
    }

    public static int[][] inputMatrix(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print("Lütfen " + row + ". Satır ve " + col + ". Sütun değerini giriniz: ");
                matrix[row][col] = scanner.nextInt();
            }
        return matrix;
    }

    public static int[][] randomMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[0].length; col++)
                matrix[row][col] = new Random().nextInt(99);

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++)
                System.out.print(matrix[row][col] + " ");
            System.out.println();
        }
    }
}
