//File Name: Warrior.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: An implementation of the hero class that favors certain stats
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warrior extends Hero{
    private List<Warrior> warriors = new ArrayList<>();
    public Warrior(){
        // Read characters from file
        super();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Warriors.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(pastFirstLine) {
                    String[] parts = line.split("\\s+");
                    warriors.add(new Warrior(
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
        Warrior randomCharacter = warriors.get(random.nextInt(warriors.size()));

        setName(randomCharacter.getName());
        setMP(randomCharacter.getMP());
        setTotalMP(randomCharacter.getMP());
        setStrength(randomCharacter.getStrength());
        setAgility(randomCharacter.getAgility());
        setDexterity(randomCharacter.getDexterity());
        setGold(randomCharacter.getGold());

    }
    public Warrior(String name, int mana, int strength, int agility, int dexterity, int startingMoney){
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
        setStrength((int)(getStrength() * 1.1));
        setDexterity((int)(getDexterity() * 1.05));
        setAgility((int)(getAgility() * 1.1));
    }


}
