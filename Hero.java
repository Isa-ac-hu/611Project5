//File Name: Hero.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: An abstract class representing the stats of any type of player character

public abstract class Hero {

    private int level;
    private String name;

    private int experience;
    private int HP;
    private int MP;
    private int totalMP;
    private int strength;
    private int dexterity;
    private int agility;
    private int gold;

    private Weapon weapon;
    private Armor armor;
    private Inventory inventory;
    public Hero(){
        level = 1;
        experience = 0;
        HP = level * 100;
        inventory = new Inventory();
        weapon = new Weapon("Stick", 0, 0, 100, 1);
        armor = new Armor("Birthday Suit", 0, 0, 0);
    }

    public void incrementExperience(int amount){
        experience += amount;
    }
    public void setName(String ourName){
        name = ourName;
    }
    public void setHP(int ourHP){
        HP = ourHP;
    }
    public void setMP(int ourMP){
        MP = ourMP;
    }
    public void setTotalMP(int ourMP){
        totalMP = ourMP;
    }
    public void setStrength(int ourStrength){
        strength = ourStrength;
    }
    public void setDexterity(int ourDexterity){
        dexterity = ourDexterity;
    }
    public void setAgility(int ourAgility){
        agility = ourAgility;
    }
    public void setGold(int ourGold){
        gold = ourGold;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public void setArmor(Armor armor){
        this.armor = armor;
    }
    public String getName(){
        return name;
    }
    public int getHP(){
        return HP;
    }
    public int getMP(){
        return MP;
    }
    public int getTotalMP(){
        return totalMP;
    }
    public int getStrength(){
        return strength;
    }
    public int getDexterity(){
        return dexterity;
    }
    public int getAgility(){
        return agility;
    }
    public int getGold(){
        return gold;
    }

    public int getExperience(){
        return experience;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public Armor getArmor(){
        return armor;
    }

    public void setLevel(int level){
        this.level = level;
    }


    //basic level up attributes, there will be more for specific heroes
    public void levelUp(){
        if(experience > level * 10) {
            experience = experience - level*10;
            level++;
            HP = level * 100;
            totalMP = (int) (totalMP * 1.1);
        }
    }
    public int getLevel(){
        return level;
    }


    public String toString() {
        return "Name: " + getName() +
                ", Health: " + getHP() +
                ", Mana: " + getMP() +
                ", Level: " + getLevel() +
                ", Experience: " + getExperience() +
                ", Strength: " + getStrength() +
                ", Agility: " + getAgility() +
                ", Dexterity: " + getDexterity() +
                ", Starting Money: " + getGold() +
                ", Weapon: " + getWeapon().getName() +
                ", Weapon Damage: " + getWeapon().getDamage() +
                ", Armor: " + getArmor().getName() +
                ", Armor Defense: " + getArmor().getDamageReduction();
    }
}

