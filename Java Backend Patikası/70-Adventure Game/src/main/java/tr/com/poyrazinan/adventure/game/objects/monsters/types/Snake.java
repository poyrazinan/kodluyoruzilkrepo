package tr.com.poyrazinan.adventure.game.objects.monsters.types;

import lombok.Getter;
import tr.com.poyrazinan.adventure.game.objects.monsters.Monster;

import java.util.Random;

@Getter
public class Snake extends Monster {

    private int id = 4,
            damage = 3,
            health = 12,
            price = 0;
    private RewardType type = RewardType.Null;

    public enum RewardType {Armor, Weapon, Money, Null}

    public Snake(int minAmount, int maxAmount) {
        super(minAmount, maxAmount);
        damage = new Random().nextInt(3)+3;
    }

    public Snake() {
        super(1, 1);
        double change = new Random().nextDouble();
        if (change < 0.15)
            type = RewardType.Weapon;
        else if (change < 0.3)
            type = RewardType.Armor;
        else if (change < 0.55) {
            type = RewardType.Money;
            double priceChange = new Random().nextDouble();
            if (priceChange < 0.2)
                price = 10;
            else if (priceChange < 0.3)
                price = 5;
            else
                price = 1;
        }
    }
}
