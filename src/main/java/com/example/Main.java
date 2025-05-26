package com.example;

import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();

        int fila, columna;
        boolean posValida, correcto;

        while (!ttt.finPartida()) {
            do {
                ttt.mostrarTurnoActual();
                ttt.mostrarTablero();

                correcto = false;
                fila = pedirInteger("Dame la fila");
                columna = pedirInteger("Dame la columna");

                posValida = ttt.validarPosicion(fila, columna);

                if (posValida) {
                    if (!ttt.hayValorPosicion(fila, columna)) {
                        correcto = true;
                    } else {
                        System.out.println("Ya hay una marca en esa posicion");
                    }
                } else {
                    System.out.println("La posicion no es valida");
                }
            } while (!correcto);

            ttt.insertarEn(fila, columna);
            ttt.cambiaTurno();
        }

        ttt.mostrarTablero();
        ttt.mostrarGanador();
    }

    public static int pedirInteger(String mensaje) {
        System.out.println(mensaje);
        return teclado.nextInt();
    }
}