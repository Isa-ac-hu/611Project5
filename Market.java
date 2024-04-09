//File Name: Market.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class that exists on a market tile, providing an interactive interface for heroes to buy and sell.
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Market {
    private Inventory inventory;
    private PotionCreator pc = new PotionCreator();
    private ArmorCreator ac = new ArmorCreator();
    private WeaponCreator wc = new WeaponCreator();
    private SpellCreator sc = new SpellCreator();
    private ArrayList<Hero> players;
    private Scanner scanner;

    private WavPlayer marketSong;

    public Market() {
        inventory = new Inventory();
        populateMarket();


    }

    private void populateMarket() {
        Random rand = new Random();

        // Generate random counts for each type of item
        int potionCount = rand.nextInt(2) + 1;
        int armorCount = rand.nextInt(2) + 1;
        int weaponCount = rand.nextInt(2) + 1;
        int spellCount = rand.nextInt(2) + 1;

        // Populate the market with random items
        for (int i = 0; i < potionCount; i++) {
            inventory.add(pc.getRandomPotion());
        }
        for (int i = 0; i < armorCount; i++) {
            inventory.add(ac.getRandomArmor());
        }
        for (int i = 0; i < weaponCount; i++) {
            inventory.add(wc.getRandomWeapon());
        }
        for (int i = 0; i < spellCount; i++) {
            inventory.add(sc.getRandomSpell());
        }
    }

    public void marketInteraction(ArrayList<Hero> players, Scanner scanner){
        this.scanner = scanner;
        this.players = players;
        System.out.println(inventory);
        try
        {
            String filePath = "market.wav";
            marketSong = new WavPlayer(filePath);
            marketSong.playOnRepeat();
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }


        while(true){
            System.out.println("Welcome to the market! Would you like to (1) Buy (2) Sell (B) Go back to world screen (Q) quit");
            String choice = scanner.nextLine();
            if (InputParser.selectQuit(choice)) {
                System.exit(0);
            }
            if(choice.equals("B") || choice.equals("b")){
                break;
            }
            else {
                while (!InputParser.queryInt(choice, 1, 2)) {
                    System.out.println("Welcome to the market! Would you like to (1) Buy (2) Sell (B) Go back to world screen (Q) quit");
                    choice = scanner.nextLine();
                    if (InputParser.selectQuit(choice)) {
                        System.exit(0);
                    }
                }
                int selection = Integer.parseInt(choice);


                System.out.println("Which player would you like to go in? (Q) quit");
                for(int i = 0; i < players.size(); i++){
                    System.out.println(i+1 + ". " + players.get(i));
                }
                String playerSelect = scanner.nextLine();
                if (InputParser.selectQuit(playerSelect)) {
                    System.exit(0);
                }
                while (!InputParser.queryInt(playerSelect, 1, players.size())) {
                    playerSelect = scanner.nextLine();
                    if (InputParser.selectQuit(playerSelect)) {
                        System.exit(0);
                    }
                }
                int selectedPlayerInt = Integer.parseInt(playerSelect);
                Hero selectedPlayer = players.get(selectedPlayerInt - 1);

                if(selection == 1){
                    purchase(selectedPlayer);
                }
                else if(selection == 2){
                    sell(selectedPlayer);
                }
                else{
                    System.out.println("Invalid input!");
                }
            }
        }
        marketSong.close();
    }

    public void purchase(Hero player){
        System.out.println(inventory);
        System.out.println("What would you like to Buy?");
        System.out.println("Select an item! (B) back");

        String chooseItem = scanner.nextLine();
        if (InputParser.selectQuit(chooseItem)) {
            System.exit(0);
        }
        if(chooseItem.equals("B") || chooseItem.equals("b")){

        }
        else{
            while (!InputParser.queryInt(chooseItem, 1, inventory.size()) && !(chooseItem.equals("B") || chooseItem.equals("b"))) {
                System.out.println("Select an item! (B) back");
                chooseItem = scanner.nextLine();
                if (InputParser.selectQuit(chooseItem)) {
                    System.exit(0);
                }
            }
            int itemSelection = Integer.parseInt(chooseItem);
            Item item = inventory.get(itemSelection - 1);
            if(player.getGold() >= item.getCost()){
                if(player.getLevel() >= item.getRequiredLevel()){
                    player.setGold(player.getGold() - item.getCost());
                    System.out.println("Player " + player.getName() + " purchased " + item.getName() + " for " + item.getCost() + ".");
                    System.out.println(player.getGold() + " funds remaining.");
                    player.getInventory().add(item);
                    System.out.println(player.getName() + "'s inventory: ");
                    System.out.println(player.getInventory());
                    inventory.remove(item);
                }
                else{
                    System.out.println("Player level is not high enough for this transaction.");
                }
            }
            else{
                System.out.println("Not enough gold to purchase this item!");
            }
        }

    }

    public void sell(Hero player){
        Inventory playerInventory = player.getInventory();
        if(playerInventory.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < playerInventory.size(); i++) {
                sb.append(i + 1).append(". ").append(playerInventory.get(i).getName()).append(" || ").append(playerInventory.get(i).getCost()).append(" gold").append("\n");
            }
            System.out.println(sb);
            System.out.println("What would you like to sell?");
            System.out.println("Select an item! (B) back");

            String chooseItem = scanner.nextLine();
            if (InputParser.selectQuit(chooseItem)) {
                System.exit(0);
            }
            if (chooseItem.equals("B") || chooseItem.equals("b")) {

            }
            else {
                while (!InputParser.queryInt(chooseItem, 1, player.getInventory().size()) && !(chooseItem.equals("B") || chooseItem.equals("b"))) {
                    chooseItem = scanner.nextLine();
                    if (InputParser.selectQuit(chooseItem)) {
                        System.exit(0);
                    }
                }
                int itemSelection = Integer.parseInt(chooseItem);
                Item selectedItem = player.getInventory().get(itemSelection - 1);

                //now remove it from the player's inventory and add it to the store's inventory
                inventory.add(selectedItem);
                player.getInventory().remove(selectedItem);
                player.setGold(player.getGold() + selectedItem.getCost() / 2);
                System.out.println("Item " + selectedItem.getName() + " sold for " + selectedItem.getCost() / 2 + " gold.");
                System.out.println(player.getGold() + " funds remaining.");
                System.out.println(player.getName() + "'s inventory: ");
                System.out.println(player.getInventory());
            }
        }
        else{
            System.out.println("Inventory is empty, there is nothing to sell!");
        }

    }
}
