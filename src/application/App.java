package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
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

            if (opc == 'a') { // Cria uma nova reserva
                System.out.println("\nSalas disponíveis:");

                // Exibe as salas disponíveis para reserva
                for (Sala sala : listaSalas) {
                    if (!sala.isStatus()) {
                        System.out.println(sala.getNome() + " -> " + sala.getCapacidade() + " pessoas");
                    }
                }

                System.out.print("\nQual sala deseja reservar?: ");
                String salaEscolhida = sc.nextLine();
                Sala salaReservada = null;

                // Resgata o objeto referente a sala escolhida
                for (Sala sala : listaSalas) {
                    if (sala.getNome().equals(salaEscolhida)) {
                        salaReservada = sala;
                    }
                }

                System.out.print("Qual é o seu nome: ");
                String nome = sc.nextLine();

                System.out.print("Inicio da reserva (dd/MM/aaaa HH:mm): ");
                LocalDateTime inicioReserva = LocalDateTime.parse(sc.nextLine(), formatoData);

                System.out.print("Fim da resesrva (dd/MM/aaaa HH:mm): ");
                LocalDateTime fimReserva = LocalDateTime.parse(sc.nextLine(), formatoData);

                // Faz a reserva e atualiza o status da sala
                listaReservas.add(new Reserva(salaReservada, inicioReserva, fimReserva, new Usuario(nome)));
                salaReservada.setStatus(true);
            }
            else if (opc == 'b') { // Exibe as reservas realizadas
                if (listaReservas.isEmpty()) {
                    System.out.println("Não há reservas!");
                } else {
                    for (Reserva reserva : listaReservas) {
                        System.out.println(reserva);
                    }
                }
            }
            else if (opc == 'c') {
                System.out.println("Qual reserva deseja cancelar? (id): ");
                int id = sc.nextInt();

                for (int i = 0; i < listaReservas.size(); i++) {
                    // Remove a reserva escolhida e altera o status da sala
                    if (listaReservas.get(i).getId() == id) {
                        Reserva reservaCancelada = listaReservas.remove(i);
                        reservaCancelada.getSalaReservada().setStatus(false);
                        System.out.println("Reserva cancelada!");
                        break;
                    }
                }

                sc.nextLine();
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
