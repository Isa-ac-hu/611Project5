//File Name: Sorcerer.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: An implementation of the hero class that prioritizes certain stats
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorcerer extends Hero{
    private List<Sorcerer> sorcerers = new ArrayList<>();
    public Sorcerer(){
        // Read characters from file
        super();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Sorcerers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(pastFirstLine) {
                    String[] parts = line.split("\\s+");
                    sorcerers.add(new Sorcerer(
                            parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5])));
                }
                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        Sorcerer randomCharacter = sorcerers.get(random.nextInt(sorcerers.size()));

        setName(randomCharacter.getName());
        setMP(randomCharacter.getMP());
        setTotalMP(randomCharacter.getMP());
        setStrength(randomCharacter.getStrength());
        setAgility(randomCharacter.getAgility());
        setDexterity(randomCharacter.getDexterity());
        setGold(randomCharacter.getGold());

    }
    public Sorcerer(String name, int mana, int strength, int agility, int dexterity, int startingMoney){
        super();
        setName(name);
        setMP(mana);
        setTotalMP(mana);
        setStrength(strength);
        setAgility(agility);
        setDexterity(dexterity);
        setGold(startingMoney);
    }


    public void levelUp(){
        super.levelUp();
        setStrength((int)(getStrength() * 1.05));
        setDexterity((int)(getDexterity() * 1.1));
        setAgility((int)(getAgility() * 1.1));
    }


}
