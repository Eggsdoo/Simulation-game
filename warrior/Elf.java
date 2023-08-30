package warrior;

public class Elf extends Warrior {
    private int minHealth = 200;
    private int maxHealth = 300;
    private int minStrength = 75;
    private int maxStrength = 125;
    private int minDexterity = 175;
    private int maxDexterity = 225;
    private int minDexBonus = 100;
    private int maxDexBonus = 200;
    
    public Elf() {
        super(); // must be the FIRST line
        // set the Elf health between the min and max
        super.setHealth(randNum.nextInt(minHealth, maxHealth));
        super.setStrength(randNum.nextInt(minStrength, maxStrength));
        super.setDexterity(randNum.nextInt(minDexterity, maxDexterity));
    } // Elf()

    @Override
    public void specialAbility() {
        int amount = 0;
        amount = super.randNum.nextInt(minDexBonus, maxDexBonus); // 100 - 200
        this.dexterity += amount;
        this.buffAmount = amount;
        System.out.printf("You have extra disco power!!! your dexterity is %d\n", this.dexterity);
    } // specialAbility()

    @Override
    public void removeBuff() {
        this.dexterity -= buffAmount;
        buffAmount = 0;
        System.out.printf("You are tired and your dexterity is once again %d points\n", this.dexterity);
    } // removeBuff()
} // class
