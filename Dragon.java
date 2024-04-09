//File Name: Dragon.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class for representing dragon stats
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dragon extends Monster{
    private List<Dragon> dragons = new ArrayList<>();
    public Dragon(int level){
        // Read characters from file
        super();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Dragons.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(pastFirstLine) {
                    String[] parts = line.split("\\s+");
                    dragons.add(new Dragon(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
                }
                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        Dragon randomCharacter = dragons.get(random.nextInt(dragons.size()));
        //find the dragon that matches the level of the hero
        for(int i = 0; i < dragons.size(); i++){
            if(dragons.get(i).getLevel() == level){
                randomCharacter = dragons.get(i);
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
    public Dragon(String name, int level, int damage, int defense, int dodgeChance){
        super();
        setName(name);
        setLevel(level);
        setBaseDamage(damage);
        setDefenseValue(defense);
        setDodgeAbility(dodgeChance);
    }

    public String toString() {
        return super.toString() + "\n" +

                "         /\\_/\\\n" +
                "     /\\  |6 6|  /\\\n" +
                "    /  \\ \\<\">/ /  \\\n" +
                "   / ,__`~)-(~___, \\\n" +
                "  /.',-'`/_/`'-,  '.\\\n" +
                "   ,'    \\_\\    ',\n" +
                "  :       \\|\\     ;\n" +
                "   ',     /|/    ,'\n" +
                "     '-,__\\W\\_,-))\n" +
                "               ((\n" +
                "                )";
    }
}
