package tr.com.poyrazinan.adventure.game.objects.locs.battle;

import tr.com.poyrazinan.adventure.game.objects.locs.BattleLoc;
import tr.com.poyrazinan.adventure.game.objects.monsters.types.Snake;
import tr.com.poyrazinan.adventure.game.objects.player.Player;

public class Mine extends BattleLoc {

    public Mine(Player player) {
        super(new Snake(1, 5), "Random", player, "Mine");
    }

}
