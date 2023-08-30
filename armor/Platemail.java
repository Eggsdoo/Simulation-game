package armor;

public class Platemail extends Armor {
    private int protection = 350;
    private int encumbrance = 100;

    public Platemail() {
        super();
        super.setProtection(protection);
        super.setEncumbrance(encumbrance);
    }
}
