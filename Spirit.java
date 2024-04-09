//File Name: Spirit.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: An implementation of the monster class that represents a ghost
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spirit extends Monster{
    private List<Spirit> spirits = new ArrayList<>();
    public Spirit(int level){
        // Read characters from file
        super();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Spirits.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(pastFirstLine) {
                    String[] parts = line.split("\\s+");
                    spirits.add(new Spirit(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
                }
                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        Spirit randomCharacter = spirits.get(random.nextInt(spirits.size()));
        //find the dragon that matches the level of the hero
        for(int i = 0; i < spirits.size(); i++){
            if(spirits.get(i).getLevel() == level){
                randomCharacter = spirits.get(i);
                break;
            }
        }



        setName(randomCharacter.getName());
        setLevel(randomCharacter.getLevel());
        setHP(randomCharacter.getLevel() * 100);
        setBaseDamage(randomCharacter.getBaseDamage());
        setDefenseValue(randomCharacter.getDefenseValue());
        setDodgeAbility(randomCharacter.getDodgeAbility());

    }
    public Spirit(String name, int level, int damage, int defense, int dodgeChance){
        super();
        setName(name);
        setLevel(level);
        setBaseDamage(damage);
        setDefenseValue(defense);
        setDodgeAbility(dodgeChance);
    }

    public String toString() {
        return super.toString() + "\n" +
                "        ___\n" +
                "      _/ 66\\\n" +
                "     ( \\  ^/__\n" +
                "      \\    \\__)\n" +
                "      /     \\\n" +
                "     /      _\\\n" +
                "    `\"\"\"\"\"``";
    }
}
