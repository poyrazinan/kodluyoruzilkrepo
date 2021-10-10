package tr.com.poyrazinan.adventure.game.objects.monsters.types;

import tr.com.poyrazinan.adventure.game.objects.monsters.Monster;

public class Zombie extends Monster {

    public static final int id = 1,
            damage = 3,
            health = 10,
            price = 4;

    public Zombie(int minAmount, int maxAmount) {
        super(minAmount, maxAmount);
    }
}
