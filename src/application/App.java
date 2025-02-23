package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import entities.Reserva;
import entities.Sala;
import entities.Usuario;

public class App {
    private static final int NUMERO_DE_SALAS = 10;
    private static final int CAPACIDADE_MAXIMA = 40;
    private static final int CAPACIDADE_MINIMA = 10;
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        List<Reserva> listaReservas = new ArrayList<>();
        Sala[] listaSalas = new Sala[NUMERO_DE_SALAS];
        boolean laco = true;

        // Gera lista com 10 salas
        for (int i = 0; i < listaSalas.length; i++) {
            listaSalas[i] = new Sala(
                "Sala0" + i,
                random.nextInt((CAPACIDADE_MAXIMA - CAPACIDADE_MINIMA) + 1) + CAPACIDADE_MINIMA
            );
        }

        while (laco) {
            System.out.print(menu());
            char opc = sc.nextLine().charAt(0);

            System.out.println(opc);

            if (opc == 'a') {
                
            }
            else if (opc == 'e') {
                laco = false;
            }
        }

        sc.close();
    }

    public static String menu() {
        return "\nBem vindo ao Sistema de reservas\n\n"
            + "a) Criar reserva\n"
            + "b) Listar reservas\n"
            + "c) Cancelar reservas\n"
            + "e) sair\n-> ";
    }
}
