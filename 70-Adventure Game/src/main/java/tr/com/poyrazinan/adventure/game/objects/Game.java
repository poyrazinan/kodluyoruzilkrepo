package tr.com.poyrazinan.adventure.game.objects;

import tr.com.poyrazinan.adventure.game.Main;
import tr.com.poyrazinan.adventure.game.objects.locs.battle.Cave;
import tr.com.poyrazinan.adventure.game.objects.locs.battle.Forest;
import tr.com.poyrazinan.adventure.game.objects.locs.battle.Mine;
import tr.com.poyrazinan.adventure.game.objects.locs.battle.River;
import tr.com.poyrazinan.adventure.game.objects.locs.normal.SafeHouse;
import tr.com.poyrazinan.adventure.game.objects.locs.normal.Store;
import tr.com.poyrazinan.adventure.game.objects.player.Player;
import tr.com.poyrazinan.adventure.game.Color;

public class Game {

    private Player player;
    private Location location = null;

    public Game() {}

    public void start() {
        System.out.print(Color.ANSI_WHITE_BACKGROUND + Color.ANSI_BLACK +
                "Explanation: \n" +
                "* You have to collect all the trophies. They are all lies in deep dungeons.\n" +
                "* There is 3 trophy in 3 region. Which is Cave, Forest and River.\n" +
                "* Each region has own Monster, reward scale and feature.\n" +
                "* Once you get a trophy from a region, you cannot enter the place again. Regions listed below: \n" +
                "Cave: \n" +
                "* Cave has Food trophy and zombies lives here. (Damage: 3, Health: 10, Money: 4)\n" +
                "Forest: \n" +
                "* Forest has Firewood trophy and Vampires lives here. (Damage: 4, Health: 14, Money:7)\n" +
                "River: \n" +
                "* River has Water trophy and Bears lives here. (Damage: 7, Health: 20, Money: 12)\n" +
                "Mine: \n" +
                "* Mine don't have any trophy and Snakes lives here. (Damage: 3-6, Health: 12, Money: ?)\n" +
                "* Mine can drop Armor/Weapon upgrade, Money or nothing by your change.\n" +
                "SafeHouse: \n" +
                "* You can restore your health in here.\n" +
                "Shop: \n" +
                "* You can upgrade your Armor/Weapon here.\n" + Color.ANSI_RESET +
                Color.ANSI_PURPLE + "Enter your name when you are ready: " + Color.ANSI_RESET);
        String name = Main.scanner.nextLine();
        player = new Player(name);

        while (true) {
            location = null;
            System.out.println(Color.ANSI_PURPLE + "Regions:");
            System.out.println(Color.ANSI_RED + "Id   Name     Danger " + Color.ANSI_BLUE);
            printRegions();

            int selection;
            do {
                System.out.print(Color.ANSI_GREEN + "Select Region/Info: " + Color.ANSI_RESET);
                selection = Main.scanner.nextInt();
                if (selection < 1 || selection > 7)
                    System.out.println("Please enter a valid id.");

                if ((selection == 3 && player.getInventory().isFood()) ||
                        (selection == 4 && player.getInventory().isFirewood()) ||
                        (selection == 5 && player.getInventory().isWater())) {

                        selection = 0;
                        System.out.println(Color.ANSI_RED + " You cannot enter this place anymore because you have gained trophy.");
                }
            } while (selection < 1 || selection > 7);

            switch (selection) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Store(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                case 7:
                    System.out.println();
                    player.printStats();
                    player.printChapters();
                    break;
            }

            // Finish game
            if (selection != 7 && !location.onLocation()) {
                System.out.println(Color.ANSI_RED + "Game over." + Color.ANSI_RESET);
                break;
            }
        }
    }

    private void printRegions() {
        System.out.println("1  SafeHouse    "
                + Color.ANSI_GREEN_BACKGROUND + "  " + Color.ANSI_RESET + Color.ANSI_BLUE);
        System.out.println("2  Shop         "
                + Color.ANSI_GREEN_BACKGROUND + "  " + Color.ANSI_RESET + Color.ANSI_BLUE);
        System.out.println("3  Cave         "
                + Color.ANSI_RED_BACKGROUND + "  " + Color.ANSI_RESET + Color.ANSI_BLUE);
        System.out.println("4  Jungle       "
                + Color.ANSI_RED_BACKGROUND + "  " + Color.ANSI_RESET + Color.ANSI_BLUE);
        System.out.println("5  River        "
                + Color.ANSI_RED_BACKGROUND + "  " + Color.ANSI_RESET + Color.ANSI_BLUE);
        System.out.println("6  Mine         "
                + Color.ANSI_RED_BACKGROUND + "  " + Color.ANSI_RESET + Color.ANSI_BLUE);
        System.out.println("7  Information  "
                + Color.ANSI_YELLOW_BACKGROUND + "  " + Color.ANSI_RESET);
    }
}
