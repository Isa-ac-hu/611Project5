//File Name: FieldInteraction.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A strategy pattern for interacting with tiles of type FieldTile
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class FieldInteraction implements InteractionStrategy {

    public void interact(ArrayList<Hero> players, Scanner scanner, Tile tile) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(2);

        if (randomNumber == 0) {
            System.out.println("Enemies spotted! A battle is starting!");
            new Battle(players, false, scanner);
        }
        else {
            System.out.println("Nothing here...");
        }
    }
}