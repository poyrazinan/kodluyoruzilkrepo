package dev.patika.mayintarlasi;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    String[][] board;
    String[][] boardHidden;
    boolean isGameOver = false;
    int rowLength, colLength, mines, moves;

    public MineSweeper() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Satır sayısını girin: ");
        rowLength = scanner.nextInt();

        System.out.print("Sütun sayısını girin: ");
        colLength = scanner.nextInt();

        this.board = new String[rowLength][colLength];
        this.boardHidden = new String[rowLength][colLength];
        this.mines = (board.length * board[0].length) / 4;
        this.moves = (board.length * board[0].length) - mines;

        generateBoard();
        generateBombs(mines);
        generateInfos();
      //  debug();
        printGame();
        runGame(scanner);

    }

    private void runGame(Scanner scanner) {
        while (!isGameOver) {
            if (moves == 0) {
                System.out.println("\033[38;5;155m" + "Tebrikler, kazandınız!" + "\033[0m");
                break;
            }

            int row, col;
            System.out.print("Lütfen Satır girin (R): ");
            row = scanner.nextInt()-1;
            System.out.print("Lütfen Sütun girin (C): ");
            col = scanner.nextInt()-1;
            if (row > rowLength || col > colLength
                    || row < 0  || colLength < 0) {
                System.out.println("Girdiğiniz parametreler hatalı. Maks R:" + rowLength + " Max C:" + colLength);
                continue;
            }

            if (board[row][col].equalsIgnoreCase("*")) {
                System.out.println("\033[38;5;9m" + "Kaybettiniz." + "\033[0m");
                isGameOver = true;
                break;
            }
            else {
                if (board[row][col].equalsIgnoreCase("-"))
                    boardHidden[row][col] = "0";
                else
                    boardHidden[row][col] = board[row][col];

                printGame();
            }
            moves--;
        }
    }

    private void generateBoard() {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = "-";
                boardHidden[row][col] = "-";
            }
    }

    private boolean generateBombs(int mineAmount) {
        if (mineAmount == 0)
            return true;

        for (int i = 0; i < mines; i++) {
            int x = new Random().nextInt(board.length);
            int y = new Random().nextInt(board[0].length);

            if (board[x][y].equalsIgnoreCase("-")) {
                board[x][y] = "*";
                break;
            }
        }
        return generateBombs(mineAmount-1);
    }

    private void generateInfos() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (board[i][k].equalsIgnoreCase("*")) {
                    for (int check = 0; check < 8; check++) {
                        try {
                            switch (check) {
                                case 0:
                                    infoStructure(i-1, k-1);
                                    break;
                                case 1:
                                    infoStructure(i-1, k);
                                    break;
                                case 2:
                                    infoStructure(i-1, k+1);
                                    break;
                                case 3:
                                    infoStructure(i, k-1);
                                    break;
                                case 4:
                                    infoStructure(i, k+1);
                                    break;
                                case 5:
                                    infoStructure(i+1, k-1);
                                    break;
                                case 6:
                                    infoStructure(i+1, k);
                                    break;
                                case 7:
                                    infoStructure(i+1, k+1);
                                    break;
                            }
                        }
                        catch (IndexOutOfBoundsException e) { continue; }
                    }
                }
                else continue;
            }
        }
    }

    private void infoStructure(int row, int col) throws IndexOutOfBoundsException {
        if (board[row][col].equalsIgnoreCase("-"))
            board[row][col] = "1";
        else if (board[row][col].equalsIgnoreCase("*"))
            return;
        else {
            int newValue = Integer.valueOf(board[row][col]) + 1;
            board[row][col] = String.valueOf(newValue);
        }
    }

    private void printGame() {
        System.out.println();
        for (int i = 1; i <= board.length; i ++) {
            if (i == 1)
                System.out.print("\033[48;5;36m\033[38;5;255mR\\C " + i + " ");
            else if (i == board.length)
                System.out.print(" " + i + " \033[0m");
            else
                System.out.print(" " + i + " ");
        }
        System.out.println();

        for (int i = 0; i < boardHidden.length; i++) {
            for (int k = 0; k < boardHidden[i].length; k++) {
                if (k == 0)
                    System.out.print("\033[48;5;36m\033[38;5;255m " + (i+1) + " \033[0m");
                System.out.print(" " + boardHidden[i][k] + " ");
            }
            System.out.println();
        }

    }
/*
    private void debug() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (k == 0)
                    System.out.print("\033[48;5;36m\033[38;5;255m " + (i + 1) + " \033[0m");
                System.out.print(" " + board[i][k] + " ");
            }
            System.out.println();
        }
    }
    */
}
