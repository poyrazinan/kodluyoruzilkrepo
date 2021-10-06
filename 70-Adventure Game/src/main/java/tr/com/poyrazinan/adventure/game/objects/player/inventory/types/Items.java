package tr.com.poyrazinan.adventure.game.objects.player.inventory.types;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class Items {

    private String name = "Yok";
    private int id = 0, stat = 0, price = 0;

    public Items(String name, int id, int stat, int price) {
        this.name = name;
        this.id = id;
        this.stat = stat;
        this.price = price;
    }

    protected static Weapon[] createItems(Weapon i1, Weapon i2, Weapon i3) {
        Weapon[] items = new Weapon[4];
        for (int i = 0; i < 4; i++)
            switch (i) {
                case 0:
                    items[i] = new Weapon();
                    break;
                case 1:
                    items[i] = i1;
                    break;
                case 2:
                    items[i] = i2;
                    break;
                case 3:
                    items[i] = i3;
                    break;
            }

        return items;
    }

    protected static Armor[] createItems(Armor i1, Armor i2, Armor i3) {
        Armor[] items = new Armor[4];
        for (int i = 0; i < 4; i++)
            switch (i) {
                case 0:
                    items[i] = new Armor();
                    break;
                case 1:
                    items[i] = i1;
                    break;
                case 2:
                    items[i] = i2;
                    break;
                case 3:
                    items[i] = i3;
                    break;
            }

        return items;
    }

}
