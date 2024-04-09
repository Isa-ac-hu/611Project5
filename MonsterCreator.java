//File Name: MonsterCreator.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A factory class for the creation of Monster objects
import java.util.ArrayList;

public interface MonsterCreator {
    public Monster createMonster();
    public ArrayList<Monster> createMonsters(int numMonsters);
}
