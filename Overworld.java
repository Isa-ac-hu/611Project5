//File Name: Overworld.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class representing the game world outside of battles and the marketplace, where the player can explore the map
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Overworld {
    static Board board;
    static ArrayList<Hero> players;
    static Scanner scanner;

    private static WavPlayer overworldSong;
    public Overworld(){
        try
        {
            String filePath = "overworld.wav";
            overworldSong = new WavPlayer(filePath);
            overworldSong.playOnRepeat();
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        scanner = new Scanner(System.in);
        players = new ArrayList<>();
        board = new Board();


        //introduction();
        //tutorial();
        boardSize();
        addHeroes();
        explore();
        overworldSong.close();

    }
    public static void introduction(){
        System.out.println("WELCOME TO THE WORLD OF HEROES AND MONSTERS");
        sleepyTime();
        System.out.println("LONG AGO, OUR BLESSED LAND WAS SPLIT FROM THE FIRMAMENTS");
        sleepyTime();
        System.out.println("HEMMED IN BY GREAT SEAS AND LOFTY MOUNTAINS, OUR PEOPLE PROSPERED IN THE ISOLATION OF FRUITFUL FIELDS AND ROLLING PLAINS");
        sleepyTime();
        System.out.println("IN TIME, THIS PARADISE BECAME OUR WEAKNESS");
        sleepyTime();
        System.out.println("LIKE SHEEP TO A SLAUGHTER, OUR PEOPLE GREW COMPLACENT, AND SOON, DISASTER STRUCK");
        sleepyTime();
        System.out.println("COVETING THE BOUNTY OF OUR LAND, VILE MONSTERS CAME OUT FROM THE MOUNTAINS AND THE FORESTS TO WREAK HAVOC");
        sleepyTime();
        System.out.println("THE ROYAL ARMY WAS DECIMATED. THE KING IS EVANESCENT.");
        sleepyTime();
        System.out.println("NOW, CHOSEN HEROES, THE TIME HAS COME FOR YOU TO SAVE THE WORLD!");
        sleepyTime();
        System.out.println("To begin...");
        sleepyTime();
        sleepyTime();
        System.out.println(professorOak());
        System.out.println("What is your name? (Q) quit");
        String name = scanner.nextLine();
        shortSleepyTime();
        System.out.println(".");
        shortSleepyTime();
        System.out.println("..");
        shortSleepyTime();
        System.out.println("...");
        shortSleepyTime();
        System.out.println("That's a wonderful name, " + name + "! Unfortunately I already picked one out for you. Lets begin!!!");
    }

    public void tutorial(){
        System.out.println("Welcome to the overworld! As you can see, our world is composed of passable plains tiles, alongside");
        System.out.println("great mountains(" + Board.ANSI_PURPLE + "∧" + Board.ANSI_RESET +"), lakes(" + Board.ANSI_BLUE +  "~" + Board.ANSI_RESET+ "), and towns(" + Board.ANSI_GREEN +  "M" + Board.ANSI_RESET + ").");
        System.out.println("Movement is easy across plains and markets, and impossible on lakes and mountains.");
        System.out.println("Use WASD to move your hero tile(" + Board.ANSI_WHITE +  "H" + Board.ANSI_RESET + ") across the board.");
        System.out.println("At each tile, you can open your party menu, and check the inventories of your heroes.");
        System.out.println("Additionally, you can interact with your tile, which can either mean going into a market to shop, or searching fields for enemies.");
        System.out.println("For each non-market tile you pass through, there is also a chance for a surprise ambush by monsters!");
        System.out.println("Kill monsters to gain gold and level up, and use gold to purchase spells, potions, armor, and weapons from the markets!");
        System.out.println("Each market has different items, so make sure to really explore!");
    }

    public void boardSize(){
        System.out.println("How big would you like the board to be? (8-16) (Q) quit");
        String boardSize = scanner.nextLine();
        if (InputParser.selectQuit(boardSize)) {
            System.exit(0);
        }
        while (!InputParser.queryInt(boardSize, 8, 16)) {
            System.out.println("How big would you like the board to be? (8-16) (Q) quit");
            boardSize = scanner.nextLine();
            if (InputParser.selectQuit(boardSize)) {
                System.exit(0);
            }
        }
        int boardSizeInt = Integer.parseInt(boardSize);
        board = new Board(boardSizeInt, boardSizeInt);
    }

    public void addHeroes(){
        System.out.println("How many heroes would you like? (1-3) (Q) quit");
        String numHeroes = scanner.nextLine();
        if (InputParser.selectQuit(numHeroes)) {
            System.exit(0);
        }
        while (!InputParser.queryInt(numHeroes, 1, 3)) {
            System.out.println("How many heroes would you like? (1-3) (Q) quit");
            numHeroes = scanner.nextLine();
            if (InputParser.selectQuit(numHeroes)) {
                System.exit(0);
            }
        }
        ArrayList<Hero> selectPlayers = new ArrayList<>();
        Hero one = new Warrior();
        Hero two = new Sorcerer();
        Hero three = new Paladin();
        selectPlayers.add(one);
        selectPlayers.add(two);
        selectPlayers.add(three);
        int numHeroesInt = Integer.parseInt(numHeroes);
        if(numHeroesInt < 3) {
            System.out.println("Here are your options (they've been randomized)! Which hero would you like?");
            for (int i = 0; i < numHeroesInt; i++) {
                for(int j = 0; j < selectPlayers.size(); j++){
                    System.out.println((j + 1) + ". " + selectPlayers.get(j));
                }
                String heroSelect = scanner.nextLine();
                if (InputParser.selectQuit(heroSelect)) {
                    System.exit(0);
                }
                while (!InputParser.queryInt(heroSelect, 1, selectPlayers.size())) {
                    heroSelect = scanner.nextLine();
                    if (InputParser.selectQuit(heroSelect)) {
                        System.exit(0);
                    }
                }
                int selectedHero = Integer.parseInt(heroSelect);

                players.add(selectPlayers.get(selectedHero - 1));
                selectPlayers.remove(selectedHero - 1);
            }
            System.out.println("Here is your party!");
            for(int j = 0; j < players.size(); j++){
                System.out.println((j + 1) + ". " + players.get(j));
            }
        }
        else{
            System.out.println("You've selected the maximum party size, so you will have 1 paladin, 1 warrior, and 1 sorcerer!");
            System.out.println("Here is your party!");
            players = selectPlayers;
            for(int j = 0; j < players.size(); j++){
                System.out.println((j + 1) + ". " + players.get(j));
            }
        }
    }
    public static void explore(){
        while(true){
            System.out.println(board);
            String[] choices = {"W", "w", "A", "a", "S", "s", "D", "d", "P", "p", "I", "i"};
            System.out.println("WASD to move, (P) check party, (I) interact, (Q) quit");
            String choice = scanner.nextLine();
            if (InputParser.selectQuit(choice)) {
                System.exit(0);
            }
            while (!Arrays.asList(choices).contains(choice)) {
                System.out.println("Invalid Input!");
                System.out.println(board);
                System.out.println("WASD to move, (P) check party, (I) interact, (Q) quit");
                choice = scanner.nextLine();
                if (InputParser.selectQuit(choice)) {
                    System.exit(0);
                }
            }
            if(choice.equals("W") || choice.equals("w")){
                board.pressedW();
            }
            else if(choice.equals("A") || choice.equals("a")){
                board.pressedA();
            }
            else if(choice.equals("S") || choice.equals("s")){
                board.pressedS();
            }
            else if(choice.equals("D") || choice.equals("d")){
                board.pressedD();
            }
            else if(choice.equals("I") || choice.equals("i")){
                //figure out where the hero is and interact with the tile they are on!
                for(int i = 0; i < board.getWidth(); i++) {
                    for (int j = 0; j < board.getHeight(); j++) {
                        if(board.getTile(i,j).getPiece(1).getStringContents().equals("Hero")){
                            if(board.getTile(i,j) instanceof MarketTile){
                                System.out.println("Entering the market!");
                            }
                            overworldSong.close();
                            board.getTile(i,j).interact(players, scanner, board.getTile(i,j));

                            try
                            {
                                String filePath = "overworld.wav";
                                overworldSong = new WavPlayer(filePath);
                                overworldSong.playOnRepeat();
                            }
                            catch (Exception ex)
                            {
                                System.out.println("Error with playing sound.");
                                ex.printStackTrace();
                            }

                        }
                    }
                }
            }
            else if(choice.equals("P") || choice.equals("p")){
                for(int j = 0; j < players.size(); j++){
                    System.out.println((j + 1) + ". " + players.get(j));
                }
                System.out.println("Which hero's inventory would you like to check? (Q) quit");
                String heroSelect = scanner.nextLine();
                if (InputParser.selectQuit(heroSelect)) {
                    System.exit(0);
                }
                while (!InputParser.queryInt(heroSelect, 1, players.size())) {
                    heroSelect = scanner.nextLine();
                    if (InputParser.selectQuit(heroSelect)) {
                        System.exit(0);
                    }
                }
                int selectedHero = Integer.parseInt(heroSelect);
                Hero player = players.get(selectedHero - 1);
                if(player.getInventory().size() != 0){
                    System.out.println("Select an item!");
                    System.out.println(player.getInventory());

                    String chooseItem = scanner.nextLine();
                    if (InputParser.selectQuit(chooseItem)) {
                        System.exit(0);
                    }
                    while (!InputParser.queryInt(chooseItem, 1, player.getInventory().size())) {
                        chooseItem = scanner.nextLine();
                        if (InputParser.selectQuit(chooseItem)) {
                            System.exit(0);
                        }
                    }
                    int itemSelection = Integer.parseInt(chooseItem);
                    Item selectedItem = player.getInventory().get(itemSelection - 1);

                    //now we have a selected item, check to see if the item is an instance of armor, weapon, spell, or potion
                    if(selectedItem instanceof Spell){
                        System.out.println("Cannot be used outside of battle!");
                    }
                    else if(selectedItem instanceof Potion){
                        Potion potion = (Potion)selectedItem;
                        player.getInventory().remove(selectedItem);
                        if(potion.getName().equals("Healing_Potion")){
                            player.setHP(player.getHP() + potion.getAttributeIncrease());
                            System.out.println("Healed " + potion.getAttributeIncrease() + " HP!");
                        }
                        else if(potion.getName().equals("Strength_Potion")){
                            player.setStrength(player.getStrength() + potion.getAttributeIncrease());
                            System.out.println("Strength increased by " + potion.getAttributeIncrease() + " points!");
                        }
                        else if(potion.getName().equals("Magic_Potion")){
                            player.setMP(player.getMP() + potion.getAttributeIncrease());
                            System.out.println("Magic increased by " + potion.getAttributeIncrease() + " points!");
                        }
                        else if(potion.getName().equals("Luck_Elixir")){
                            player.setAgility(player.getAgility() + potion.getAttributeIncrease());
                            System.out.println("Agility increased by " + potion.getAttributeIncrease() + " points!");
                        }
                        else if(potion.getName().equals("Mermaid_Tears")){
                            player.setHP(player.getHP() + potion.getAttributeIncrease());
                            player.setMP(player.getMP() + potion.getAttributeIncrease());
                            player.setStrength(player.getStrength() + potion.getAttributeIncrease());
                            player.setAgility(player.getAgility() + potion.getAttributeIncrease());
                            System.out.println("HP, MP, Strength, Agility, increased by " + potion.getAttributeIncrease() + " points!");
                        }
                        else if(potion.getName().equals("Ambrosia")){
                            player.setHP(player.getHP() + potion.getAttributeIncrease());
                            player.setMP(player.getMP() + potion.getAttributeIncrease());
                            player.setStrength(player.getStrength() + potion.getAttributeIncrease());
                            player.setDexterity(player.getDexterity() + potion.getAttributeIncrease());
                            player.getArmor().setDamageReduction(player.getArmor().getDamageReduction() + potion.getAttributeIncrease());
                            player.setAgility(player.getAgility() + potion.getAttributeIncrease());
                            System.out.println("HP, MP, Strength, Dexterity, Defense, Agility, increased by " + potion.getAttributeIncrease() + " points!");
                        }

                    }
                    else if(selectedItem instanceof Armor){
                        Armor armor = (Armor)selectedItem;
                        Armor oldArmor = player.getArmor();
                        player.getInventory().add(oldArmor);
                        System.out.println(oldArmor.getName() + " returned to inventory.");
                        player.setArmor(armor);
                        player.getInventory().remove(armor);
                        System.out.println("Equipped " + selectedItem.getName() + "!");
                    }
                    else if(selectedItem instanceof Weapon){
                        Weapon weapon = (Weapon)selectedItem;
                        Weapon oldWeapon = player.getWeapon();
                        player.getInventory().add(oldWeapon);
                        System.out.println(oldWeapon.getName() + " returned to inventory.");
                        player.setWeapon(weapon);
                        player.getInventory().remove(weapon);
                        System.out.println("Equipped " + selectedItem.getName() + "!");
                    }
                    else{
                        System.out.println("The item disappears right in front of you...");
                    }
                }
                else{
                    System.out.println("Inventory is empty!");
                }
            }
            for(int i = 0; i < board.getWidth(); i++) {
                for (int j = 0; j < board.getHeight(); j++) {
                    if (board.getTile(i, j).getPiece(1).getStringContents().equals("Hero")) {

                        if(board.getTile(i, j) instanceof FieldTile){
                            Random rand = new Random();
                            int randomNumber = rand.nextInt(5); // Generate a random number between 0 and 4

                            if (randomNumber == 0) {
                                System.out.println("Enemies spotted! A battle is starting!");
                                overworldSong.close();
                                new Battle(players, false, scanner);
                                try
                                {
                                    String filePath = "overworld.wav";
                                    overworldSong = new WavPlayer(filePath);
                                    overworldSong.playOnRepeat();
                                }
                                catch (Exception ex)
                                {
                                    System.out.println("Error with playing sound.");
                                    ex.printStackTrace();
                                }
                            }
                        }

                    }
                }
            }



        }
    }
    public static void sleepyTime(){
        try{
            Thread.sleep(750);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void shortSleepyTime(){
        try{
            Thread.sleep(500);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String professorOak(){
        return ".                                                                                                                                                    \n" +
                " %%                                                                                                                                                   \n" +
                "  ,/                                                                                                                                                  \n" +
                "    ,,                                                                                            %%                                                  \n" +
                "     //                                                                                            **,(*                                              \n" +
                "      #%                                                                                ,%@%%##*,,*,*******,*(%/,                                     \n" +
                "       //                                                                             (%(*,**************************,*#%/                            \n" +
                "        ,,                                                                         ./********,***%,,/@*,******,********,,*,*&                         \n" +
                "         .,(                                                                        &,,,,***,**#,,,,,,,,,%***,&%%#(/,,,,(*,**,#                       \n" +
                "           #&                                                                        /(,*****//,,,,,,,,,,,&/*#/,,,,,,,,,,,(****&                      \n" +
                "            @&                                                                        &******/,,,/,,,,,,,,,,,,,,,,,,,,,,,,,%*,**%                     \n" +
                "             %*                                                                         *,**(,(&&&&@,,,,,,,,,,,,,,,,,,,,*,,,%***(                     \n" +
                "              * ,                                                                        &/(@,,,&%&&&&*,,*,,*,,,,,,%&&&&&@,,(**,%                     \n" +
                "                ,#                                                                        &/%,,*    &*&@,/,,(,,&&&&&&@&@#/,&****,                     \n" +
                "                 (%                                                                      #%,/,,%   .@ ,,,,,,,,,,. ,    ,.,,%,*&&                      \n" +
                "                  %/                                                                     *,@,/,(%%#%* ,,,,,,,,,, %%    /,,,,,/%                       \n" +
                "                   (,*,/,                                                                *&%,,,,,,,,,,,,,,,,,,,,/((#/  %,,@*,*/#                      \n" +
                "                    & #,,,(                                                              #**,,,,,,,,,,,,&/*,,,,,,,,,,,#&,,/%////                      \n" +
                "                     &,@,,,.*                                                             %,,,*,&%*,,,,,,,,,,,,,,,,,,,,,,//////#                      \n" +
                "                       %%,,,,,%                                                           /,,,,,,##%&#%%(*,  ./(#%%(,%,,//#(/(,                       \n" +
                "                        &.*,,,,,,#                                                          %,,,,,,#((/////////(/##,,,,/%**                           \n" +
                "                         % @,,,,,,,%                                                          &,,,,,,,,,,,,**(*,,,,,,//&                              \n" +
                "                         .(.&,,,&/,,,&                                                     &%%%%&,,,,,,,,,,,,,,,,,*/&%%&                              \n" +
                "                     /,,,,,.@*,,,,,,,%,&                                            /%*  &%%%%%%%*#&#/,,,,,,,,,#%/(%%&%%&#*                           \n" +
                "                     %,,,,,,,,,&*/,,,,,/,(                                .%(.         %######&%&*////////////*///&%%%%%%#%..#*                       \n" +
                "                      %,,,,,,/%###////,,,,/                             ,*           %########%%&//////////////&%%&%%%%%%& /     (#                   \n" +
                "                      ,,,,,//////&&*///,,,,%                           ( %        ,%###########&,,,*///////(&%%%%%%%%#####@%          %*              \n" +
                "                      (%&%&&#%///.%*///,,,,/,                        %  .       .%##############&,,,,,,/#&%%%%%############ *             ,%          \n" +
                "                     (,,/////*&////***/,,,,,/                      %    @      #          &####%&@,,,#%####################&%             /  .,       \n" +
                "                      .%&%(&/*/////////*,,,/,  %                 /,     /     .*         (########&############%.     ,#&%##(*          &     (       \n" +
                "                             #*/////////%        *             ,*      ,        ,/      #&#####################&#            &        /        .      \n" +
                "                                /#//#*            (           (        &          .#//  ######################&   %      ,%          @         %      \n" +
                "                               **&                  %       %          #         &      &#####################%     ./@             @          .      \n" +
                "                            ./%                      ,,   %         * ,      (.        /#####################%         %.          &            &     \n" +
                "                            %.. /*                     ((           ( &      %         &######################            .       &             .     \n" +
                "                              *%*,,                      ,,         ( (      %         #####################%            *     # @               %    \n" +
                "                               *....                       /         (       %        @#####################&          .,     * (                #    \n" +
                "                                 #.&**,                    %         %       (        %#####################          /     # % *                 *   \n" +
                "                                   %&&..                   * %       #       ..      &#####################&         &      . #%                  @   \n" +
                "                                     &....                  (@      ,.        /      &#####################(        %      /  *,                  ,   \n" +
                "                                       &...                  .      (         %     .#####################%       .*       @  .*                   /  \n" +
                "                                         %...                       %         ,.    &#####################&      (.        &   %                   &  \n" +
                "                                           %..                      %          #    %#####################%     #          ,   &                   .  \n" +
                "                                             (..                  @ /          #   *######################(    /          ,    #                    ( \n" +
                "                                                %,             (/   ,          .,  @#####################%.   /                 *                   # \n" +
                "                                                     ,(&#/.  &     ,            &  %#####################&   .                  &       %            .\n" +
                "                                                                   *            .,*#####################%&   .                  *    @               %\n" +
                "                                                                   /             ((####################%%&  #                    @,                  #\n" +
                "                                                                   &              &%%%%%%%%%##########%%%& %                   ..                    ,\n" +
                "                                                                   #             .%%%%%%%%%%%%%%%%%%%%%%%&&                    (                     %\n" +
                "                                                                  .,             *%%%%@&%&&@@@@&&&&&/%@@%@                    /.                    # \n" +
                "                                                                  /              #%%%%%%&*&%%%%%%%%@*%%%%&                   %                     (  \n" +
                "                                                                  %              %#(((((/&&%%#%#(//*/&&%&@                  %                    .*   \n" +
                "                                                                  #              #,**********%***********%                 @                   ..,    \n" +
                "                                                                  *              &***********%***********%                @                  *...     \n" +
                "                                                                 /               %***********%***********%               @                 #**%.,     \n" +
                "                                                                 %               #**********,#***********#              %                 ...../      \n" +
                "                                                                 *              ,************#***********%             &%               #*/*.,*       \n" +
                "                                                                /&%#(*.&        *************(***********(               #**,#(        ./%%.,,        \n" +
                "                                                                %      @        #************/***********/.        ,           ,*(%&%%(*.../,(        \n" +
                "                                                                ,      &        %***&*******#************//       #                        / %        \n" +
                "                                                               /       &        (//((((@***/**************#       %                        # #        \n" +
                "                                                               &       &       ****/((((((#%%((((((#/*****#       /                        # (        \n" +
                "                                                               /       @       /******((((((((%%%*********%       ,                        % *        \n" +
                "                                                               .       @       (,*******(((((((&*********,&       .                        # .        \n" +
                "                                                              #        &       %**********(((((#,*********&       .                        #  *       \n" +
                "                                                              @        &       &************(((#,*********%       .                        /  /       \n" +
                "                                                              %        &       &**************((**********%       ,                        (  /       \n" +
                "                                                              .        &       %**************************#       *                        #  *       \n" +
                "                                                                       %       %**************************%       (                        #  /       \n" +
                "                                                             /         #       #**************************%       %                        *  /       \n" +
                "                                                             @@%%&&@@(         (****************/*********%         (&,                 *@.   (       \n" +
                "                                                             &                 #****************(*********%                                   %       \n" +
                "                                                             %                 %****************&*********%                                   %       \n" +
                "                                                             (                 &****************&*********#                                   &       \n" +
                "                                                             ,                 &****************&*********%                                   &       \n" +
                "                                                             *                 %,***************#*********(                                   %       \n" +
                "                                                              (&#*             /****************&*********/.                               .(%,       \n" +
                "                                                                        (***********************&***************************/.                        \n" +
                "                                                                         ***********************#***************************#                         \n" +
                "                                                                         ***********************%***************************%                         \n" +
                "                                                                         #**********************&/**************************%                         \n" +
                "                                                                         &**********************@(**************************%                         \n" +
                "                                                                         %**********************&(**************************%                         \n" +
                "                                                                         ,**********************#/(*************************%                         \n" +
                "                                                                          **********************(((*************************%                         \n" +
                "                                                                          #*********************(&(/************************%                         \n" +
                "                                                                          %********************/(&((************************&                         \n" +
                "                                                                          (********************((#((/*******************,***&                         \n" +
                "                                                                         &*************%*****/((((&((**************&********#                         \n" +
                "                                                                          (********/%**********(((&(((********(%************/.                        \n" +
                "                                                                          %***/(/*************(((((#(((/*********************%                        \n" +
                "                                                                          @*****,#&%%*,******((((((@((((*********#&@@@%*******#                       \n" +
                "                                                                          @%%%%%%%%%%%%%%%%%%@%(((/%(((((&&%%%%%%%%%%%%%%%@***%                       \n" +
                "                                                                        /%%%%%%%%%%%%%%%%%%%%%&&&&&(##&&&%%%%%%%%%%%%%%%%%%%/(                        \n" +
                "                                                                      &%%%%%%%%%%%%%%%%%%%%%%&&&&&@  &&&%%%%%%%%%%%%%%%%%%%%%(                        \n" +
                "                                                                   &%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&& &&&%%%%%%%%%%%%%%%%%%%%%%%&                       \n" +
                "                                                               .&%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&@&&&%%%%%%%%%%%%%%%%%%%%%%%%&                      \n" +
                "                                                              &%%%%%%%%%%%%%%%%%%%%%%%%%&@&@@@@@@&&@&&%%%%%%%%%%%%%%%%%%%%%%%%%%&                     \n" +
                "                                                               &%%%%%%%%%%%%%%%%%%%%&.   ........  &@&%%%%%%%%%%%%%%%%%%%%%%%%%%%                     \n" +
                "                                                                                                      %&&%%%%%%%%%%%%%%%%%%%&&(                ";
    }
}
