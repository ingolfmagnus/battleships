package inf101.v19.sem2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardLocationTest {

    @Test
    void constructFromXY() {
        BoardLocation loc = new BoardLocation(3,3);
        Assertions.assertEquals("D4", loc.getAlphaNum());

        Assertions.assertThrows(IllegalArgumentException.class, ()->new BoardLocation(0,10));
        Assertions.assertThrows(IllegalArgumentException.class, ()->new BoardLocation(10,0));
    }

    @Test
    void constructFromAlphaNum() {
        BoardLocation loc = new BoardLocation("A1");
        Assertions.assertEquals(0, loc.getX());
        Assertions.assertEquals(0, loc.getY());

        Assertions.assertThrows(IllegalArgumentException.class, ()->new BoardLocation("P3"));
        Assertions.assertThrows(IllegalArgumentException.class, ()->new BoardLocation(""));
    }

    @Test
    void equality() {
        BoardLocation loc = new BoardLocation("D4");
        BoardLocation loc2 = new BoardLocation(3, 3);
        Assertions.assertEquals(loc, loc2);
    }

}