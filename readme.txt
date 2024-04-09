Kev’s Guide to Readme.txt or Readme.md
Required sections: Header, Files, Notes, How to compile and run, I/O Example

# CS611-Assignment 4
## Legends of Monsters and Heroes
---------------------------------------------------------------------------
Name: Isaac Hu
Email: ihu21@bu.edu
Student ID: U71457169

## Files
---------------------------------------------------------------------------

This section should be all of the source code files that have a .java extension. You should also include a brief description of what the class does.


Armor- A class for representing armor stats
ArmorCreator- a factory that facilitates the creation of armor objects, based on the templates of the text file
BalancedMonsterCreator- a factory that facilitates the random creation of monster objects, based on the templates of the text file
Battle- A interactive display class representing the fighting between monsters and heroes
Board- A class representing the state of the overworld, with its montains and lakes
Dragon- A class for representing dragon stats
Exoskeleton- A class for representing exoskeleton stats
FieldInteraction- A strategy pattern for interacting with tiles of type FieldTile
FieldTile- A type of tile that holds the string field, and has a 50% chance of spawning a monster when interacted with
Hero- An abstract class representing the stats of any type of player character
InputParser- A class whose methods are called for ensuring proper inputs
InteractionStrategy- An interface who specifies the existence of an interact method, with players, a scanner, and a tile as input
Inventory- A class that contains an arraylist of items, to be held by the hero, with a convenient toString.
Item- An abstract class representing anything that a hero can hold in their inventory.
ItemCreator- An interface that specifies that all the more specific factory classes must have a retrieveItem() method for their particular type of item.
Main- A class that starts the game, spawning an overworld.
Market- A class that exists on a market tile, providing an interactive interface for heroes to buy and sell.
MarketInteraction- A strategy pattern class detailing what should happen when the interact method is called on a MarketTile
MarketTile- A tile that has a market on it, which will open it to the player when interacted with
Monster- A class representing the stats of any type of monster
MonsterCreator- A factory class for the creation of Monster objects
Overworld- A class representing the game world outside of battles and the marketplace, where the player can explore the map
Paladin- An implementation of hero with specific stats raised
Piece- An object that exists on top of a tile, to give an indicator to the toString method as to what kind of terrain to place on the tile
Potion- An item object that can be used by players to increase certain attributes, buyable at markets
PotionCreator- A factory class for the creation of potions, based on the stats specified in the text files
RandomMonsterCreator- A factory class for monsters that randomizes the stats and the number of monsters
Sorcerer- An implementation of the hero class that prioritizes certain stats
Spell- A type of single use item that can inflict massive damage on monsters
SpellCreator- A factory class for the creation of new spell objects, based on the specifications in the text files
Spirit- An implementation of the monster class that represents a ghost
Tile- A class that represents a space on the board, usually replaced by Market or Field tiles if interactable
Warrior- An implementation of the hero class that favors certain stats
WavPlayer- A class for playing sounds and music during the game
Weapon- A class for representing the stats of a weapon
WeaponCreator- A factory for building weapons, based on the specifications of the text file



## Notes
---------------------------------------------------------------------------
Please explain the cool features of your program. Anything that you feel like you did a good job at or were creative about, explain it in bullets here. Additionally, any design decisions should be made here.

Example.

1. I used a paintbucket fill algorithm and DFS to ensure that the player will never be trapped by impassable tiles
2. I wrote algorithms to generate mountains in roughly the shape of a mountain range, as well as a lake roughly in the shape of a body of water
3. I've implemented music for the overworld, markets, and battles!
4. There are ascii sprites for enemies

Design decisions:
I create all types of monsters and items through factories, to abstract away the more complicated aspects of parsing data from text files into workable objects for the game; the factory simply allows me to call a method, and get a item or monster.

I use strategy pattern to dictate player movement through tiles that are passable; for field and market tiles, they each have their own interact method, since they inherit from tile which extends the interaction strategy interface. Their version of the method calls a FieldInteraction and MarketInteraction class respectively, one spawning monsters with a 50% chance, and the other allowing the player to enter markets.

## Citaions
---------------------------------------------------------------------------
https://tekolio.com/how-to-add-and-remove-an-element-from-an-array-at-a-specific-index-in-java/ //used to remove colors after they had been assigned
https://stackoverflow.com/questions/2143476/how-to-cast-a-double-to-an-int-in-java-by-rounding-it-down
https://www.reddit.com/r/learnprogramming/comments/3sg06m/c_flood_fill_algorithm_in_a_2d_int_array/
https://www.geeksforgeeks.org/play-audio-file-using-java/#
https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/

