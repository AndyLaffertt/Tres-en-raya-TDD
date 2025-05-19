package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class AppTest {
    //Requermiento 1
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
    //Solución Alternativa de la IA
    @Test(expected = IllegalArgumentException.class)
    public void testFilaNegativa_lanzaExcepcion() {
        TicTacToe juego = new TicTacToe();
        juego.insertarEn(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFilaFueraDeLimite_lanzaExcepcion() {
        TicTacToe juego = new TicTacToe();
        juego.insertarEn(3, 1);
    }
//Segunda prueba
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
    //Solución alternativa
    @Test(expected = IllegalArgumentException.class)
    public void testColumnaNegativa_lanzaExcepcion() {
        TicTacToe juego = new TicTacToe();
        juego.insertarEn(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testColumnaFueraDeLimite_lanzaExcepcion() {
        TicTacToe juego = new TicTacToe();
        juego.insertarEn(1, 3);
    }
//tercera prueba
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
    //Solución alternativa con IA
    @Test(expected = IllegalStateException.class)
    public void testPosicionOcupada_lanzaExcepcion() {
        TicTacToe juego = new TicTacToe();
        juego.insertarEn(0, 0); // Primer jugador
        juego.insertarEn(0, 0); // Mismo lugar, lanza excepción
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

    //mi prueba
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
//test propuesto por ia
@Test
public void testNoGanaConLineaIncompletaConHuecos() {
    TicTacToe juego = new TicTacToe();

    // Jugador X tiene piezas en fila 0 pero con huecos
    juego.insertarEn(0, 0); // X
    juego.insertarEn(0, 1); // O
    juego.insertarEn(0, 2); // X

    // No hay línea completa
    assertEquals('-', juego.coincidenciaLinea());
}

//mi prueba

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

//prueba por ia

@Test
public void testGanaJugadorLineaVerticalColumna1() {
    TicTacToe juego = new TicTacToe();

    // Jugador O ocupa toda la columna 1 (índice 0)
    juego.insertarEn(0, 1); // X
    juego.insertarEn(0, 0); // O
    juego.insertarEn(2, 2); // X
    juego.insertarEn(1, 0); // O
    juego.insertarEn(1, 2); // X
    juego.insertarEn(2, 0); // O

    assertEquals('O', juego.coincidenciaColumna());
}

//mi prueba

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

//prueba por ia
@Test
public void testVictoriaDiagonalIzquierdaDerecha() {
    TicTacToe juego = new TicTacToe();

    // X ocupa diagonal principal
    juego.insertarEn(0, 0); // X
    juego.insertarEn(0, 1); // O
    juego.insertarEn(1, 1); // X
    juego.insertarEn(1, 0); // O
    juego.insertarEn(2, 2); // X

    assertEquals('X', juego.coincidenciaDiagonal());
}

//mi prueba

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

//prueba por ia

@Test
public void testLineaInterrumpidaNoGana() {
    TicTacToe juego = new TicTacToe();

    // Jugador X intenta línea horizontal fila 1, pero O bloquea en medio
    juego.insertarEn(1, 0); // X
    juego.insertarEn(1, 1); // O
    juego.insertarEn(1, 2); // X

    assertEquals('-', juego.coincidenciaLinea());
}


}
