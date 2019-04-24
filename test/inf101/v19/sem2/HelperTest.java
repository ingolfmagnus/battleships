package inf101.v19.sem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    void readInputLine() {
        System.out.println("Enter hello: ");
        assertEquals("Hello", Helper.readInputLine());
    }
}