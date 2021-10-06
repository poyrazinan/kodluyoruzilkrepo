# Adventure Game

## Kodluyoruz Back-End Java Eğitimi 070

Bu repo [Kodluyoruz](https://www.kodluyoruz.org) Back-End Java Eğitiminde
oluşturduğum projelerdendir.

# Game
## Explanation:
You have to collect all the trophies. They are all lies in deep dungeons.
There is 3 trophy in 3 region. Which is Cave, Forest and River.
Each region has own Monster, reward scale and feature.
Once you get a trophy from a region, you cannot enter the place again. Regions listed below:
### Cave:
* Cave has Food trophy and zombies lives here. (Damage: 3, Health: 10, Money: 4)
### Forest:
* Forest has Firewood trophy and Vampires lives here. (Damage: 4, Health: 14, Money:7)
### River:
* River has Water trophy and Bears lives here. (Damage: 7, Health: 20, Money: 12)
### Mine:
* Mine don't have any trophy and Snakes lives here. (Damage: 3-6, Health: 12, Money: ?)
* Mine can drop Armor/Weapon upgrade, Money or nothing by your change.
### SafeHouse:
* You can restore your health in here.
### Shop:
* You can upgrade your Armor/Weapon here.

### Details:
* Mobs can strike you first with %50 change.
* You can acquire trophy with %50 change.
* You can flee a region before every fight.
* Game automatically finish when you collect all the trophies.

## Dependencies:
* Lombok
    * Version:  1.18.20
    * [Github](https://github.com/projectlombok/lombok "Github")
* Jetbrains Annotations
    * Version: 22.0.0
    * [Github](https://github.com/JetBrains/java-annotations "Github")

## UML Diagram:
![](class-diagram.jpg)