package com.example;

public class TicTacToe {

    //Reprentaciones de los jugadores y del simbolo vacio
    private final char J1 = 'X';
    private final char J2 = 'O';
    private final char VACIO = '-';

    //turno actual
    //true = J1, false = J2
    private boolean turno;

    //tablero donde vamos a jugar
    private char tablero[][];

    public TicTacToe() {
        this.turno = true;
        this.tablero = new char[3][3];
        this.inicializarTablero();
    }

    /**
     * Inicializa el tablero con el simbolo VACIO
     */
    private void inicializarTablero() {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = VACIO;
            }
        }

    }

    /**
     * Indica si es el fin de la partida, acaba cuando hay un ganador o el
     * tablero esta lleno
     *
     * @return fin de partida
     */
    public boolean finPartida() {

        if (tableroLleno()
                || coincidenciaLinea() != VACIO
                || coincidenciaColumna() != VACIO) //QUITAR EL PARENTESIS Y QUITAR EL COMENTARIO
                //|| coincidenciaDiagonal() != VACIO) 
                {
            return true;
        }

        return false;
    }

    /**
     * Indica si el tablero esta llena cuando el simbolo por defecto aparezca,
     * no esta llena
     *
     * @return talero vacio o no
     */
    public boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == VACIO) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Indica si hay un ganador en una linea
     *
     * @return Simbolo del ganador, VACIO sino hay ganador
     */
    private char coincidenciaLinea() {

        char simbolo;
        boolean coincidencia;

        for (int i = 0; i < tablero.length; i++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la fila
            simbolo = tablero[i][0];
            if (simbolo != VACIO) {
                for (int j = 1; j < tablero[0].length; j++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != tablero[i][j]) {
                        coincidencia = false;
                    }
                }

                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }

            }

        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return VACIO;

    }

    /**
     * Indica si hay un ganador en una columna
     *
     * @return Simbolo del ganador, VACIO sino hay ganador
     */
    private char coincidenciaColumna() {

        char simbolo;
        boolean coincidencia;

        for (int j = 0; j < tablero.length; j++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la columna
            simbolo = tablero[0][j];
            if (simbolo != VACIO) {
                for (int i = 1; i < tablero[0].length; i++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != tablero[i][j]) {
                        coincidencia = false;
                    }
                }

                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }

            }

        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return VACIO;

    }

    /** AÑADIR-------------------------------------------------------------------------------------
     * Comprueba las diagonales*/

}