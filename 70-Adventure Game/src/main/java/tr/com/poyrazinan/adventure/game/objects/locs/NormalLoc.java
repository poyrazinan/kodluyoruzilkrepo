package tr.com.poyrazinan.adventure.game.objects.locs;

import lombok.Getter;
import tr.com.poyrazinan.adventure.game.objects.Location;
import tr.com.poyrazinan.adventure.game.objects.player.Player;

@Getter
public abstract class NormalLoc extends Location {

    public NormalLoc(String name, Player player) {
        super(name, player);
    }

    @Override
    public boolean onLocation() {
        return false;
    }

}
