package tr.com.poyrazinan.adventure.game.objects;

import lombok.Getter;
import lombok.Setter;
import tr.com.poyrazinan.adventure.game.objects.player.Player;

@Setter
@Getter
public abstract class Location {

    private Player player;
    private String name;

    public Location(String name, Player player) {
        this.name = name;
        this.player = player;
    }

    public abstract boolean onLocation();
}
