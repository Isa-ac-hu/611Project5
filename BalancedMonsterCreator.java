//File Name: BalancedMonsterCreator.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description:a factory that facilitates the random creation of monster objects, based on the templates of the text file

import java.util.ArrayList;
import java.util.Random;

public class BalancedMonsterCreator implements MonsterCreator{

    private int level;

    private ArrayList<Monster> monsters = new ArrayList<>();
    public BalancedMonsterCreator(int setLevel){
        level = setLevel;
    }
    Random random = new Random();
    public Monster createMonster(){
        int monsterType = random.nextInt(3);

        if(monsterType == 0){
            return new Exoskeleton(level);
        }
        if(monsterType == 1){
            return new Dragon(level);
        }
        else{
            return new Spirit(level);
        }

    }
    public ArrayList<Monster> createMonsters(int numMonsters){
        for(int i = 0; i < numMonsters; i++)
            monsters.add(createMonster());
        return monsters;
    }
}
