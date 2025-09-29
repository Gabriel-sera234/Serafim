import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe com o menu e o método main do programa.
 */
public class main {
    public static void main(String[] args) {
        AgendaApp agenda = new AgendaApp();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU AGENDA ---");
            System.out.println("1. Incluir nova reserva");
            System.out.println("2. Alterar reserva");
            System.out.println("3. Excluir reserva");
            System.out.println("4. Consultar reserva");
            System.out.println("5. Listar todas as reservas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data (dd/mm/aaaa): ");
                    String data = scanner.nextLine();
                    System.out.print("Hora (HH:mm): ");
                    String hora = scanner.nextLine();
                    agenda.adicionarReserva(new Reserva(nome, data, hora));
                    System.out.println("Reserva adicionada com sucesso!");
                    break;
                case 2:
                    System.out.print("Nome da reserva a alterar: ");
                    String nomeAlt = scanner.nextLine();
                    System.out.print("Nova data (dd/mm/aaaa): ");
                    String novaData = scanner.nextLine();
                    System.out.print("Nova hora (HH:mm): ");
                    String novaHora = scanner.nextLine();
                    if (agenda.alterarReserva(nomeAlt, novaData, novaHora)) {
                        System.out.println("Reserva alterada com sucesso!");
                    } else {
                        System.out.println("Reserva não encontrada!");
                    }
                    break;
                case 3:
                    System.out.print("Nome da reserva a excluir: ");
                    String nomeExc = scanner.nextLine();
                    if (agenda.excluirReserva(nomeExc)) {
                        System.out.println("Reserva excluída com sucesso!");
                    } else {
                        System.out.println("Reserva não encontrada!");
                    }
                    break;
                case 4:
                    System.out.println("Consultar por: 1-Nome 2-Data 3-Hora");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    ArrayList<Reserva> consultados = new ArrayList<>();
                    if (tipo == 1) {
                        System.out.print("Nome: ");
                        String n = scanner.nextLine();
                        consultados = agenda.consultarPorNome(n);
                    } else if (tipo == 2) {
                        System.out.print("Data (dd/mm/aaaa): ");
                        String d = scanner.nextLine();
                        consultados = agenda.consultarPorNome(d);
                    } else if (tipo == 3) {
                        System.out.print("Hora (HH:mm): ");
                        String h = scanner.nextLine();
                        consultados = agenda.consultarPorNome(h);
                    } else {
                        System.out.println("Opção de consulta inválida.");
                    }
                    if (consultados.isEmpty()) {
                        System.out.println("Nenhuma reserva encontrada.");
                    } else {
                        for (Reserva r : consultados) {
                            System.out.println(r);
                        }
                    }
                    break;
                case 5:
                    ArrayList<Reserva> todas = agenda.listarReservas();
                    if (todas.isEmpty()) {
                        System.out.println("Nenhuma reserva cadastrada.");
                    } else {
                        for (Reserva r : todas) {
                            System.out.println(r);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}