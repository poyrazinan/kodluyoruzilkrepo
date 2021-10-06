package tr.com.poyrazinan.adventure.game.objects.locs.normal;

import lombok.Getter;
import tr.com.poyrazinan.adventure.game.Color;
import tr.com.poyrazinan.adventure.game.Main;
import tr.com.poyrazinan.adventure.game.objects.locs.NormalLoc;
import tr.com.poyrazinan.adventure.game.objects.player.Player;
import tr.com.poyrazinan.adventure.game.objects.player.inventory.types.Armor;
import tr.com.poyrazinan.adventure.game.objects.player.inventory.types.Items;
import tr.com.poyrazinan.adventure.game.objects.player.inventory.types.Weapon;

@Getter
public class Store extends NormalLoc {

    private static final Weapon[] weaponList = Weapon.createWeapons();
    private static final Armor[] armorList = Armor.createArmors();

    public Store(Player player) {
        super("Store", player);
    }

    @Override
    public boolean onLocation() {

        int mainSelection = mainMenu();

        if (mainSelection == 1 || mainSelection == 2)
            subMenuHandler(mainSelection);

        else if (mainSelection == 3) {
            getPlayer().printStats();
            getPlayer().printChapters();
        }

        return true;
    }

    private int mainMenu() {
        System.out.println();
        System.out.println(Color.ANSI_WHITE_BACKGROUND + Color.ANSI_BLACK
                + "Id    Name    Level    Price    Info                             " + Color.ANSI_RESET);
        System.out.println(Color.ANSI_CYAN + "1)    Armor     "
                + getPlayer().getInventory().getArmor().getId() + "        "
                + getPlayer().getInventory().getArmor().getPrice()
                + "      You can upgrade your armor here.");
        System.out.println("2)    Weapon    "
                + getPlayer().getInventory().getWeapon().getId() + "        "
                + getPlayer().getInventory().getWeapon().getPrice()
                + "      You can upgrade your weapon here.");
        System.out.println("3)    Stats     " + "          "
                + "      Prints your stats.");
        System.out.println("4)    Quit     " + "          "
                + "       Closes shop.");

        int selection;
        do {
            System.out.print(Color.ANSI_GREEN + "Select Menu: " + Color.ANSI_RESET);
            selection = Main.scanner.nextInt();
            if (selection < 1 || selection > 4)
                System.out.println("Please enter a valid id.");
        } while (selection < 1 || selection > 4);

        return selection;
    }

    private void subMenuHandler(int menuType) {
        System.out.println();
        System.out.println(Color.ANSI_WHITE_BACKGROUND + Color.ANSI_BLACK
                + "Id    Name    Level    Prices    Bonus Stat            " + Color.ANSI_RESET);
        for(int i = 1; i < 4; i++) {
            String color;
            if ((menuType == 1 && getPlayer().getInventory().getArmor().getId() < i)
                    || (menuType == 2 && getPlayer().getInventory().getWeapon().getId() < i))
                color = Color.ANSI_RED;
            else
                color = Color.ANSI_GREEN;

            if (menuType == 1)
                System.out.println(color
                        + i + ")    "
                        + this.armorList[i].getName() + "   "
                        + i + "        "
                        + this.armorList[i].getPrice() + "      +"
                        + this.armorList[i].getStat() + " Reduction");
            else
                System.out.println(color
                        + i + ")    "
                        + this.weaponList[i].getName() + "    "
                        + i + "        "
                        + this.weaponList[i].getPrice() + "      +"
                        + this.weaponList[i].getStat() + " Damage");
        }

        int selection;
        do {
            System.out.print(Color.ANSI_PURPLE + "Type 1 for upgrade and 0 for back: ");
            selection = Main.scanner.nextInt();
            if (selection < 0 || selection > 1)
                System.out.println(Color.ANSI_RED + "Please enter a valid input.");
        } while (selection < 0 || selection > 1);

        if (selection == 1)
            buy(menuType, false, getPlayer());

    }

    public static boolean buy(int menuType, boolean free, Player player) {
        if ((menuType == 1 && player.getInventory().getArmor().getId() < 3)
                        || (menuType == 2 && player.getInventory().getWeapon().getId() < 3) ) {
            int playerMoney = player.getMoney();
            Items item;
            if (menuType == 1)
                item = Store.armorList[player.getInventory().getArmor().getId()+1];
            else
                item = Store.weaponList[player.getInventory().getWeapon().getId()+1];

            if (playerMoney >= item.getPrice() || free) {

                if (!free)
                    player.setMoney(playerMoney-item.getPrice());

                if (menuType == 1)
                    player.getInventory().setArmor((Armor) item);
                else
                    player.getInventory().setWeapon((Weapon) item);

                player.updatePlayer();
                System.out.println(Color.ANSI_GREEN + "Upgrade success.");
            }
            else
                System.out.println(Color.ANSI_RED + "You don't have enough money to upgrade.");
        }
        else
            return false;

        return true;
    }

}
