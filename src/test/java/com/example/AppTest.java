package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

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
        System.out.println("Excepción capturada correctamente para columna -1");}

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



//requerimiento 3

@Test
public void testNoHayGanadorCuandoNoSeCumpleCondicion() {
    TicTacToe juego = new TicTacToe();

    juego.insertarEn(0, 0); 
    juego.cambiaTurno();
    juego.insertarEn(1, 1); 
    juego.cambiaTurno();
    juego.insertarEn(2, 0); 
    juego.cambiaTurno();
    juego.insertarEn(0, 2);

    char ganadorLinea = juego.coincidenciaLinea();
    char ganadorColumna = juego.coincidenciaColumna();
    char ganadorDiagonal = juego.coincidenciaDiagonal();

    assertEquals('-', ganadorLinea);
    assertEquals('-', ganadorColumna);
    assertEquals('-', ganadorDiagonal);
}

@Test
public void testGanaJugadorConLineaHorizontal() {
    TicTacToe juego = new TicTacToe();

    juego.insertarEn(0, 0); 
    juego.cambiaTurno();
    juego.insertarEn(1, 0); 
    juego.cambiaTurno();
    juego.insertarEn(0, 1); 
    juego.cambiaTurno();
    juego.insertarEn(1, 1); 
    juego.cambiaTurno();
    juego.insertarEn(0, 2); 

    assertEquals('X', juego.coincidenciaLinea());
}

@Test
public void testGanaJugadorConLineaVertical() {
    TicTacToe juego = new TicTacToe();

    juego.insertarEn(0, 1); 
    juego.cambiaTurno();
    juego.insertarEn(0, 0); 
    juego.cambiaTurno();
    juego.insertarEn(1, 2); 
    juego.cambiaTurno();
    juego.insertarEn(1, 0); 
    juego.cambiaTurno();
    juego.insertarEn(2, 2); 
    juego.cambiaTurno();
    juego.insertarEn(2, 0); 

    assertEquals('O', juego.coincidenciaColumna());
}

@Test
public void testGanaJugadorConLineaDiagonal() {
    TicTacToe juego = new TicTacToe();

    juego.insertarEn(0, 0); 
    juego.cambiaTurno();
    juego.insertarEn(0, 1);
    juego.cambiaTurno();
    juego.insertarEn(1, 1); 
    juego.cambiaTurno();
    juego.insertarEn(0, 2); 
    juego.cambiaTurno();
    juego.insertarEn(2, 2); 

    assertEquals('X', juego.coincidenciaDiagonal());

}











}
