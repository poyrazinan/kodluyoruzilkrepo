package dev.patika.diziler;


public class Main {

    public static void main(String[] args) {
        String[][] letter = new String[6][4];

        for (int row = 0; row < letter.length; row++) {

            for (int col = 0; col < letter[row].length; col++) {

                if (row == 0 || row == 5 || row == 2)
                    if (col < 3)
                        letter[row][col] = " * ";

                if (col == 0)
                    letter[row][col] = " * ";

                if ((col == 3) && (row == 1 || row == 3 || row == 4))
                        letter[row][col] = " * ";

                if (letter[row][col] == null)
                    letter[row][col] = "   ";
            }

        }

        for (String[] row : letter){
            for (String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
