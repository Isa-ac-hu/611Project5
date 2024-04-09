//File Name: Inventory.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class that contains an arraylist of items, to be held by the hero, with a convenient toString.
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory;

    public Inventory(){
        inventory = new ArrayList<>();
    }

    public Item get(int index){
        return inventory.get(index);
    }

    public void add(Item item){
        inventory.add(item);
    }
    public void remove(Item itemToRemove) {
        // Iterate over the inventory
        for (int i = 0; i < inventory.size(); i++) {
            // Check if the memory address of the item matches
            if (inventory.get(i).equals(itemToRemove)) {
                // Remove the item from the inventory
                inventory.remove(i);
                return; // Exit the method after removing the item
            }
        }
    }

    public int size(){
        return inventory.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inventory.size(); i++) {
            sb.append(i + 1).append(". ").append(inventory.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
