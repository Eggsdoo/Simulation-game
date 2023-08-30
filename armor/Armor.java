package armor;

public abstract class Armor {
    private int protection;
    private int encumbrance;

    public Armor() {

    }

    // getters
    public int getProtection() {
        return this.protection;
    }
    public int getEncumbrance() {
        return this.encumbrance;
    }

    // setters
    protected void setProtection(int protection) {
        this.protection = protection;
    }
    protected void setEncumbrance(int encumbrance) {
        this.encumbrance = encumbrance;
    }

}
