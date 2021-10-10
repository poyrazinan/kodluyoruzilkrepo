package dev.patika.diziler;

public class Main {

    public static void main(String[] args) {
        int[] list = {3, 7, 3, 2, 9, 10, 21, 6, 33, 6, 2};
        int[] clone = new int[list.length];
        int startIndex = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if ((i != j) && (list[i] == list[j])) {
                    if (!isFound(clone, list[i]) && list[i] % 2 == 0)
                        clone[startIndex++] = list[i];
                    break;
                }
            }
        }
        for (int temp : clone)
            if (temp == 0)
                break;
            else System.out.print(temp + " ");
    }

    public static boolean isFound(int[] clone, int reg) {
        for (int val : clone)
            if (val == reg)
                return true;

        return false;
    }
}
