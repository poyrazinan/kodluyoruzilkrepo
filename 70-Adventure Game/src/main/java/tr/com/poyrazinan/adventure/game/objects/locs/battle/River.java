package tr.com.poyrazinan.adventure.game.objects.locs.battle;

import tr.com.poyrazinan.adventure.game.objects.locs.BattleLoc;
import tr.com.poyrazinan.adventure.game.objects.monsters.types.Bear;
import tr.com.poyrazinan.adventure.game.objects.player.Player;

public class River extends BattleLoc {

    public River(Player player) {
        super(new Bear(1, 3), "Water", player, "River");
    }

}
