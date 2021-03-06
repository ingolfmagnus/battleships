package inf101.v19.sem2;

public class BoardLocation {

    private int x;
    private int y;
    private String alphaNum;

    public BoardLocation(int anX, int anY) throws IllegalArgumentException {
        if (anX < 0 || anX > 9 || anY < 0 || anY > 9)
            throw new IllegalArgumentException();
        x = anX;
        y = anY;
        alphaNum = "" + "ABCDEFGHIJ".charAt(y) + (x+1);
    }

    @Override
    public String toString() {
        return "BoardLocation{" +
                "alphaNum='" + alphaNum + '\'' +
                '}';
    }

    public BoardLocation(String alphaNum) throws IllegalArgumentException {
        this.alphaNum = alphaNum;
        if (alphaNum.matches("[a-jA-J][0-9]+")) {
            y = alphaNum.toUpperCase().charAt(0) - 'A';
            try {
                x = Integer.parseInt(alphaNum.substring(1))-1;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Illegal number format");
            }
        }
        else
            throw new IllegalArgumentException();
        if (x < 0 || x > 9 || y < 0 || y > 9 )
            throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardLocation that = (BoardLocation) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public String getAlphaNum() { return alphaNum; }
}
