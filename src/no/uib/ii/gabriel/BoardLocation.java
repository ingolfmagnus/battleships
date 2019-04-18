package no.uib.ii.gabriel;

public class BoardLocation {

    private int x;
    private int y;

    public BoardLocation(int anX, int anY) throws IllegalArgumentException {
        if (anX < 1 || anX > 10 || anY < 1 || anY > 10 )
            throw new IllegalArgumentException();
        x = anX;
        y = anY;
    }

    public BoardLocation(String alphaNum) throws IllegalArgumentException {
        if (alphaNum.matches("[a-jA-J][0-9]+")) {
            x = alphaNum.toUpperCase().charAt(0) - 'A' + 1;
            try {
                y = Integer.parseInt(alphaNum.substring(1));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Illegal number format");
            }
        }
        if (x < 1 || x > 10 || y < 1 || y > 10 )
            throw new IllegalArgumentException();
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
