package weapon;

public class Sword extends Weapon {
    private int damage = 150;
    private int weight = 70;
    
    public Sword() {
        super();
        super.setDamage(damage);
        super.setWeight(weight);
    }
}
