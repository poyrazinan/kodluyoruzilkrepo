package tr.com.poyrazinan.adventure.game.objects.locs;

import lombok.Getter;
import lombok.Setter;
import tr.com.poyrazinan.adventure.game.Main;
import tr.com.poyrazinan.adventure.game.objects.Location;
import tr.com.poyrazinan.adventure.game.objects.locs.normal.Store;
import tr.com.poyrazinan.adventure.game.objects.monsters.Monster;
import tr.com.poyrazinan.adventure.game.objects.monsters.types.Bear;
import tr.com.poyrazinan.adventure.game.objects.monsters.types.Snake;
import tr.com.poyrazinan.adventure.game.objects.monsters.types.Vampire;
import tr.com.poyrazinan.adventure.game.objects.monsters.types.Zombie;
import tr.com.poyrazinan.adventure.game.objects.player.Player;
import tr.com.poyrazinan.adventure.game.Color;

import java.util.Random;

@Setter
@Getter
public abstract class BattleLoc extends Location {

    private Monster monster;
    private String item, name;
    private int monsterId;

    public BattleLoc(Monster monster, String item, Player player, String name) {
        super(name, player);
        this.monster = monster;
        this.item = item;
        this.name = name;
        if (name.equals("Cave"))
            setMonsterId(1);
        else if (name.equals("Forest"))
            setMonsterId(2);
        else if (name.equals("River"))
            setMonsterId(3);
        else
            setMonsterId(4);
    }


    @Override
    public boolean onLocation() {
        int latestHp;
        boolean status = true;
        while (monster.getAmount() > 0) {
            getPlayer().printStats();
            System.out.println(Color.ANSI_RED + monster.getAmount() + " Monster(s) remaining...");
            int selection;
            do {
                System.out.print(Color.ANSI_PURPLE + "Type 0 for flee and 1 for next monster: ");
                selection = Main.scanner.nextInt();
                if (selection < 0 || selection > 1)
                    System.out.println("Please enter a valid selection.");
            } while (selection < 0 || selection > 1);

            System.out.println();
            if (selection == 0) {
                System.out.println(Color.ANSI_RED + "You have fled." + Color.ANSI_RESET);
                return true;
            }

            latestHp = combat();
            if (latestHp < 1) {
                status = false;
                break;
            }
            System.out.println(Color.ANSI_GREEN + "You have successfully killed Monster.");
        }

        if (!status)
            return false;

        System.out.println(Color.ANSI_GREEN + "You have successfully cleared " + name);

        if (!getPlayer().getInventory().getTrophyStatus(this)) {
            boolean itemStatus = getPlayer().getInventory().attemptTrophy(this);
            if (itemStatus)
                System.out.println(Color.ANSI_GREEN + "You have successfully gained " + getItem());
            else
                System.out.println(Color.ANSI_RED + "You couldn't gained " + getItem());

            if (getPlayer().getInventory().isFood() &&
                    getPlayer().getInventory().isWater() &&
                    getPlayer().getInventory().isFirewood()) {
                    System.out.println(Color.ANSI_GREEN
                            + Color.ANSI_BLACK_BACKGROUND + "You WIN! Gratz! Type anything for close the game");
                    Main.scanner.next();
                return false;
            }
        }
        return true;
    }

    public int combat() {
        int damage = 0, health = 0, price = 0;
        switch (monsterId) {
            case 1:
                damage = Zombie.damage;
                health = Zombie.health;
                price = Zombie.price;
                break;
            case 2:
                damage = Vampire.damage;
                health = Vampire.health;
                price = Vampire.price;
                break;
            case 3:
                damage = Bear.damage;
                health = Bear.health;
                price = Bear.price;
                break;
            case 4:
                Snake snake = new Snake(1, 1);
                damage = snake.getDamage();
                health = snake.getHealth();
                price = 0;
            default:
                break;
        }
        int reduction = getPlayer().getInventory().getArmor().getStat();
        damage -= reduction;
        if (damage < 0)
            damage = 0;

        double change = new Random().nextDouble();
        while (true) {
            if (change < 0.5)
                health -= getPlayer().getDamage();
            else {
                System.out.println(Color.ANSI_RED + "Monster striked first and dealt first damage. (-" + damage + ")");
                change = 0.1;
            }

            if (health < 1) {
                monster.setAmount(monster.getAmount() - 1);
                return reward(price);
            } else {
                getPlayer().setHealth(getPlayer().getHealth() - damage);
                if (getPlayer().getHealth() < 1)
                    return 0;
            }

        }
    }

    private int reward(int price) {
        if (price < 1) {
            Snake snake = new Snake();
            if (snake.getType().equals(Snake.RewardType.Armor)) {
                if (Store.buy(1, true, getPlayer()))
                    System.out.println(Color.ANSI_GREEN + "You have upgraded your Armor for free!");
                else
                    System.out.println(Color.ANSI_RED + "You have found a Armor upgrade but it's max level.");
            }
            else if (snake.getType().equals(Snake.RewardType.Weapon)) {
                if (Store.buy(2, true, getPlayer()))
                    System.out.println(Color.ANSI_GREEN + "You have upgraded your Weapon for free!");
                else
                    System.out.println(Color.ANSI_RED + "You have found a Weapon upgrade but it's max level.");
            }
            else if (snake.getType().equals(Snake.RewardType.Money)) {
                getPlayer().setMoney(getPlayer().getMoney() + snake.getPrice());
                System.out.println(Color.ANSI_YELLOW + "Money Updated: " + getPlayer().getMoney() + "+" + snake.getPrice());
            }
            else {
                System.out.println(Color.ANSI_RED + "This Monster is empty.");
            }
        }
        else {
            getPlayer().setMoney(getPlayer().getMoney() + price);
            System.out.println(Color.ANSI_YELLOW + "Money Updated: " + getPlayer().getMoney() + "+" + price);
        }
        return getPlayer().getHealth();
    }

}
