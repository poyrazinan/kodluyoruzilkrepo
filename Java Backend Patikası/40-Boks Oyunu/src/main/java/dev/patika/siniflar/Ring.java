package dev.patika.siniflar;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Ring {

    Fighter f1, f2;
    int minWeight, maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight)
                && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Kalan Can \t:" + f1.health);
        System.out.println(f2.name + " Kalan Can \t:" + f2.health);
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        } else if (f2.health == 0){
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        }

        return false;
    }

    public void run() {

        if (checkWeight()) {

            while (f1.health > 0 && f2.health > 0) {
                System.out.println("======== YENİ ROUND ===========");
                boolean isFirst = (new Random().nextDouble() <= 0.5);
                if (isFirst)
                    hitter(f1, f2);
                else
                    hitter(f2, f1);
            }

        }

        else
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");

    }

    public boolean hitter(@NotNull Fighter ft1, @NotNull Fighter ft2) {
        ft2.health = ft1.hit(ft2);
        if (isWin())
            return true;
        ft1.health = ft2.hit(ft1);
        if (isWin())
            return true;

        printScore();
        return false;
    }

}
