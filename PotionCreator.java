//File Name: PotionCreator.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A factory class for the creation of potions, based on the stats specified in the text files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class PotionCreator implements ItemCreator {
    private static ArrayList<Potion> listPotions;

    public PotionCreator() {
        listPotions = new ArrayList<>();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Potions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (pastFirstLine) {
                    String[] attributes = line.split("\\s+");
                    String name = attributes[0].trim();
                    int cost = Integer.parseInt(attributes[1].trim());
                    int requiredLevel = Integer.parseInt(attributes[2].trim());
                    int attributeIncrease = Integer.parseInt(attributes[3].trim());
                    String attributeAffected = attributes[4].trim();
                    Potion potion = new Potion(name, cost, requiredLevel, attributeIncrease, attributeAffected);
                    listPotions.add(potion);
                }

                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Potion getPotion(String name) {
        for (Potion potion : listPotions) {
            if (potion.getName().equalsIgnoreCase(name)) {
                // Create a new object that contains the potion
                return new Potion(potion.getName(), potion.getCost(), potion.getRequiredLevel(), potion.getAttributeIncrease(), potion.getAttributeAffected());
            }
        }
        return null; // Return null if the potion is not found
    }

    // This method returns a random potion from the listPotions ArrayList
    public Potion getRandomPotion() {
        Random random = new Random();
        Potion potion = listPotions.get(random.nextInt(listPotions.size()));
        return new Potion(potion.getName(), potion.getCost(), potion.getRequiredLevel(), potion.getAttributeIncrease(), potion.getAttributeAffected());
    }

    @Override
    public Item retrieveItem() {
        return getRandomPotion();
    }
}