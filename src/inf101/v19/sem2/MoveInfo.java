package inf101.v19.sem2;

public class MoveInfo {
    private BoardLocation location;
    private Ship hitShip;
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Ship getHitShip() {
        return hitShip;
    }

    public void setHitShip(BoardPiece hitShip) {
        if (hitShip instanceof Ship) {
            this.hitShip = (Ship)hitShip;
        }
        else
            this.hitShip = null;
    }

    public BoardLocation getLocation() {
        return location;
    }

    public void setLocation(BoardLocation move) {
        this.location = move;
    }
}
