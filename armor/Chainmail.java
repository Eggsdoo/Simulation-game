package armor;

public class Chainmail extends Armor {
    private int protection = 200;
    private int encumbrance = 50;

    public Chainmail() {
        super();
        super.setProtection(protection);
        super.setEncumbrance(encumbrance);
    }
}
