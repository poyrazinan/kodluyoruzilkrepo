package dev.patika.diziler;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                            { 1, 2, 3 },
                            { 4, 5, 6}
                         };

        int[][] clone = new int[matrix[0].length][matrix.length];

        System.out.println("Matris : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                clone[k][i] = matrix[i][k];
                System.out.print(" " + matrix[i][k]);
            }
            System.out.println();
        }

        System.out.println("Transpoze : ");
        for (int i = 0; i < clone.length; i++) {
            for (int k = 0; k < clone[i].length; k++)
                System.out.print(" " + clone[i][k]);
            System.out.println();
        }
    }
}
