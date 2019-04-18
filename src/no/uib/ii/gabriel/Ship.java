package no.uib.ii.gabriel;

public class Ship extends BoardPiece {

    private final String name;
    private int lives;

    public Ship(String aSymbol, String aName, int aSize) {
        super(aSymbol, aSize);
        name = aName;
        lives = aSize;
    }

    public void hit() {
        lives--;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public void resetLives() {
        lives = size;
    }

}
