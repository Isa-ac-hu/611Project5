//File Name: WeaponCreator.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A factory for building weapons, based on the specifications of the text file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class WeaponCreator implements ItemCreator{

    private static ArrayList<Weapon> listWeapons;
    public WeaponCreator(){
        listWeapons = new ArrayList<>();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Weaponry.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(pastFirstLine){
                    String[] attributes = line.split("\\s+");
                    String name = attributes[0].trim();
                    int cost = Integer.parseInt(attributes[1].trim());
                    int level = Integer.parseInt(attributes[2].trim());
                    int damage = Integer.parseInt(attributes[3].trim());
                    int requiredHands = Integer.parseInt(attributes[4].trim());
                    Weapon weapon = new Weapon(name, cost, level, damage, requiredHands);
                    listWeapons.add(weapon);
                }

                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Weapon getWeapon(String name) {
        for (Weapon weapon : listWeapons) {
            if (weapon.getName().equalsIgnoreCase(name)) {
                //Create a new object that contains the weapon
                return new Weapon(weapon.getName(), weapon.getCost(), weapon.getRequiredLevel(), weapon.getDamage(), weapon.getRequiredHands());
            }
        }
        return null; // Return null if the weapon is not found
    }

    // This method returns a random weapon from the listWeapons ArrayList
    public Weapon getRandomWeapon() {
        Random random = new Random();
        Weapon weapon = listWeapons.get(random.nextInt(listWeapons.size()));
        return new Weapon(weapon.getName(), weapon.getCost(), weapon.getRequiredLevel(), weapon.getDamage(), weapon.getRequiredHands());
    }

    @Override
    public Item retrieveItem() {
        return getRandomWeapon();
    }
}