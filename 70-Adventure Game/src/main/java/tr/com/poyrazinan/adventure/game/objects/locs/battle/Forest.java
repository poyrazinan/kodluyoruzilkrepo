package tr.com.poyrazinan.adventure.game.objects.locs.battle;

import tr.com.poyrazinan.adventure.game.objects.locs.BattleLoc;
import tr.com.poyrazinan.adventure.game.objects.monsters.types.Vampire;
import tr.com.poyrazinan.adventure.game.objects.player.Player;

public class Forest extends BattleLoc {

    public Forest(Player player) {
        super(new Vampire(1,3), "Firewood", player, "Forest");
    }
}
