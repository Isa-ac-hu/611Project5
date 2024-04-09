//File Name: ArmorCreator.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description:a factory that facilitates the creation of armor objects, based on the templates of the text file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class ArmorCreator implements ItemCreator {
    private static ArrayList<Armor> listArmors;

    public ArmorCreator() {
        listArmors = new ArrayList<>();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Armory.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (pastFirstLine) {
                    String[] attributes = line.split("\\s+");
                    String name = attributes[0].trim();
                    int cost = Integer.parseInt(attributes[1].trim());
                    int requiredLevel = Integer.parseInt(attributes[2].trim());
                    int damageReduction = Integer.parseInt(attributes[3].trim());
                    Armor armor = new Armor(name, cost, requiredLevel, damageReduction);
                    listArmors.add(armor);
                }

                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Armor getArmor(String name) {
        for (Armor armor : listArmors) {
            if (armor.getName().equalsIgnoreCase(name)) {
                // Create a new object that contains the armor
                return new Armor(armor.getName(), armor.getCost(), armor.getRequiredLevel(), armor.getDamageReduction());
            }
        }
        return null; // Return null if the armor is not found
    }

    // This method returns a random armor from the listArmors ArrayList
    public Armor getRandomArmor() {
        Random random = new Random();
        Armor armor = listArmors.get(random.nextInt(listArmors.size()));
        return new Armor(armor.getName(), armor.getCost(), armor.getRequiredLevel(), armor.getDamageReduction());
    }

    @Override
    public Item retrieveItem() {
        return getRandomArmor();
    }
}