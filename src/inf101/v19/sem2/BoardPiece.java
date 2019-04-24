package inf101.v19.sem2;

public class BoardPiece {
    protected final int size;
    private final String symbol;

    public BoardPiece(String aSymbol, int aSize) {
        symbol = aSymbol;
        size = aSize;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "BoardPiece{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
