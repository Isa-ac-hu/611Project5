//File Name: RandomMonsterCreator.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A factory class for monsters that randomizes the stats and the number of monsters
import java.util.ArrayList;
import java.util.Random;
public class RandomMonsterCreator implements MonsterCreator {
    Random random = new Random();

    private ArrayList<Monster> monsters = new ArrayList<>();
    public Monster createMonster(){
        int monsterType = random.nextInt(3);
        int monsterLevel = random.nextInt(10);

        if(monsterType == 0){
            return new Exoskeleton(monsterLevel);
        }
        if(monsterType == 1){
            return new Dragon(monsterLevel);
        }
        else{
            return new Spirit(monsterLevel);
        }

    }

    public ArrayList<Monster> createMonsters(int numMonsters){
        for(int i = 0; i < numMonsters; i++)
            monsters.add(createMonster());
        return monsters;
    }
}
