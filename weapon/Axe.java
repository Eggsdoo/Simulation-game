package weapon;

public class Axe extends Weapon {
    private int damage = 300;
    private int weight = 200;
    
    public Axe() {
        super();
        super.setDamage(damage);
        super.setWeight(weight);
    }
}
