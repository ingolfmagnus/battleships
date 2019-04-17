package no.uib.ii.gabriel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    void readInputLine() {
        System.out.println("Enter hello: ");
        Assertions.assertEquals("Hello", Helper.readInputLine());
    }
}