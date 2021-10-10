package tr.com.poyrazinan.adventure.game.objects.locs.battle;

import tr.com.poyrazinan.adventure.game.objects.locs.BattleLoc;
import tr.com.poyrazinan.adventure.game.objects.monsters.types.Zombie;
import tr.com.poyrazinan.adventure.game.objects.player.Player;

public class Cave extends BattleLoc {

    public Cave(Player player) {
        super(new Zombie(1, 3), "Food", player, "Cave");
    }
}
