//File Name: MarketTile.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A tile that has a market on it, which will open it to the player when interacted with
import java.util.ArrayList;
import java.util.Scanner;

public class MarketTile extends Tile{
    private InteractionStrategy interactionStrategy;
    private Market market;

    public MarketTile(){
        super();
        this.interactionStrategy = new MarketInteraction();
        market = new Market();
    }

    public MarketTile(int numPieces){
        super(numPieces);
        this.interactionStrategy = new MarketInteraction();
        market = new Market();
    }

    public Market getMarket(){
        return market;
    }
    public void interact(ArrayList<Hero> players, Scanner scanner, Tile tile) {
        interactionStrategy.interact(players, scanner, this);
    }
}
