//File Name: InteractionStrategy.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: An interface who specifies the existence of an interact method, with players, a scanner, and a tile as input
import java.util.ArrayList;
import java.util.Scanner;

// Define the interaction strategy interface
interface InteractionStrategy {
    void interact(ArrayList<Hero> players, Scanner scanner, Tile tile);
}