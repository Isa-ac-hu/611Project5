//File Name: Item.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: An abstract class representing anything that a hero can hold in their inventory
public abstract class Item {
    private String name;
    private int cost;
    private int requiredLevel;
    public Item(String name, int cost, int requiredLevel){
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getCost(){
        return cost;
    }
    public void setCost(int cost){
        this.cost = cost;
    }

    public int getRequiredLevel(){
        return requiredLevel;
    }
    public void setRequiredLevel(int requiredLevel){
        this.requiredLevel = requiredLevel;
    }
    public String toString(){
        return name;

    }
}
