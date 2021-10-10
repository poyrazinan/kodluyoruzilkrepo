package tr.com.poyrazinan.adventure.game.objects.player.inventory.types;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Armor extends Items {

    public Armor() {
        super("Yok", 0, 0, 0);
    }

    public static Armor[] createArmors() {
        Armor item1 = (Armor) Armor.builder()
                .name("Light  ")
                .id(1)
                .stat(1)
                .price(15)
                .build();

        Armor item2 = (Armor) Armor.builder()
                .name("Medium ")
                .id(2)
                .stat(3)
                .price(25)
                .build();

        Armor item3 = (Armor) Armor.builder()
                .name("Heavy  ")
                .id(3)
                .stat(5)
                .price(40)
                .build();

        return Items.createItems(item1, item2, item3);
    }
}
