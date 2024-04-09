//File Name: MarketInteraction.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A strategy pattern class detailing what should happen when the interact method is called on a MarketTile
import java.util.ArrayList;
import java.util.Scanner;

// Concrete interaction strategy for Market
class MarketInteraction implements InteractionStrategy {
    @Override
    public void interact(ArrayList<Hero> players, Scanner scanner, Tile tile) {
        MarketTile MT = (MarketTile)tile;
        MT.getMarket().marketInteraction(players, scanner);
    }
}