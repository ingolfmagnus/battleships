package no.uib.ii.gabriel;

public class Ship extends BoardPiece {

    private final String name;

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    private int durability;

    public Ship(String aSymbol, String aName, int aSize) {
        super(aSymbol, aSize);
        name = aName;
        durability = aSize;
    }

    public void hit() {
        durability--;
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public void resetDurability() {
        durability = size;
    }

}
