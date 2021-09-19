package dev.patika.diziler;

public class Main {

    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 10, 20, 5, 20};
        int[][] frequency = new int[arr.length][2];

        System.out.println("Tekrar Sayıları:");

        for (int i : arr)
            incMatrixVal(frequency, i);

        for (int k = 0; k < frequency.length; k++) {
            if (frequency[k][0] == 0)
                break;
            else
                System.out.println(frequency[k][0] + " Sayısı " + frequency[k][1] + " Kere tekrar edildi.");
        }

    }

    public static void incMatrixVal(int[][] matrix, int i) {
        boolean isFound = false;
        for (int k = 0; k < matrix.length; k++) {
            if (matrix[k][0] == i) {
                matrix[k][1]++;
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][0] == 0) {
                    matrix[k][0] = i;
                    matrix[k][1] = 1;
                    break;
                }
            }
        }
    }
}
