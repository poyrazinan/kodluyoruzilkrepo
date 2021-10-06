package tr.com.poyrazinan.adventure.game.objects.player.inventory;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import tr.com.poyrazinan.adventure.game.objects.locs.BattleLoc;
import tr.com.poyrazinan.adventure.game.objects.player.inventory.types.Armor;
import tr.com.poyrazinan.adventure.game.objects.player.inventory.types.Weapon;

import java.util.Random;

@Getter
@Setter
public class Inventory {

    private Armor armor = new Armor();
    private Weapon weapon = new Weapon();
    private boolean water = false,
            food = false,
            firewood = false;

    public Inventory() {}

    public boolean attemptTrophy(@NotNull BattleLoc loc) {
        boolean result = (new Random().nextDouble() <= 0.5) ? true : false;

        switch (loc.getItem()) {
            case "Water":
                if (!water)
                    water = result;
                break;
            case "Food":
                if (!food)
                    food = result;
                break;
            case "Firewood":
                if (!firewood)
                    firewood = result;
                break;
            default:
                return false;
        }
        return result;
    }

    public boolean getTrophyStatus(@NotNull BattleLoc loc) {
        switch (loc.getItem()) {
            case "Water":
                return water;
            case "Food":
                return food;
            case "Firewood":
                return firewood;
            case "Random":
                return true;
        }
        return false;
    }

}
