package warrior;

import java.util.Random;

public abstract class Warrior {
    protected Random randNum = new Random();
    protected int health;
    protected int strength;
    protected int dexterity;
    protected int buffAmount = 0;
    private int luck;
    private int maxLuck = 3;

    protected String name;

    // constructor
    public Warrior () {
        this.luck = randNum.nextInt(maxLuck); // 0 1 2
    }

    // getter
    public int getHealth() {
        return this.health;
    }
    public int getStrength() {
        return this.strength;
    }
    public int getDexterity() {
        return this.dexterity;
    }
    public int getLuck() {
        return this.luck;
    }
    public String getName() {
        return this.name;
    }

    // setter
    public void setHealth(int health) {
        this.health = health;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public void setName(String name) {
        this.name = name;
    }   
    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void takeDamage(int damageAmount) {
        this.health -= damageAmount;
    }

    // polymorphic method
    public abstract void specialAbility(); 
    public abstract void removeBuff();

}

// access modifiers:
// public: available anywhere
// private: class access only
// protected: public in the package or family, private outside
// abstract: for parents and for templating - used with/for inheritance
// abstract: with methods for polymorphism