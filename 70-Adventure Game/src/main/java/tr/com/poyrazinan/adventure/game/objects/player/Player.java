package tr.com.poyrazinan.adventure.game.objects.player;

import lombok.Getter;
import lombok.Setter;
import tr.com.poyrazinan.adventure.game.Main;
import tr.com.poyrazinan.adventure.game.objects.player.inventory.Inventory;
import tr.com.poyrazinan.adventure.game.Color;

@Getter
@Setter
public class Player {

    private Inventory inventory;
    private int damage, damageBase, reduction = 0, health, maxHealth, money;
    private String name;

    public Player(String name) {
        this.name = name;
        inventory = new Inventory();
        selectChar();
    }

    public void printStats() {
        System.out.println(Color.ANSI_BLACK + Color.ANSI_WHITE_BACKGROUND + " Stat       Values   " + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLACK + Color.ANSI_WHITE_BACKGROUND + " Name      "
                + Color.ANSI_RESET + Color.ANSI_BLUE + "  " + name + "  " + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLACK + Color.ANSI_WHITE_BACKGROUND + " Money     "
                + Color.ANSI_RESET + Color.ANSI_YELLOW + "    " + money + "     " + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLACK + Color.ANSI_WHITE_BACKGROUND + " Damage    "
                + Color.ANSI_RESET + Color.ANSI_RED + "  " + damageBase + "(+" + inventory.getWeapon().getStat() + ")   " + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLACK + Color.ANSI_WHITE_BACKGROUND + " Health    "
                + Color.ANSI_RESET + Color.ANSI_GREEN + "  " + health + "/" + maxHealth + "   " + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLACK + Color.ANSI_WHITE_BACKGROUND + " Reduction "
                + Color.ANSI_RESET + Color.ANSI_CYAN + "   +" +  inventory.getArmor().getStat() + "     " + Color.ANSI_RESET);
    }

    public void updatePlayer() {
        int weaponStat = inventory.getWeapon().getStat();
        if (damageBase + weaponStat != damage)
            damage = damageBase+weaponStat;

        reduction = inventory.getArmor().getStat();
    }

    public void printChapters() {
        System.out.println(Color.ANSI_RED + "Treasure Status:");

        System.out.print(Color.ANSI_YELLOW + "Food (Cave)       :");
        if (getInventory().isFood())
            System.out.println("  " + Color.ANSI_GREEN_BACKGROUND + "  " + Color.ANSI_RESET);
        else
            System.out.println("  " + Color.ANSI_RED_BACKGROUND + "  " + Color.ANSI_RESET);

        System.out.print(Color.ANSI_YELLOW + "Firewood (Forest) :");
        if (getInventory().isFirewood())
            System.out.println("  " + Color.ANSI_GREEN_BACKGROUND + "  " + Color.ANSI_RESET);
        else
            System.out.println("  " + Color.ANSI_RED_BACKGROUND + "  " + Color.ANSI_RESET);

        System.out.print(Color.ANSI_YELLOW + "Water (River)     :");
        if (getInventory().isWater())
            System.out.println("  " + Color.ANSI_GREEN_BACKGROUND + "  " + Color.ANSI_RESET);
        else
            System.out.println("  " + Color.ANSI_RED_BACKGROUND + "  " + Color.ANSI_RESET);

    }

    public void selectChar() {
        System.out.println(Color.ANSI_RED
                + "id " + " Character " + " Damage " + " Health " + " Money "
                + Color.ANSI_BLUE);
        for (int i = 1; i < 4; i++) {
            switch (i) {
                case 1:
                    System.out.println(i + ")" + "   Samurai   " + "  5   " + "   21   " + "   15   ");
                    break;
                case 2:
                    System.out.println(i + ")" + "   Ranger   " + "   7   " + "   18   " + "   20   ");
                    break;
                case 3:
                    System.out.println(i + ")" + "   Knight   " + "   8   " + "   24   " + "    5   " + Color.ANSI_RESET);
                    break;
            }
        }
        int selection;
        do {
            System.out.print(Color.ANSI_GREEN + "Select Character: " + Color.ANSI_RESET);
            selection = Main.scanner.nextInt();
            if (selection < 1 || selection > 3)
                System.out.println("Please enter a valid id.");
        } while (selection < 1 || selection > 3);

        System.out.println();

        switch (selection) {
            case 1:
                damage = 5;
                damageBase = 5;
                health = 21;
                maxHealth = 21;
                money = 15;
                break;
            case 2:
                damage = 7;
                damageBase = 7;
                health = 18;
                maxHealth = 18;
                money = 20;
                break;
            case 3:
                damage = 8;
                damageBase = 8;
                health = 24;
                maxHealth = 24;
                money = 5;
                break;
        }
    }

}
