package armor;

public class Leather extends Armor {
    private int protection = 100;
    private int encumbrance = 10;

    public Leather() {
        super();
        super.setProtection(protection);
        super.setEncumbrance(encumbrance);
    }
}
