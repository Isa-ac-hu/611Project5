//File Name: Weapon.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class for representing the stats of a weapon
class Weapon extends Item{

    private int damage;
    private int requiredHands;

    public Weapon(String name, int cost, int requiredLevel, int damage, int requiredHands) {
        super(name, cost, requiredLevel);
        this.damage = damage;
        this.requiredHands = requiredHands;
    }

    public int getDamage() {
        return damage;
    }

    public int getRequiredHands() {
        return requiredHands;
    }

    @Override
    public String toString() {
        return
                "Name: " + super.getName() +
                ", Cost: " + super.getCost() +
                ", Required Level: " + super.getRequiredLevel() +
                ", Damage: " + damage +
                ", RequiredHands: " + requiredHands;
    }
}