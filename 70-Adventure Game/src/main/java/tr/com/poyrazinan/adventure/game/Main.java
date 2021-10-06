package tr.com.poyrazinan.adventure.game;

import tr.com.poyrazinan.adventure.game.objects.Game;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        Game game = new Game();
        game.start();
    }

}
