package tr.com.poyrazinan.adventure.game.objects.player.inventory.types;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Weapon extends Items {

    public Weapon() {
        super("Yok", 0, 0, 0);
    }

    public static Weapon[] createWeapons() {
        Weapon item1 = (Weapon) Weapon.builder()
                .name("Pistol")
                .id(1)
                .stat(2)
                .price(25)
                .build();

        Weapon item2 = (Weapon) Weapon.builder()
                .name("Sword ")
                .id(2)
                .stat(3)
                .price(35)
                .build();

        Weapon item3 = (Weapon) Weapon.builder()
                .name("Rifle ")
                .id(3)
                .stat(7)
                .price(45)
                .build();

        return Items.createItems(item1, item2, item3);
    }
}
