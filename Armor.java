//File Name: Armor.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class for representing armor stats
class Armor extends Item{
    private int damageReduction;

    public Armor(String name, int cost, int requiredLevel, int damageReduction) {
        super(name, cost, requiredLevel);
        this.damageReduction = damageReduction;
    }


    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }
    @Override
    public String toString() {
        return "Name: " + super.getName() +
                ", Cost: " + super.getCost() +
                ", Required Level: " + super.getRequiredLevel() +
                ", Damage Reduction: " + damageReduction;
    }
}