package tr.com.poyrazinan.adventure.game.objects.monsters;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Monster {

    private int amount;

    public Monster(int min, int max) {
        amount = new Random().nextInt(max+1-min)+min;
    }

}
