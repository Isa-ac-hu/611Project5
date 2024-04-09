//File Name: Battle.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description:A interactive display class representing the fighting between monsters and heroes
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Scanner scanner;
    private ArrayList<Monster> monsters;
    private ArrayList<Hero> players;
    private ArrayList<Hero> faintedPlayers;
    private int numMonsters;

    private int highestLevel;

    private WavPlayer battleSong;
    public Battle(ArrayList<Hero> players, boolean isRandom, Scanner scanner){
        //first, lets spawn in appropriate monsters!

        numMonsters = players.size();
        highestLevel = getHighestHeroLevel(players);
        MonsterCreator mc;
        if(isRandom){
            mc = new RandomMonsterCreator();
            monsters = mc.createMonsters(players.size());
        }
        else{
            mc = new BalancedMonsterCreator(highestLevel);
            monsters = mc.createMonsters(numMonsters);
        }
        this.scanner = scanner;
        this.players = players;
        faintedPlayers = new ArrayList<>();

        try
        {
            String filePath = "battle.wav";
            battleSong = new WavPlayer(filePath);
            battleSong.playOnRepeat();
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        activeBattle();

        battleSong.close();
    }

    public int getHighestHeroLevel(ArrayList<Hero> heroes){
        if (heroes == null || heroes.isEmpty()) {
            return 0; // or throw an exception or handle the case as appropriate
        }

        int highestLevel = heroes.get(0).getLevel(); // Initialize with the first hero's level

        for (Hero hero : heroes) {
            int heroLevel = hero.getLevel();
            if (heroLevel > highestLevel) {
                highestLevel = heroLevel;
            }
        }
        return highestLevel;
    }

    public void showMonsters(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for(int i = 0; i < monsters.size(); i++){
            System.out.println(monsters.get(i));
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
    public void showParty(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for(int i = 0; i < players.size(); i++){
            System.out.println(players.get(i));
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
    public void victory(){
        battleSong.close();
        try
        {
            String filePath = "victory.wav";
            new WavPlayer(filePath);
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        try{
            Thread.sleep(4000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < players.size(); i++){
            players.get(i).incrementExperience(2 * numMonsters * highestLevel);
            players.get(i).setGold(players.get(i).getGold() + (highestLevel * numMonsters * 100));
            System.out.println(players.get(i).getName() + " got " + (highestLevel * numMonsters * 100) + " gold and " + 2*numMonsters + " experience!");
            if(players.get(i).getExperience() > 10 * players.get(i).getLevel()){
                players.get(i).levelUp();
                System.out.println(players.get(i).getName() + " has leveled up to level " + players.get(i).getLevel() + "!!!");
            }
        }
        //move fainted players back to the player arraylist
        players.addAll(faintedPlayers);
        faintedPlayers.clear();
        for(int i = 0; i < players.size(); i++){
            //reset all stats from the battle
            players.get(i).setHP(players.get(i).getLevel() * 100);
            players.get(i).setMP(players.get(i).getTotalMP());

        }

    }
    public void activeBattle(){
        boolean heroesDefeated = false;
        boolean monstersDefeated = false;
        while(!heroesDefeated && !monstersDefeated){
            heroesAttack();
            if(monsters.size() == 0){
                monstersDefeated = true;
                break;
            }
            monstersAttack();
            if(players.size() == 0){
                heroesDefeated = true;
                break;
            }
            for(int i = 0; i < players.size(); i++){
                players.get(i).setHP((int)(players.get(i).getHP() * 1.1));
                players.get(i).setMP((int)(players.get(i).getMP() * 1.1));
                if((int)(players.get(i).getHP() * 1.1) > players.get(i).getLevel() * 100){
                    players.get(i).setHP(players.get(i).getLevel() * 100);
                }
                if((int)(players.get(i).getMP() * 1.1) > players.get(i).getTotalMP()){
                    players.get(i).setMP(players.get(i).getTotalMP());
                }
            }
        }
        if(monstersDefeated){
            System.out.println("You successfully defeated all the monsters!");
            victory();
        }
        else if(heroesDefeated){
            System.out.println("Game over! Every Hero has fainted! Here are your stats: ");
            showParty();
            System.exit(0);
        }
    }

    //Go through the options for the hero to lay out their offensive
    public void heroesAttack(){
        for(int i = 0; i < players.size(); i++){
            if(monsters.size() == 0){
                break;
            }
            showMonsters();
            Hero currentPlayer = players.get(i);

            System.out.println(currentPlayer.getName() + "'s turn!");
            System.out.println(currentPlayer);
            System.out.println("(1) attack (2) inventory (P) check party (Q) quit");
            String choice = scanner.nextLine();
            if (InputParser.selectQuit(choice)) {
                System.exit(0);
            }
            while (!InputParser.queryInt(choice, 1, 2) && !(choice.equals("P") || choice.equals("p"))) {
                System.out.println("(1) attack (2) inventory (P) check party (Q) quit");
                choice = scanner.nextLine();
                if (InputParser.selectQuit(choice)) {
                    System.exit(0);
                }
            }
            if(choice.equals("P") || choice.equals("p")){
                showParty();
                i--;
                continue;
            }
            int choiceSelection = Integer.parseInt(choice);

            //choose attack!
            if(choiceSelection == 1){
                if(monsters.size() == 1)
                    System.out.println("Which monster would you like to attack? (1) (Q) quit");
                else if(monsters.size() == 2)
                    System.out.println("Which monster would you like to attack? (1) (2) (Q) quit");
                else if(monsters.size() == 3)
                    System.out.println("Which monster would you like to attack? (1) (2) (3) (Q) quit");
                else
                    System.out.println("ERROR NO MONSTERS DETECTED (Q) quit");

                String chooseAttack = scanner.nextLine();
                if (InputParser.selectQuit(chooseAttack)) {
                    System.exit(0);
                }
                while (!InputParser.queryInt(chooseAttack, 1, monsters.size())) {
                    if(monsters.size() == 1)
                        System.out.println("Which monster would you like to attack? (1) (Q) quit");
                    else if(monsters.size() == 2)
                        System.out.println("Which monster would you like to attack? (1) (2) (Q) quit");
                    else if(monsters.size() == 3)
                        System.out.println("Which monster would you like to attack? (1) (2) (3) (Q) quit");
                    else
                        System.out.println("ERROR NO MONSTERS DETECTED (Q) quit");
                    chooseAttack = scanner.nextLine();
                    if (InputParser.selectQuit(chooseAttack)) {
                        System.exit(0);
                    }
                }
                int attackSelection = Integer.parseInt(chooseAttack);

                monsterTakeAttackDamage(attackSelection,  currentPlayer);

            }//open the inventory!
            if(choiceSelection == 2){
                if(currentPlayer.getInventory().size() == 0){
                    System.out.println("Player " + currentPlayer.getName() + "'s inventory is empty. You must attack!");
                    if(monsters.size() == 1)
                        System.out.println("Which monster would you like to attack? (1) (Q) quit");
                    else if(monsters.size() == 2)
                        System.out.println("Which monster would you like to attack? (1) (2) (Q) quit");
                    else if(monsters.size() == 3)
                        System.out.println("Which monster would you like to attack? (1) (2) (3) (Q) quit");
                    else
                        System.out.println("ERROR NO MONSTERS DETECTED (Q) quit");

                    String chooseAttack = scanner.nextLine();
                    if (InputParser.selectQuit(chooseAttack)) {
                        System.exit(0);
                    }
                    while (!InputParser.queryInt(chooseAttack, 1, monsters.size())) {
                        if(monsters.size() == 1)
                            System.out.println("Which monster would you like to attack? (1) (Q) quit");
                        else if(monsters.size() == 2)
                            System.out.println("Which monster would you like to attack? (1) (2) (Q) quit");
                        else if(monsters.size() == 3)
                            System.out.println("Which monster would you like to attack? (1) (2) (3) (Q) quit");
                        else
                            System.out.println("ERROR NO MONSTERS DETECTED (Q) quit");
                        chooseAttack = scanner.nextLine();
                        if (InputParser.selectQuit(chooseAttack)) {
                            System.exit(0);
                        }
                    }
                    int attackSelection = Integer.parseInt(chooseAttack);

                    monsterTakeAttackDamage(attackSelection,  currentPlayer);
                }
                else{
                    System.out.println("Select an item!");
                    System.out.println(currentPlayer.getInventory());

                    String chooseItem = scanner.nextLine();
                    if (InputParser.selectQuit(chooseItem)) {
                        System.exit(0);
                    }
                    while (!InputParser.queryInt(chooseItem, 1, currentPlayer.getInventory().size())) {
                        chooseItem = scanner.nextLine();
                        if (InputParser.selectQuit(chooseItem)) {
                            System.exit(0);
                        }
                    }
                    int itemSelection = Integer.parseInt(chooseItem);
                    Item selectedItem = currentPlayer.getInventory().get(itemSelection - 1);

                    //now we have a selected item, check to see if the item is an instance of armor, weapon, spell, or potion
                    if(selectedItem instanceof Spell){
                        if(monsters.size() == 1)
                            System.out.println("Which monster would you like to attack? (1) (Q) quit");
                        else if(monsters.size() == 2)
                            System.out.println("Which monster would you like to attack? (1) (2) (Q) quit");
                        else if(monsters.size() == 3)
                            System.out.println("Which monster would you like to attack? (1) (2) (3) (Q) quit");
                        else
                            System.out.println("ERROR NO MONSTERS DETECTED (Q) quit");

                        String chooseAttack = scanner.nextLine();
                        if (InputParser.selectQuit(chooseAttack)) {
                            System.exit(0);
                        }
                        while (!InputParser.queryInt(chooseAttack, 1, monsters.size())) {
                            if(monsters.size() == 1)
                                System.out.println("Which monster would you like to attack? (1) (Q) quit");
                            else if(monsters.size() == 2)
                                System.out.println("Which monster would you like to attack? (1) (2) (Q) quit");
                            else if(monsters.size() == 3)
                                System.out.println("Which monster would you like to attack? (1) (2) (3) (Q) quit");
                            else
                                System.out.println("ERROR NO MONSTERS DETECTED (Q) quit");
                            chooseAttack = scanner.nextLine();
                            if (InputParser.selectQuit(chooseAttack)) {
                                System.exit(0);
                            }
                        }
                        int attackSelection = Integer.parseInt(chooseAttack);

                        monsterTakeSpellDamage(attackSelection, (Spell)selectedItem, currentPlayer);
                    }
                    else if(selectedItem instanceof Potion){
                        Potion potion = (Potion)selectedItem;
                        currentPlayer.getInventory().remove(selectedItem);
                        if(potion.getName().equals("Healing_Potion")){
                            currentPlayer.setHP(currentPlayer.getHP() + potion.getAttributeIncrease());
                            System.out.println("Healed " + potion.getAttributeIncrease() + " HP!");
                        }
                        else if(potion.getName().equals("Strength_Potion")){
                            currentPlayer.setStrength(currentPlayer.getStrength() + potion.getAttributeIncrease());
                            System.out.println("Strength increased by " + potion.getAttributeIncrease() + " points!");
                        }
                        else if(potion.getName().equals("Magic_Potion")){
                            currentPlayer.setMP(currentPlayer.getMP() + potion.getAttributeIncrease());
                            System.out.println("Magic increased by " + potion.getAttributeIncrease() + " points!");
                        }
                        else if(potion.getName().equals("Luck_Elixir")){
                            currentPlayer.setAgility(currentPlayer.getAgility() + potion.getAttributeIncrease());
                            System.out.println("Agility increased by " + potion.getAttributeIncrease() + " points!");
                        }
                        else if(potion.getName().equals("Mermaid_Tears")){
                            currentPlayer.setHP(currentPlayer.getHP() + potion.getAttributeIncrease());
                            currentPlayer.setMP(currentPlayer.getMP() + potion.getAttributeIncrease());
                            currentPlayer.setStrength(currentPlayer.getStrength() + potion.getAttributeIncrease());
                            currentPlayer.setAgility(currentPlayer.getAgility() + potion.getAttributeIncrease());
                            System.out.println("HP, MP, Strength, Agility, increased by " + potion.getAttributeIncrease() + " points!");
                        }
                        else if(potion.getName().equals("Ambrosia")){
                            currentPlayer.setHP(currentPlayer.getHP() + potion.getAttributeIncrease());
                            currentPlayer.setMP(currentPlayer.getMP() + potion.getAttributeIncrease());
                            currentPlayer.setStrength(currentPlayer.getStrength() + potion.getAttributeIncrease());
                            currentPlayer.setDexterity(currentPlayer.getDexterity() + potion.getAttributeIncrease());
                            currentPlayer.getArmor().setDamageReduction(currentPlayer.getArmor().getDamageReduction() + potion.getAttributeIncrease());
                            currentPlayer.setAgility(currentPlayer.getAgility() + potion.getAttributeIncrease());
                            System.out.println("HP, MP, Strength, Dexterity, Defense, Agility, increased by " + potion.getAttributeIncrease() + " points!");
                        }

                    }
                    else if(selectedItem instanceof Armor){
                        Armor armor = (Armor)selectedItem;
                        Armor oldArmor = currentPlayer.getArmor();
                        currentPlayer.getInventory().add(oldArmor);
                        System.out.println(oldArmor.getName() + " returned to inventory.");
                        currentPlayer.setArmor(armor);
                        currentPlayer.getInventory().remove(armor);
                        System.out.println("Equipped " + selectedItem.getName() + "!");
                    }
                    else if(selectedItem instanceof Weapon){
                        Weapon weapon = (Weapon)selectedItem;
                        Weapon oldWeapon = currentPlayer.getWeapon();
                        currentPlayer.getInventory().add(oldWeapon);
                        System.out.println(oldWeapon.getName() + " returned to inventory.");
                        currentPlayer.setWeapon(weapon);
                        currentPlayer.getInventory().remove(weapon);
                        System.out.println("Equipped " + selectedItem.getName() + "!");
                    }
                    else{
                        System.out.println("The item disappears right in front of you...");
                    }
                }

            }


        }
    }
    public void monsterTakeAttackDamage(int attackedMonster, Hero player){
        Monster monster = monsters.get(attackedMonster - 1);

        int attackDamage = (int) ((player.getStrength() + player.getWeapon().getDamage()) * 0.05) - (monster.getDefenseValue() / 30);

        double randomNumber = Math.random();
        double dodgeChance = monster.getDodgeAbility() * 0.01;

        if (randomNumber < dodgeChance) {
            System.out.println("The monster " + monster.getName() + " dodged the attack!");
        }
        else {
            System.out.println("Player " + player.getName() + " attacked monster " + monster.getName() + " for " + attackDamage + " damage!");
            monster.setHP(monster.getHP() - attackDamage);
        }
        if(monster.getHP() <= 0){
            System.out.println("Monster " + monster.getName() + " was obliterated!");
            monsters.remove(monster);
        }
    }

    public void monsterTakeSpellDamage(int attackedMonster, Spell spell, Hero player){

        //spells ignore physical defense!
        Monster monster = monsters.get(attackedMonster - 1);


        int spellDamage = (int)((spell.getDamage() + ((player.getDexterity()/10000.0)* spell.getDamage())));

        double randomNumber = Math.random();
        double dodgeChance = monster.getDodgeAbility() * 0.01;
        if(player.getMP() - spell.getManaCost() >= 0){
            System.out.println("Spell " + spell.getName() + " was consumed!");
            player.setMP(player.getMP() - spell.getManaCost());
            player.getInventory().remove(spell);
            if (randomNumber < dodgeChance) {
                System.out.println("The monster dodged the attack!");
            }
            else {
                System.out.println("Player " + player.getName() + " attacked monster " + monster.getName() + " for " + spellDamage + " damage!");
                monster.setHP(monster.getHP() - spellDamage);

                //depending on the type of spell, the monster also gets a status effect!
                if(spell.getType().equals("Ice")){
                    monster.setBaseDamage(monster.getBaseDamage()/10);
                }
                else if(spell.getType().equals("Fire")){
                    monster.setDefenseValue(monster.getDefenseValue()/10);
                }
                else if(spell.getType().equals("Lightning")){
                    monster.setDodgeAbility(monster.getDodgeAbility()/10);
                }
            }
            if(monster.getHP() <= 0){
                System.out.println("Monster " + monster.getName() + " was obliterated!");
                monsters.remove(monster);
            }
        }
        else{
            System.out.println("Player " + player.getName() + " tried to use " + spell.getName() + ", but it failed due to not enough mana!");
        }


    }
    public void monstersAttack(){
        System.out.println("####################################################################################################");
        for(int i = 0; i < monsters.size(); i++) {
            Monster currentMonster = monsters.get(i);
            //for each monster, randomly choose one of the heros to attack; then, run the attack hero code
            Random random = new Random();
            if(players.size() > 0){
                int chosenHero = random.nextInt(players.size());
                heroTakeAttackDamage(chosenHero, currentMonster);

            }
        }
        System.out.println("####################################################################################################");
    }
    public void heroTakeAttackDamage(int attackedHero, Monster monster){
        Hero hero = players.get(attackedHero);

        //Monster's attack damage = damage - hero.defense
        double damageReduction = (Math.random() * 0.75) + 0.25;
        int attackDamage = (int)((monster.getBaseDamage()*0.1 - hero.getArmor().getDamageReduction())*damageReduction);

        double randomNumber = Math.random();
        double dodgeChance = hero.getAgility() * 0.0004;

        if (randomNumber < dodgeChance) {
            System.out.println("The hero " + hero.getName() + " dodged the attack from " + monster.getName() + "!");
        }
        else {
            System.out.println("Monster " + monster.getName() + " attacked player " + hero.getName() + " for " + attackDamage + " damage!");
            hero.setHP(hero.getHP() - attackDamage);
        }
        if(hero.getHP() <= 0){
            System.out.println("Hero " + hero.getName() + " fainted!");
            faintedPlayers.add(hero);
            players.remove(hero);
        }
    }


}
