package weapon;
import warrior.*;
import armor.*;
import java.util.Random;

public abstract class Weapon {
    private Random dice = new Random();
    private int strikeChance = 65; // a roll of 65 or higher = a hit
    private int damageVariability = 25; // better than a magic number
    private int damage;
    private int weight;

    public Weapon() {

    }
    
    // getters
    public int getDamage() {
        return this.damage;
    }
    public int getWeight() {
        return this.weight;
    }

    // setters
    protected void setDamage(int damage) {
        this.damage = damage;
    }
    protected void setWeight(int weight) {
        this.weight = weight;
    }

    // strike - need warrior, armor and weapon details
    public int strike(Warrior warrior, Armor armor, int attackType, Armor eArmor) {
        int damageAmount = 0;
        int roll = dice.nextInt(100) + 1; // 1 - 100 percent
        
        // negative mods
        if(attackType == 2) { // heavy attack
            strikeChance += 10;
        }
        strikeChance += this.weight / 20;
        strikeChance += armor.getEncumbrance() / 20;

        // positive mods
        strikeChance -= warrior.getDexterity() / 10;

        strikeChance -= warrior.getLuck(); // small hit chance increase
        
        // check if its a hit
        if(roll >= strikeChance) {

            // lucky swing 
            if((strikeChance + 2 >= roll) && warrior.getLuck() > 0)
                System.out.println("Lucky Strike WOWWWW!!");

            // base weapon amount
            damageAmount = this.damage;

            // plus heavy attack bonus
            if(attackType == 2) {
                damageAmount += 20;
            }

            // plus the attackers strength
            damageAmount += warrior.getStrength() / 15;

            // minus the armor of the attacked as a reduction
            damageAmount -= eArmor.getProtection() / 4;

            // adjust damage within a range
            damageAmount = dice.nextInt(damageAmount - damageVariability, damageAmount);
        } // if

        return damageAmount;
    } // strike()
} // class
