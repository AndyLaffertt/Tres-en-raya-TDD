package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testPiezaFueraDelEjeX_lanzaExcepcion() {
        TicTacToe juego = new TicTacToe();
        try {
            juego.insertarEn(-1, 1);
            fail("Se esperaba IllegalArgumentException por fila incorrecta");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente fila -1");
        }

        try {
            juego.insertarEn(3, 1);
            fail("Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente fila 3");
        }
    }

    @Test
    public void testPiezaFueraDelEjeY_lanzaExcepcion() {
        TicTacToe juego = new TicTacToe();

        try {
            juego.insertarEn(1, -1);
            fail("Se esperaba IllegalArgumentException para columna -1");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente para columna -1");
        }

        try {
            juego.insertarEn(1, 3);
            fail("Se esperaba IllegalArgumentException para columna 3");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente para columna 3");
        }
    }

    @Test
    public void testPiezaEnLugarOcupado_lanzaExcepcion() {
        TicTacToe juego = new TicTacToe();
        juego.insertarEn(0, 0); // Jugador X

        try {
            juego.insertarEn(0, 0); // Mismo lugar
            fail("Se esperaba IllegalStateException por posición ocupada");
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada correctamente para posición ocupada");
        }
    }

    // REQUERIMEINTO 2
    @Test
    public void testPrimerTurnoDebeSerX() {
        TicTacToe juego = new TicTacToe();
        assertEquals('X', juego.obtenerTurnoActual());
    }

}
