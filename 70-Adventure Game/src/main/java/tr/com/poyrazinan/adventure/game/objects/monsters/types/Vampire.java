package tr.com.poyrazinan.adventure.game.objects.monsters.types;

import tr.com.poyrazinan.adventure.game.objects.monsters.Monster;

public class Vampire extends Monster {

    public static final int id = 2,
            damage = 4,
            health = 14,
            price = 7;

    public Vampire(int minAmount, int maxAmount) {
        super(minAmount, maxAmount);
    }
}
