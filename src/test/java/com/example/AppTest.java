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
    // El primer turno siempre debe ser jugado por ‘X’
    @Test
    public void testPrimerTurnoDebeSerX() {
        TicTacToe juego = new TicTacToe();
        assertEquals('X', juego.obtenerTurnoActual());
    }

    // SOLUCION/TEST PROPUESTA CON IA para el primer turno debe ser jugado por ‘X’
    @Test
    public void testObtenerTurnoPorConteo_PrimerTurnoX() {
        TicTacToe juego = new TicTacToe();
        assertEquals(
                "En un tablero recién inicializado debe iniciar X",
                'X',
                juego.obtenerTurnoPorConteo());
    }

    /**
     * Si el ultimo turno fue jugado por ‘X', entonces el siguiente turno es para
     * ‘O’
     */
    @Test
    public void testTurnoAlternaDeXAO() {
        TicTacToe juego = new TicTacToe();
        juego.insertarEn(0, 0); // Jugador X mueve
        assertEquals("Después del turno de X, el siguiente debe ser O", 'O', juego.obtenerTurnoActual());
    }

    // SOLUCION/TEST PROPUESTA CON IA PARA Si el ultimo turno fue jugado por ‘X',
    // entonces el siguiente turno es para ‘O’
    // LA IA DIO EL TEST TAMBIEN PARA Si el ultimo turno fue jugado por ‘O’,
    // entonces el siguiente turno es para ‘X’
    @Test
    public void testCalcularTurnoPorEstado() {
        TicTacToe juego = new TicTacToe();

        // Tablero vacío → debe jugar X
        assertEquals('X', juego.calcularTurnoPorEstado());

        // Colocamos una X
        juego.insertarEn(0, 0);
        assertEquals('O', juego.calcularTurnoPorEstado());

        // Colocamos una O
        juego.insertarEn(1, 1);
        assertEquals('X', juego.calcularTurnoPorEstado());
    }

    // Si el ultimo turno fue jugado por ‘O’, entonces el siguiente turno es para
    // ‘X’
    @Test
    public void testTurnoAlternaDeOA_X() {
        TicTacToe juego = new TicTacToe();
        juego.insertarEn(0, 0); // Juega X
        juego.insertarEn(1, 1); // Juega O
        // se espera 'X'
        assertEquals("Después del turno de O, debe tocar X", 'X', juego.siguienteTurno());
    }



    //requerimiento 3

    //se cambio 3 metods de privado a publico
@Test
public void testNoHayGanadorCuandoNoSeCumpleCondicion() {
    TicTacToe juego = new TicTacToe();

    juego.insertarEn(0, 0); 
    juego.insertarEn(1, 1); 
    juego.insertarEn(2, 0); 
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
    juego.insertarEn(1, 0); 
    juego.insertarEn(0, 1); 
    juego.insertarEn(1, 1); 
    juego.insertarEn(0, 2); 

    assertEquals('X', juego.coincidenciaLinea());
}

@Test
public void testGanaJugadorConLineaVertical() {
    TicTacToe juego = new TicTacToe();

    juego.insertarEn(0, 1); 
    juego.insertarEn(0, 0); 
    juego.insertarEn(1, 2); 
    juego.insertarEn(1, 0); 
    juego.insertarEn(2, 2); 
    juego.insertarEn(2, 0); 

    assertEquals('O', juego.coincidenciaColumna());
}

@Test
public void testGanaJugadorConLineaDiagonal() {
    TicTacToe juego = new TicTacToe();

    juego.insertarEn(0, 0); 
    juego.insertarEn(0, 1);
    juego.insertarEn(1, 1); 
    juego.insertarEn(0, 2); 
    juego.insertarEn(2, 2); 

    assertEquals('X', juego.coincidenciaDiagonal());
}


}
