//File Name: Paladin.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: An implementation of hero with specific stats raised
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Paladin extends Hero{
    private List<Paladin> paladins = new ArrayList<>();
    public Paladin(){
        // Read characters from file
        super();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Paladins.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(pastFirstLine) {
                    String[] parts = line.split("\\s+");
                    paladins.add(new Paladin(
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
        Paladin randomCharacter = paladins.get(random.nextInt(paladins.size()));

        setName(randomCharacter.getName ());
        setMP(randomCharacter.getMP());
        setTotalMP(randomCharacter.getMP());
        setStrength(randomCharacter.getStrength());
        setAgility(randomCharacter.getAgility());
        setDexterity(randomCharacter.getDexterity());
        setGold(randomCharacter.getGold());

    }
    public Paladin(String name, int mana, int strength, int agility, int dexterity, int startingMoney){
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
        setDexterity((int)(getDexterity() * 1.1));
        setAgility((int)(getAgility() * 1.05));
    }


}
