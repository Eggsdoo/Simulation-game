package weapon;

public class Dagger extends Weapon {
    private int damage = 50;
    private int weight = 20;
    
    public Dagger() {
        super();
        super.setDamage(damage);
        super.setWeight(weight);
    }
}
