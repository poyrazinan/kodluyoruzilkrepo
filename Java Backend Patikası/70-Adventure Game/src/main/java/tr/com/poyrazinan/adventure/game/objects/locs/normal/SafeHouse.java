package tr.com.poyrazinan.adventure.game.objects.locs.normal;

import tr.com.poyrazinan.adventure.game.objects.locs.NormalLoc;
import tr.com.poyrazinan.adventure.game.objects.player.Player;
import tr.com.poyrazinan.adventure.game.Color;

public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super("SafeHouse", player);
    }

    @Override
    public boolean onLocation() {
        getPlayer().setHealth(getPlayer().getMaxHealth());
        System.out.println();
        System.out.println(Color.ANSI_YELLOW + "Welcome to safe house!");
        System.out.println("Health regenerated." + Color.ANSI_RESET);
        return true;
    }
}
