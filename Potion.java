//File Name: Potion.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: An item object that can be used by players to increase certain attributes, buyable at markets
class Potion extends Item {
    private int attributeIncrease;
    private String attributeAffected;

    public Potion(String name, int cost, int requiredLevel, int attributeIncrease, String attributeAffected) {
        super(name, cost, requiredLevel);
        this.attributeIncrease = attributeIncrease;
        this.attributeAffected = attributeAffected;
    }

    public int getAttributeIncrease() {
        return attributeIncrease;
    }

    public String getAttributeAffected() {
        return attributeAffected;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() +
                ", Cost: " + super.getCost() +
                ", Required Level: " + super.getRequiredLevel() +
                ", Attribute Increase: " + attributeIncrease +
                ", Attribute Affected: " + attributeAffected;
    }
}