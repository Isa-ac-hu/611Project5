//File Name: Exoskeleton.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class for representing exoskeleton stats
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exoskeleton extends Monster{
    private List<Exoskeleton> exoskeletons = new ArrayList<>();
    public Exoskeleton(int level){
        // Read characters from file
        super();
        boolean pastFirstLine = false;
        try (BufferedReader br = new BufferedReader(new FileReader("Exoskeletons.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(pastFirstLine) {
                    String[] parts = line.split("\\s+");
                    exoskeletons.add(new Exoskeleton(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
                }
                pastFirstLine = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        Exoskeleton randomCharacter = exoskeletons.get(random.nextInt(exoskeletons.size()));
        //find the dragon that matches the level of the hero
        for(int i = 0; i < exoskeletons.size(); i++){
            if(exoskeletons.get(i).getLevel() == level){
                randomCharacter = exoskeletons.get(i);
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
    public Exoskeleton(String name, int level, int damage, int defense, int dodgeChance){
        super();
        setName(name);
        setLevel(level);
        setBaseDamage(damage);
        setDefenseValue(defense);
        setDodgeAbility(dodgeChance);
    }

    public String toString() {
        return super.toString() + "\n" +
                "     .-.\n" +
                "     (o.o)\n" +
                "      |=|\n" +
                "     __|__\n" +
                "   //.=|=.\\\\\n" +
                "  // .=|=. \\\\\n" +
                "  \\\\ .=|=. //\n" +
                "   \\\\(_=_)//\n" +
                "    (:| |:)\n" +
                "     || ||\n" +
                "     () ()\n" +
                "     || ||\n" +
                "     || ||\n" +
                "    ==' '==";
    }
}
