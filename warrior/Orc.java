package warrior;

public class Orc extends Warrior {
    private int minHealth = 350;
    private int maxHealth = 450;
    private int minStrength = 200;
    private int maxStrength = 250;
    private int minDexterity = 50;
    private int maxDexterity = 75;
    private int minStrengthBonus = 75;
    private int maxStrengthBonus = 150;
    
    public Orc() {
        super(); // must be the FIRST line
        // set the Orc health between the min and max
        super.setHealth(randNum.nextInt(minHealth, maxHealth));
        super.setStrength(randNum.nextInt(minStrength, maxStrength));
        super.setDexterity(randNum.nextInt(minDexterity, maxDexterity));
    } // Orc()

    @Override
    public void specialAbility() {
        int amount = 0;
        amount = super.randNum.nextInt(minStrengthBonus, maxStrengthBonus); // 100 - 200??
        this.strength += amount;
        this.buffAmount = amount;
        System.out.printf("You are so angry your strength is now %d\n", this.strength);
    } // specialAbility()

    @Override
    public void removeBuff() {
        this.strength -= buffAmount;
        buffAmount = 0;
        System.out.printf("You are tired, your normal strength is %d points\n", this.strength);
    } // removeBuff()
} // class
