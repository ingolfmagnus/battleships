package no.uib.ii.gabriel;

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
}
