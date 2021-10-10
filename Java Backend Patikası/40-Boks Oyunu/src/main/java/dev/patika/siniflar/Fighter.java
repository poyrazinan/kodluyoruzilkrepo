package dev.patika.siniflar;

import org.jetbrains.annotations.NotNull;

public class Fighter {

    String name;
    int damage, health, weight;
    double dodge;

    public Fighter(String name, int damage, int health, int weight, double dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
    }

    public int hit(@NotNull Fighter fother) {
        System.out.println("------------");
        System.out.println(this.name + " => " + fother.name + " " +  this.damage + " hasar vurdu.");

        if (fother.dodge()) {
            System.out.println(fother.name + " gelen hasarı savurdu.");
            return fother.health;
        }

        if (fother.health - this.damage < 0)
            return 0;

        return fother.health - this.damage;
    }

    public boolean dodge() {
        double randomValue = Math.random() * 100;  //0.0 to 99.9
        return randomValue <= this.dodge;
    }

}
