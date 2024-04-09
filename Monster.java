//File Name: Monster.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class representing the stats of any type of monster
public abstract class Monster {
    private String name;
    private int level;
    private int HP;
    private int baseDamage;
    private int defenseValue;
    private int dodgeAbility;

    public Monster(){
    }

    public void setName(String ourName){
        name = ourName;
    }
    public void setHP(int ourHP){
        HP = ourHP;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setBaseDamage(int ourDamage){
        baseDamage = ourDamage;
    }

    public void setDefenseValue(int ourDefenseValue){
        defenseValue = ourDefenseValue;
    }

    public void setDodgeAbility(int ourDodgeAbility){
        dodgeAbility = ourDodgeAbility;
    }

    public String getName() {
        return name;
    }

    public int getLevel(){
        return level;
    }

    public int getHP(){
        return HP;
    }

    public int getBaseDamage(){
        return baseDamage;
    }

    public int getDefenseValue(){
        return defenseValue;
    }

    public int getDodgeAbility(){
        return dodgeAbility;
    }

    public String toString() {
        return "Name: " + getName() +
                ", Level: " + getLevel() +
                ", Health: " + getHP() +
                ", Base Damage: " + getBaseDamage() +
                ", Defense: " + getDefenseValue() +
                ", Dodge Ability: " + getDodgeAbility();
    }
}