## How to compile and run
---------------------------------------------------------------------------
Your directions on how to run the code. Ideally should resemble the lines below

1. Navigate to the directory where you unzipped the files in your terminal
2. Run the following instructions:
javac *.java -d bin
java -cp ./bin Main
3. Play the game!

## Input/Output Example
---------------------------------------------------------------------------
Please give us a full execution of what we should see on the screen. Label each text with input and output. For example:
WELCOME TO THE WORLD OF HEROES AND MONSTERS
LONG AGO, OUR BLESSED LAND WAS SPLIT FROM THE FIRMAMENTS
HEMMED IN BY GREAT SEAS AND LOFTY MOUNTAINS, OUR PEOPLE PROSPERED IN THE ISOLATION OF FRUITFUL FIELDS AND ROLLING PLAINS
IN TIME, THIS PARADISE BECAME OUR WEAKNESS
LIKE SHEEP TO A SLAUGHTER, OUR PEOPLE GREW COMPLACENT, AND SOON, DISASTER STRUCK
COVETING THE BOUNTY OF OUR LAND, VILE MONSTERS CAME OUT FROM THE MOUNTAINS AND THE FORESTS TO WREAK HAVOC
THE ROYAL ARMY WAS DECIMATED. THE KING IS EVANESCENT.
NOW, CHOSEN HEROES, THE TIME HAS COME FOR YOU TO SAVE THE WORLD!
To begin...
.                                                                                                                                                    
 %%                                                                                                                                                   
  ,/                                                                                                                                                  
    ,,                                                                                            %%                                                  
     //                                                                                            **,(*                                              
      #%                                                                                ,%@%%##*,,*,*******,*(%/,                                     
       //                                                                             (%(*,**************************,*#%/                            
        ,,                                                                         ./********,***%,,/@*,******,********,,*,*&                         
         .,(                                                                        &,,,,***,**#,,,,,,,,,%***,&%%#(/,,,,(*,**,#                       
           #&                                                                        /(,*****//,,,,,,,,,,,&/*#/,,,,,,,,,,,(****&                      
            @&                                                                        &******/,,,/,,,,,,,,,,,,,,,,,,,,,,,,,%*,**%                     
             %*                                                                         *,**(,(&&&&@,,,,,,,,,,,,,,,,,,,,*,,,%***(                     
              * ,                                                                        &/(@,,,&%&&&&*,,*,,*,,,,,,%&&&&&@,,(**,%                     
                ,#                                                                        &/%,,*    &*&@,/,,(,,&&&&&&@&@#/,&****,                     
                 (%                                                                      #%,/,,%   .@ ,,,,,,,,,,. ,    ,.,,%,*&&                      
                  %/                                                                     *,@,/,(%%#%* ,,,,,,,,,, %%    /,,,,,/%                       
                   (,*,/,                                                                *&%,,,,,,,,,,,,,,,,,,,,/((#/  %,,@*,*/#                      
                    & #,,,(                                                              #**,,,,,,,,,,,,&/*,,,,,,,,,,,#&,,/%////                      
                     &,@,,,.*                                                             %,,,*,&%*,,,,,,,,,,,,,,,,,,,,,,//////#                      
                       %%,,,,,%                                                           /,,,,,,##%&#%%(*,  ./(#%%(,%,,//#(/(,                       
                        &.*,,,,,,#                                                          %,,,,,,#((/////////(/##,,,,/%**                           
                         % @,,,,,,,%                                                          &,,,,,,,,,,,,**(*,,,,,,//&                              
                         .(.&,,,&/,,,&                                                     &%%%%&,,,,,,,,,,,,,,,,,*/&%%&                              
                     /,,,,,.@*,,,,,,,%,&                                            /%*  &%%%%%%%*#&#/,,,,,,,,,#%/(%%&%%&#*                           
                     %,,,,,,,,,&*/,,,,,/,(                                .%(.         %######&%&*////////////*///&%%%%%%#%..#*                       
                      %,,,,,,/%###////,,,,/                             ,*           %########%%&//////////////&%%&%%%%%%& /     (#                   
                      ,,,,,//////&&*///,,,,%                           ( %        ,%###########&,,,*///////(&%%%%%%%%#####@%          %*              
                      (%&%&&#%///.%*///,,,,/,                        %  .       .%##############&,,,,,,/#&%%%%%############ *             ,%          
                     (,,/////*&////***/,,,,,/                      %    @      #          &####%&@,,,#%####################&%             /  .,       
                      .%&%(&/*/////////*,,,/,  %                 /,     /     .*         (########&############%.     ,#&%##(*          &     (       
                             #*/////////%        *             ,*      ,        ,/      #&#####################&#            &        /        .      
                                /#//#*            (           (        &          .#//  ######################&   %      ,%          @         %      
                               **&                  %       %          #         &      &#####################%     ./@             @          .      
                            ./%                      ,,   %         * ,      (.        /#####################%         %.          &            &     
                            %.. /*                     ((           ( &      %         &######################            .       &             .     
                              *%*,,                      ,,         ( (      %         #####################%            *     # @               %    
                               *....                       /         (       %        @#####################&          .,     * (                #    
                                 #.&**,                    %         %       (        %#####################          /     # % *                 *   
                                   %&&..                   * %       #       ..      &#####################&         &      . #%                  @   
                                     &....                  (@      ,.        /      &#####################(        %      /  *,                  ,   
                                       &...                  .      (         %     .#####################%       .*       @  .*                   /  
                                         %...                       %         ,.    &#####################&      (.        &   %                   &  
                                           %..                      %          #    %#####################%     #          ,   &                   .  
                                             (..                  @ /          #   *######################(    /          ,    #                    ( 
                                                %,             (/   ,          .,  @#####################%.   /                 *                   # 
                                                     ,(&#/.  &     ,            &  %#####################&   .                  &       %            .
                                                                   *            .,*#####################%&   .                  *    @               %
                                                                   /             ((####################%%&  #                    @,                  #
                                                                   &              &%%%%%%%%%##########%%%& %                   ..                    ,
                                                                   #             .%%%%%%%%%%%%%%%%%%%%%%%&&                    (                     %
                                                                  .,             *%%%%@&%&&@@@@&&&&&/%@@%@                    /.                    # 
                                                                  /              #%%%%%%&*&%%%%%%%%@*%%%%&                   %                     (  
                                                                  %              %#(((((/&&%%#%#(//*/&&%&@                  %                    .*   
                                                                  #              #,**********%***********%                 @                   ..,    
                                                                  *              &***********%***********%                @                  *...     
                                                                 /               %***********%***********%               @                 #**%.,     
                                                                 %               #**********,#***********#              %                 ...../      
                                                                 *              ,************#***********%             &%               #*/*.,*       
                                                                /&%#(*.&        *************(***********(               #**,#(        ./%%.,,        
                                                                %      @        #************/***********/.        ,           ,*(%&%%(*.../,(        
                                                                ,      &        %***&*******#************//       #                        / %        
                                                               /       &        (//((((@***/**************#       %                        # #        
                                                               &       &       ****/((((((#%%((((((#/*****#       /                        # (        
                                                               /       @       /******((((((((%%%*********%       ,                        % *        
                                                               .       @       (,*******(((((((&*********,&       .                        # .        
                                                              #        &       %**********(((((#,*********&       .                        #  *       
                                                              @        &       &************(((#,*********%       .                        /  /       
                                                              %        &       &**************((**********%       ,                        (  /       
                                                              .        &       %**************************#       *                        #  *       
                                                                       %       %**************************%       (                        #  /       
                                                             /         #       #**************************%       %                        *  /       
                                                             @@%%&&@@(         (****************/*********%         (&,                 *@.   (       
                                                             &                 #****************(*********%                                   %       
                                                             %                 %****************&*********%                                   %       
                                                             (                 &****************&*********#                                   &       
                                                             ,                 &****************&*********%                                   &       
                                                             *                 %,***************#*********(                                   %       
                                                              (&#*             /****************&*********/.                               .(%,       
                                                                        (***********************&***************************/.                        
                                                                         ***********************#***************************#                         
                                                                         ***********************%***************************%                         
                                                                         #**********************&/**************************%                         
                                                                         &**********************@(**************************%                         
                                                                         %**********************&(**************************%                         
                                                                         ,**********************#/(*************************%                         
                                                                          **********************(((*************************%                         
                                                                          #*********************(&(/************************%                         
                                                                          %********************/(&((************************&                         
                                                                          (********************((#((/*******************,***&                         
                                                                         &*************%*****/((((&((**************&********#                         
                                                                          (********/%**********(((&(((********(%************/.                        
                                                                          %***/(/*************(((((#(((/*********************%                        
                                                                          @*****,#&%%*,******((((((@((((*********#&@@@%*******#                       
                                                                          @%%%%%%%%%%%%%%%%%%@%(((/%(((((&&%%%%%%%%%%%%%%%@***%                       
                                                                        /%%%%%%%%%%%%%%%%%%%%%&&&&&(##&&&%%%%%%%%%%%%%%%%%%%/(                        
                                                                      &%%%%%%%%%%%%%%%%%%%%%%&&&&&@  &&&%%%%%%%%%%%%%%%%%%%%%(                        
                                                                   &%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&& &&&%%%%%%%%%%%%%%%%%%%%%%%&                       
                                                               .&%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&@&&&%%%%%%%%%%%%%%%%%%%%%%%%&                      
                                                              &%%%%%%%%%%%%%%%%%%%%%%%%%&@&@@@@@@&&@&&%%%%%%%%%%%%%%%%%%%%%%%%%%&                     
                                                               &%%%%%%%%%%%%%%%%%%%%&.   ........  &@&%%%%%%%%%%%%%%%%%%%%%%%%%%%                     
                                                                                                      %&&%%%%%%%%%%%%%%%%%%%&&(                
What is your name? (Q) quit
Isaac
.
..
...
That's a wonderful name, Isaac! Unfortunately I already picked one out for you. Lets begin!!!
Welcome to the overworld! As you can see, our world is composed of passable plains tiles, alongside
great mountains(∧), lakes(~), and towns(M).
Movement is easy across plains and markets, and impossible on lakes and mountains.
Use WASD to move your hero tile(H) across the board.
At each tile, you can open your party menu, and check the inventories of your heroes.
Additionally, you can interact with your tile, which can either mean going into a market to shop, or searching fields for enemies.
For each non-market tile you pass through, there is also a chance for a surprise ambush by monsters!
Kill monsters to gain gold and level up, and use gold to purchase spells, potions, armor, and weapons from the markets!
Each market has different items, so make sure to really explore!
How big would you like the board to be? (8-16) (Q) quit
8
How many heroes would you like? (1-3) (Q) quit
3
You've selected the maximum party size, so you will have 1 paladin, 1 warrior, and 1 sorcerer!
Here is your party!
1. Name: Eunoia_Cyn, Health: 100, Mana: 400, Level: 1, Experience: 0, Strength: 700, Agility: 800, Dexterity: 600, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
2. Name: Segojan_Earthcaller, Health: 100, Mana: 900, Level: 1, Experience: 0, Strength: 800, Agility: 500, Dexterity: 650, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
3. Name: Parzival, Health: 100, Mana: 300, Level: 1, Experience: 0, Strength: 750, Agility: 650, Dexterity: 700, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	  	|	M 	|	  	|	  	|	  	|	M 	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	  	|	  	|	M 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	~ 	|	~ 	|	~ 	|	  	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	~ 	|	~ 	|	~ 	|	H 	|	  	|	  	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	M 	|	~ 	|	∧ 	|	  	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	M 	|	∧ 	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	  	|	M 	|	  	|	∧ 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	  	|	  	|	∧ 	|	∧ 	|	∧ 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
WASD to move, (P) check party, (I) interact, (Q) quit
d
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	  	|	M 	|	  	|	  	|	  	|	M 	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	  	|	  	|	M 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	~ 	|	~ 	|	~ 	|	  	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	~ 	|	~ 	|	~ 	|	  	|	H 	|	  	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	M 	|	~ 	|	∧ 	|	  	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	M 	|	∧ 	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	  	|	M 	|	  	|	∧ 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	  	|	  	|	∧ 	|	∧ 	|	∧ 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
WASD to move, (P) check party, (I) interact, (Q) quit
d
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	  	|	M 	|	  	|	  	|	  	|	M 	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	  	|	  	|	M 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	~ 	|	~ 	|	~ 	|	  	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	~ 	|	~ 	|	~ 	|	  	|	  	|	H 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	M 	|	~ 	|	∧ 	|	  	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	M 	|	∧ 	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	  	|	M 	|	  	|	∧ 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	  	|	  	|	∧ 	|	∧ 	|	∧ 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
WASD to move, (P) check party, (I) interact, (Q) quit
s
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	  	|	M 	|	  	|	  	|	  	|	M 	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	  	|	  	|	M 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	~ 	|	~ 	|	~ 	|	  	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	~ 	|	~ 	|	~ 	|	  	|	  	|	  	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	M 	|	~ 	|	∧ 	|	  	|	H 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	M 	|	∧ 	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	  	|	M 	|	  	|	∧ 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	  	|	  	|	∧ 	|	∧ 	|	∧ 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
WASD to move, (P) check party, (I) interact, (Q) quit
i
Entering the market!
1. Name: Strength_Potion, Cost: 200, Required Level: 1, Attribute Increase: 75, Attribute Affected: Strength
2. Name: Guardian_Angel, Cost: 1000, Required Level: 10, Damage Reduction: 1000
3. Name: Dagger, Cost: 200, Required Level: 1, Damage: 250, RequiredHands: 1
4. Name: Scythe, Cost: 1000, Required Level: 6, Damage: 1100, RequiredHands: 2
5. Name: Ice_Blade, Cost: 250, Required Level: 1, Damage: 450, Mana Cost: 100, Type: Ice

Welcome to the market! Would you like to (1) Buy (2) Sell (B) Go back to world screen (Q) quit
1
Which player would you like to go in? (Q) quit
1. Name: Eunoia_Cyn, Health: 100, Mana: 400, Level: 1, Experience: 0, Strength: 700, Agility: 800, Dexterity: 600, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
2. Name: Segojan_Earthcaller, Health: 100, Mana: 900, Level: 1, Experience: 0, Strength: 800, Agility: 500, Dexterity: 650, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
3. Name: Parzival, Health: 100, Mana: 300, Level: 1, Experience: 0, Strength: 750, Agility: 650, Dexterity: 700, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
1
1. Name: Strength_Potion, Cost: 200, Required Level: 1, Attribute Increase: 75, Attribute Affected: Strength
2. Name: Guardian_Angel, Cost: 1000, Required Level: 10, Damage Reduction: 1000
3. Name: Dagger, Cost: 200, Required Level: 1, Damage: 250, RequiredHands: 1
4. Name: Scythe, Cost: 1000, Required Level: 6, Damage: 1100, RequiredHands: 2
5. Name: Ice_Blade, Cost: 250, Required Level: 1, Damage: 450, Mana Cost: 100, Type: Ice

What would you like to Buy?
Select an item! (B) back
3
Player Eunoia_Cyn purchased Dagger for 200.
2300 funds remaining.
Eunoia_Cyn's inventory: 
1. Name: Dagger, Cost: 200, Required Level: 1, Damage: 250, RequiredHands: 1

Welcome to the market! Would you like to (1) Buy (2) Sell (B) Go back to world screen (Q) quit
1
Which player would you like to go in? (Q) quit
1. Name: Eunoia_Cyn, Health: 100, Mana: 400, Level: 1, Experience: 0, Strength: 700, Agility: 800, Dexterity: 600, Starting Money: 2300, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
2. Name: Segojan_Earthcaller, Health: 100, Mana: 900, Level: 1, Experience: 0, Strength: 800, Agility: 500, Dexterity: 650, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
3. Name: Parzival, Health: 100, Mana: 300, Level: 1, Experience: 0, Strength: 750, Agility: 650, Dexterity: 700, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
2
1. Name: Strength_Potion, Cost: 200, Required Level: 1, Attribute Increase: 75, Attribute Affected: Strength
2. Name: Guardian_Angel, Cost: 1000, Required Level: 10, Damage Reduction: 1000
3. Name: Scythe, Cost: 1000, Required Level: 6, Damage: 1100, RequiredHands: 2
4. Name: Ice_Blade, Cost: 250, Required Level: 1, Damage: 450, Mana Cost: 100, Type: Ice

What would you like to Buy?
Select an item! (B) back
4
Player Segojan_Earthcaller purchased Ice_Blade for 250.
2250 funds remaining.
Segojan_Earthcaller's inventory: 
1. Name: Ice_Blade, Cost: 250, Required Level: 1, Damage: 450, Mana Cost: 100, Type: Ice

Welcome to the market! Would you like to (1) Buy (2) Sell (B) Go back to world screen (Q) quit
2
Which player would you like to go in? (Q) quit
1. Name: Eunoia_Cyn, Health: 100, Mana: 400, Level: 1, Experience: 0, Strength: 700, Agility: 800, Dexterity: 600, Starting Money: 2300, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
2. Name: Segojan_Earthcaller, Health: 100, Mana: 900, Level: 1, Experience: 0, Strength: 800, Agility: 500, Dexterity: 650, Starting Money: 2250, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
3. Name: Parzival, Health: 100, Mana: 300, Level: 1, Experience: 0, Strength: 750, Agility: 650, Dexterity: 700, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
1
1. Dagger || 200 gold

What would you like to sell?
Select an item! (B) back
1
Item Dagger sold for 100 gold.
2400 funds remaining.
Eunoia_Cyn's inventory: 

Welcome to the market! Would you like to (1) Buy (2) Sell (B) Go back to world screen (Q) quit
1
Which player would you like to go in? (Q) quit
1. Name: Eunoia_Cyn, Health: 100, Mana: 400, Level: 1, Experience: 0, Strength: 700, Agility: 800, Dexterity: 600, Starting Money: 2400, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
2. Name: Segojan_Earthcaller, Health: 100, Mana: 900, Level: 1, Experience: 0, Strength: 800, Agility: 500, Dexterity: 650, Starting Money: 2250, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
3. Name: Parzival, Health: 100, Mana: 300, Level: 1, Experience: 0, Strength: 750, Agility: 650, Dexterity: 700, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
1
1. Name: Strength_Potion, Cost: 200, Required Level: 1, Attribute Increase: 75, Attribute Affected: Strength
2. Name: Guardian_Angel, Cost: 1000, Required Level: 10, Damage Reduction: 1000
3. Name: Scythe, Cost: 1000, Required Level: 6, Damage: 1100, RequiredHands: 2
4. Name: Dagger, Cost: 200, Required Level: 1, Damage: 250, RequiredHands: 1

What would you like to Buy?
Select an item! (B) back
4
Player Eunoia_Cyn purchased Dagger for 200.
2200 funds remaining.
Eunoia_Cyn's inventory: 
1. Name: Dagger, Cost: 200, Required Level: 1, Damage: 250, RequiredHands: 1

Welcome to the market! Would you like to (1) Buy (2) Sell (B) Go back to world screen (Q) quit
1
Which player would you like to go in? (Q) quit
1. Name: Eunoia_Cyn, Health: 100, Mana: 400, Level: 1, Experience: 0, Strength: 700, Agility: 800, Dexterity: 600, Starting Money: 2200, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
2. Name: Segojan_Earthcaller, Health: 100, Mana: 900, Level: 1, Experience: 0, Strength: 800, Agility: 500, Dexterity: 650, Starting Money: 2250, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
3. Name: Parzival, Health: 100, Mana: 300, Level: 1, Experience: 0, Strength: 750, Agility: 650, Dexterity: 700, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
b
1
1. Name: Strength_Potion, Cost: 200, Required Level: 1, Attribute Increase: 75, Attribute Affected: Strength
2. Name: Guardian_Angel, Cost: 1000, Required Level: 10, Damage Reduction: 1000
3. Name: Scythe, Cost: 1000, Required Level: 6, Damage: 1100, RequiredHands: 2

What would you like to Buy?
Select an item! (B) back
b
Welcome to the market! Would you like to (1) Buy (2) Sell (B) Go back to world screen (Q) quit
b
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	  	|	M 	|	  	|	  	|	  	|	M 	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	  	|	  	|	M 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	~ 	|	~ 	|	~ 	|	  	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	~ 	|	~ 	|	~ 	|	  	|	  	|	  	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	M 	|	~ 	|	∧ 	|	  	|	H 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	M 	|	∧ 	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	  	|	M 	|	  	|	∧ 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	  	|	  	|	∧ 	|	∧ 	|	∧ 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
WASD to move, (P) check party, (I) interact, (Q) quit
a
Enemies spotted! A battle is starting!
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Name: Natsunomeryu, Level: 1, Health: 100, Base Damage: 100, Defense: 200, Dodge Ability: 10
         /\_/\
     /\  |6 6|  /\
    /  \ \<">/ /  \
   / ,__`~)-(~___, \
  /.',-'`/_/`'-,  '.\
   ,'    \_\    ',
  :       \|\     ;
   ',     /|/    ,'
     '-,__\W\_,-))
               ((
                )
Name: Blinky, Level: 1, Health: 100, Base Damage: 450, Defense: 350, Dodge Ability: 35
        ___
      _/ 66\
     ( \  ^/__
      \    \__)
      /     \
     /      _\
    `"""""``
Name: Natsunomeryu, Level: 1, Health: 100, Base Damage: 100, Defense: 200, Dodge Ability: 10
         /\_/\
     /\  |6 6|  /\
    /  \ \<">/ /  \
   / ,__`~)-(~___, \
  /.',-'`/_/`'-,  '.\
   ,'    \_\    ',
  :       \|\     ;
   ',     /|/    ,'
     '-,__\W\_,-))
               ((
                )
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Eunoia_Cyn's turn!
Name: Eunoia_Cyn, Health: 100, Mana: 400, Level: 1, Experience: 0, Strength: 700, Agility: 800, Dexterity: 600, Starting Money: 2200, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
(1) attack (2) inventory (P) check party (Q) quit
1
Which monster would you like to attack? (1) (2) (3) (Q) quit
1
Player Eunoia_Cyn attacked monster Natsunomeryu for 34 damage!
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Name: Natsunomeryu, Level: 1, Health: 66, Base Damage: 100, Defense: 200, Dodge Ability: 10
         /\_/\
     /\  |6 6|  /\
    /  \ \<">/ /  \
   / ,__`~)-(~___, \
  /.',-'`/_/`'-,  '.\
   ,'    \_\    ',
  :       \|\     ;
   ',     /|/    ,'
     '-,__\W\_,-))
               ((
                )
Name: Blinky, Level: 1, Health: 100, Base Damage: 450, Defense: 350, Dodge Ability: 35
        ___
      _/ 66\
     ( \  ^/__
      \    \__)
      /     \
     /      _\
    `"""""``
Name: Natsunomeryu, Level: 1, Health: 100, Base Damage: 100, Defense: 200, Dodge Ability: 10
         /\_/\
     /\  |6 6|  /\
    /  \ \<">/ /  \
   / ,__`~)-(~___, \
  /.',-'`/_/`'-,  '.\
   ,'    \_\    ',
  :       \|\     ;
   ',     /|/    ,'
     '-,__\W\_,-))
               ((
                )
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Segojan_Earthcaller's turn!
Name: Segojan_Earthcaller, Health: 100, Mana: 900, Level: 1, Experience: 0, Strength: 800, Agility: 500, Dexterity: 650, Starting Money: 2250, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
(1) attack (2) inventory (P) check party (Q) quit
1
Which monster would you like to attack? (1) (2) (3) (Q) quit
1
Player Segojan_Earthcaller attacked monster Natsunomeryu for 39 damage!
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Name: Natsunomeryu, Level: 1, Health: 27, Base Damage: 100, Defense: 200, Dodge Ability: 10
         /\_/\
     /\  |6 6|  /\
    /  \ \<">/ /  \
   / ,__`~)-(~___, \
  /.',-'`/_/`'-,  '.\
   ,'    \_\    ',
  :       \|\     ;
   ',     /|/    ,'
     '-,__\W\_,-))
               ((
                )
Name: Blinky, Level: 1, Health: 100, Base Damage: 450, Defense: 350, Dodge Ability: 35
        ___
      _/ 66\
     ( \  ^/__
      \    \__)
      /     \
     /      _\
    `"""""``
Name: Natsunomeryu, Level: 1, Health: 100, Base Damage: 100, Defense: 200, Dodge Ability: 10
         /\_/\
     /\  |6 6|  /\
    /  \ \<">/ /  \
   / ,__`~)-(~___, \
  /.',-'`/_/`'-,  '.\
   ,'    \_\    ',
  :       \|\     ;
   ',     /|/    ,'
     '-,__\W\_,-))
               ((
                )
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Parzival's turn!
Name: Parzival, Health: 100, Mana: 300, Level: 1, Experience: 0, Strength: 750, Agility: 650, Dexterity: 700, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
(1) attack (2) inventory (P) check party (Q) quit
2
Player Parzival's inventory is empty. You must attack!
Which monster would you like to attack? (1) (2) (3) (Q) quit
1
Player Parzival attacked monster Natsunomeryu for 36 damage!
Monster Natsunomeryu was obliterated!
####################################################################################################
Monster Blinky attacked player Eunoia_Cyn for 24 damage!
Monster Natsunomeryu attacked player Segojan_Earthcaller for 2 damage!
####################################################################################################
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Name: Blinky, Level: 1, Health: 100, Base Damage: 450, Defense: 350, Dodge Ability: 35
        ___
      _/ 66\
     ( \  ^/__
      \    \__)
      /     \
     /      _\
    `"""""``
Name: Natsunomeryu, Level: 1, Health: 100, Base Damage: 100, Defense: 200, Dodge Ability: 10
         /\_/\
     /\  |6 6|  /\
    /  \ \<">/ /  \
   / ,__`~)-(~___, \
  /.',-'`/_/`'-,  '.\
   ,'    \_\    ',
  :       \|\     ;
   ',     /|/    ,'
     '-,__\W\_,-))
               ((
                )
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Eunoia_Cyn's turn!
Name: Eunoia_Cyn, Health: 83, Mana: 400, Level: 1, Experience: 0, Strength: 700, Agility: 800, Dexterity: 600, Starting Money: 2200, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
(1) attack (2) inventory (P) check party (Q) quit
2
Select an item!
1. Name: Dagger, Cost: 200, Required Level: 1, Damage: 250, RequiredHands: 1

1
Stick returned to inventory.
Equipped Dagger!
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Name: Blinky, Level: 1, Health: 100, Base Damage: 450, Defense: 350, Dodge Ability: 35
        ___
      _/ 66\
     ( \  ^/__
      \    \__)
      /     \
     /      _\
    `"""""``
Name: Natsunomeryu, Level: 1, Health: 100, Base Damage: 100, Defense: 200, Dodge Ability: 10
         /\_/\
     /\  |6 6|  /\
    /  \ \<">/ /  \
   / ,__`~)-(~___, \
  /.',-'`/_/`'-,  '.\
   ,'    \_\    ',
  :       \|\     ;
   ',     /|/    ,'
     '-,__\W\_,-))
               ((
                )
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Segojan_Earthcaller's turn!
Name: Segojan_Earthcaller, Health: 100, Mana: 900, Level: 1, Experience: 0, Strength: 800, Agility: 500, Dexterity: 650, Starting Money: 2250, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
(1) attack (2) inventory (P) check party (Q) quit
2
Select an item!
1. Name: Ice_Blade, Cost: 250, Required Level: 1, Damage: 450, Mana Cost: 100, Type: Ice

1
Which monster would you like to attack? (1) (2) (Q) quit
2
Spell Ice_Blade was consumed!
Player Segojan_Earthcaller attacked monster Natsunomeryu for 479 damage!
Monster Natsunomeryu was obliterated!
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Name: Blinky, Level: 1, Health: 100, Base Damage: 450, Defense: 350, Dodge Ability: 35
        ___
      _/ 66\
     ( \  ^/__
      \    \__)
      /     \
     /      _\
    `"""""``
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Parzival's turn!
Name: Parzival, Health: 100, Mana: 300, Level: 1, Experience: 0, Strength: 750, Agility: 650, Dexterity: 700, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
(1) attack (2) inventory (P) check party (Q) quit
1
Which monster would you like to attack? (1) (Q) quit
1
The monster Blinky dodged the attack!
####################################################################################################
Monster Blinky attacked player Parzival for 11 damage!
####################################################################################################
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Name: Blinky, Level: 1, Health: 100, Base Damage: 450, Defense: 350, Dodge Ability: 35
        ___
      _/ 66\
     ( \  ^/__
      \    \__)
      /     \
     /      _\
    `"""""``
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Eunoia_Cyn's turn!
Name: Eunoia_Cyn, Health: 91, Mana: 400, Level: 1, Experience: 0, Strength: 700, Agility: 800, Dexterity: 600, Starting Money: 2200, Weapon: Dagger, Weapon Damage: 250, Armor: Birthday Suit, Armor Defense: 0
(1) attack (2) inventory (P) check party (Q) quit
1
Which monster would you like to attack? (1) (Q) quit
1
Player Eunoia_Cyn attacked monster Blinky for 36 damage!
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Name: Blinky, Level: 1, Health: 64, Base Damage: 450, Defense: 350, Dodge Ability: 35
        ___
      _/ 66\
     ( \  ^/__
      \    \__)
      /     \
     /      _\
    `"""""``
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Segojan_Earthcaller's turn!
Name: Segojan_Earthcaller, Health: 100, Mana: 900, Level: 1, Experience: 0, Strength: 800, Agility: 500, Dexterity: 650, Starting Money: 2250, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
(1) attack (2) inventory (P) check party (Q) quit
1
Which monster would you like to attack? (1) (Q) quit
1
Player Segojan_Earthcaller attacked monster Blinky for 34 damage!
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Name: Blinky, Level: 1, Health: 30, Base Damage: 450, Defense: 350, Dodge Ability: 35
        ___
      _/ 66\
     ( \  ^/__
      \    \__)
      /     \
     /      _\
    `"""""``
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Parzival's turn!
Name: Parzival, Health: 100, Mana: 300, Level: 1, Experience: 0, Strength: 750, Agility: 650, Dexterity: 700, Starting Money: 2500, Weapon: Stick, Weapon Damage: 100, Armor: Birthday Suit, Armor Defense: 0
(1) attack (2) inventory (P) check party (Q) quit
1
Which monster would you like to attack? (1) (Q) quit
1
Player Parzival attacked monster Blinky for 31 damage!
Monster Blinky was obliterated!
You successfully defeated all the monsters!
Eunoia_Cyn got 300 gold and 6 experience!
Segojan_Earthcaller got 300 gold and 6 experience!
Parzival got 300 gold and 6 experience!
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	  	|	M 	|	  	|	  	|	  	|	M 	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	  	|	  	|	M 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	M 	|	~ 	|	~ 	|	~ 	|	  	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	~ 	|	~ 	|	~ 	|	  	|	  	|	  	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	M 	|	~ 	|	∧ 	|	H 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	M 	|	M 	|	∧ 	|	  	|	  	|	M 	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	M 	|	  	|	M 	|	  	|	∧ 	|	M 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
|	  	|	  	|	  	|	  	|	∧ 	|	∧ 	|	∧ 	|	  	|
+-------+-------+-------+-------+-------+-------+-------+-------+
WASD to move, (P) check party, (I) interact, (Q) quit
q

