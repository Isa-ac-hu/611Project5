//File Name: SpellCreator.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A factory class for the creation of new spell objects, based on the specifications in the text files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class SpellCreator implements ItemCreator {
    private static ArrayList<Spell> listSpells;

    public SpellCreator() {
        listSpells = new ArrayList<>();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("FireSpells.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (pastFirstLine) {
                    String[] attributes = line.split("\\s+");
                    String name = attributes[0].trim();
                    int cost = Integer.parseInt(attributes[1].trim());
                    int requiredLevel = Integer.parseInt(attributes[2].trim());
                    int damage = Integer.parseInt(attributes[3].trim());
                    int manaCost = Integer.parseInt(attributes[4].trim());
                    String type = "Fire";
                    Spell spell = new Spell(name, cost, requiredLevel, damage, manaCost, type);
                    listSpells.add(spell);
                }

                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("IceSpells.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (pastFirstLine) {
                    String[] attributes = line.split("\\s+");
                    String name = attributes[0].trim();
                    int cost = Integer.parseInt(attributes[1].trim());
                    int requiredLevel = Integer.parseInt(attributes[2].trim());
                    int damage = Integer.parseInt(attributes[3].trim());
                    int manaCost = Integer.parseInt(attributes[4].trim());
                    String type = "Ice";
                    Spell spell = new Spell(name, cost, requiredLevel, damage, manaCost, type);
                    listSpells.add(spell);
                }

                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("LightningSpells.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (pastFirstLine) {
                    String[] attributes = line.split("\\s+");
                    String name = attributes[0].trim();
                    int cost = Integer.parseInt(attributes[1].trim());
                    int requiredLevel = Integer.parseInt(attributes[2].trim());
                    int damage = Integer.parseInt(attributes[3].trim());
                    int manaCost = Integer.parseInt(attributes[4].trim());
                    String type = "Lightning";
                    Spell spell = new Spell(name, cost, requiredLevel, damage, manaCost, type);
                    listSpells.add(spell);
                }

                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Spell getSpell(String name) {
        for (Spell spell : listSpells) {
            if (spell.getName().equalsIgnoreCase(name)) {
                // Create a new object that contains the spell
                return new Spell(spell.getName(), spell.getCost(), spell.getRequiredLevel(), spell.getDamage(), spell.getManaCost(), spell.getType());
            }
        }
        return null; // Return null if the spell is not found
    }

    // This method returns a random spell from the listSpells ArrayList
    public Spell getRandomSpell() {
        Random random = new Random();
        Spell spell = listSpells.get(random.nextInt(listSpells.size()));
        return new Spell(spell.getName(), spell.getCost(), spell.getRequiredLevel(), spell.getDamage(), spell.getManaCost(), spell.getType());
    }

    @Override
    public Item retrieveItem() {
        return getRandomSpell();
    }
}