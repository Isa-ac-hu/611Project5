//File Name: FieldTile.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A type of tile that holds the string field, and has a 50% chance of spawning a monster when interacted with
import java.util.ArrayList;
import java.util.Scanner;

public class FieldTile extends Tile{
    private InteractionStrategy interactionStrategy;

    public FieldTile(){
        super();
        this.interactionStrategy = new FieldInteraction();
    }

    public FieldTile(int numPieces){
        super(numPieces);
        this.interactionStrategy = new FieldInteraction();
    }
    public void interact(ArrayList<Hero> players, Scanner scanner) {
        interactionStrategy.interact(players, scanner, this);
    }
}
