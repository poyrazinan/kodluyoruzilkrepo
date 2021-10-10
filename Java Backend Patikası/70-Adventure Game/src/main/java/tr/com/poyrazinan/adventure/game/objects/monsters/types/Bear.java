package tr.com.poyrazinan.adventure.game.objects.monsters.types;

import tr.com.poyrazinan.adventure.game.objects.monsters.Monster;

public class Bear extends Monster {

    public static final int id = 3,
            damage = 7,
            health = 20,
            price = 12;

    public Bear(int minAmount, int maxAmount) {
        super(minAmount, maxAmount);
    }
}
