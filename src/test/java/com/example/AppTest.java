package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testPiezaFueraDelEjeX_lanzaExcepcion() {
        TicTacToe juego = new TicTacToe();
        try {
            juego.insertarEn(-1, 1);
            fail("Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // OK
        }

        try {
            juego.insertarEn(3, 1);
            fail("Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }
}
