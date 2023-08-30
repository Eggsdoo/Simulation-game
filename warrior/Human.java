package warrior;

public class Human extends Warrior {
    private int minHealth = 250;
    private int maxHealth = 350;
    private int minStrength = 100;
    private int maxStrength = 150;
    private int minDexterity = 100;
    private int maxDexterity = 150;
    private int minHealBonus = 50;
    private int maxHealBonus = 75;
    
    public Human() {
        super(); // must be the FIRST line
        // set the Human health between the min and max
        super.setHealth(randNum.nextInt(minHealth, maxHealth));
        super.setStrength(randNum.nextInt(minStrength, maxStrength));
        super.setDexterity(randNum.nextInt(minDexterity, maxDexterity));
    } // Human()

    @Override
    public void specialAbility() {
        int amount = super.randNum.nextInt(minHealBonus, maxHealBonus); // 50 - 75
        this.health += amount;
        System.out.printf("You have healed for %d points\n", amount);
        System.out.printf("You now have %d points\n", this.health);
    } // specialAbility()

    @Override
    public void removeBuff() {
        
    } // remove buff
} // class
