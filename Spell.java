//File Name: Spell.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A type of single use item that can inflict massive damage on monsters
class Spell extends Item {
    private int damage;
    private int manaCost;
    private String type;

    // Constructor
    public Spell(String name, int cost, int requiredLevel, int damage, int manaCost, String type) {
        super(name, cost, requiredLevel);
        this.damage = damage;
        this.manaCost = manaCost;
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getType() {
        return type;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Name: " + super.getName() +
                ", Cost: " + super.getCost() +
                ", Required Level: " + super.getRequiredLevel() +
                ", Damage: " + damage +
                ", Mana Cost: " + manaCost +
                ", Type: " + type;
    }
}