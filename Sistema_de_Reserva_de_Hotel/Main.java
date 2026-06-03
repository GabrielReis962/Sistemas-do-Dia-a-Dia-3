package Sistema_de_Reserva_de_Hotel;
import java.util.Scanner;
public class Main {



        public static String campoObrigatorio(
                Scanner sc,
                String mensagem) {

            String valor;

            do {
                System.out.print(mensagem);
                valor = sc.nextLine().trim();

                if (valor.isEmpty()) {
                    System.out.println("Campo obrigatório.");
                }

            } while (valor.isEmpty());

            return valor;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.println("===== RESERVA DE HOTEL =====");

            String cidade =
                    campoObrigatorio(sc,
                            "Cidade: ");

            String checkIn =
                    campoObrigatorio(sc,
                            "Data Check-in: ");

            String checkOut =
                    campoObrigatorio(sc,
                            "Data Check-out: ");

            int hospedes;

            do {

                System.out.print(
                        "Quantidade de hóspedes: ");

                while (!sc.hasNextInt()) {
                    System.out.println(
                            "Digite apenas números.");
                    sc.next();
                }

                hospedes = sc.nextInt();

                if (hospedes <= 0) {
                    System.out.println(
                            "Quantidade inválida.");
                }

            } while (hospedes <= 0);

            sc.nextLine();

            Hospede hospede =
                    new Hospede(
                            cidade,
                            checkIn,
                            checkOut,
                            hospedes);

            System.out.println(
                    "\nPesquisando quartos disponíveis...");

            boolean quartosDisponiveis = true;

            if (!quartosDisponiveis) {

                System.out.println(
                        "Nenhum quarto disponível.");

                sc.close();
                return;
            }

            System.out.println("\nQuartos disponíveis:");
            System.out.println("1 - Standard (R$200/dia)");
            System.out.println("2 - Luxo (R$350/dia)");

            int opcao;

            do {

                System.out.print(
                        "Escolha o quarto: ");

                while (!sc.hasNextInt()) {
                    System.out.println(
                            "Digite apenas números.");
                    sc.next();
                }

                opcao = sc.nextInt();

            } while (opcao < 1 || opcao > 2);

            String quarto;

            if (opcao == 1) {
                quarto = "Standard";
            } else {
                quarto = "Luxo";
            }

            int diarias;

            do {

                System.out.print(
                        "Quantidade de diárias: ");

                while (!sc.hasNextInt()) {
                    System.out.println(
                            "Digite apenas números.");
                    sc.next();
                }

                diarias = sc.nextInt();

                if (diarias <= 0) {
                    System.out.println(
                            "Quantidade inválida.");
                }

            } while (diarias <= 0);

            Reserva reserva =
                    new Reserva(quarto, diarias);

            System.out.println(
                    "\n===== RESUMO =====");

            System.out.println(
                    "Cidade: "
                            + hospede.getCidade());

            System.out.println(
                    "Quarto: "
                            + reserva.getQuarto());

            System.out.println(
                    "Diárias: "
                            + reserva.getDiarias());

            if (diarias > 5) {
                System.out.println(
                        "Desconto de 10% aplicado.");
            }

            System.out.println(
                    "Valor Total: R$"
                            + reserva.getValorTotal());

            System.out.println(
                    "\nFormas de Pagamento");

            System.out.println("1 - PIX");
            System.out.println("2 - Cartão");
            System.out.println("3 - Dinheiro");

            int pagamento;

            do {

                System.out.print(
                        "Escolha: ");

                while (!sc.hasNextInt()) {
                    System.out.println(
                            "Digite apenas números.");
                    sc.next();
                }

                pagamento = sc.nextInt();

            } while (pagamento < 1
                    || pagamento > 3);

            sc.nextLine();

            String aprovado;

            do {

                System.out.print(
                        "Pagamento aprovado? (S/N): ");

                aprovado =
                        sc.nextLine().trim();

                if (!aprovado.equalsIgnoreCase("S")
                        && !aprovado.equalsIgnoreCase("N")) {

                    System.out.println(
                            "Digite apenas S ou N.");
                }

            } while (!aprovado.equalsIgnoreCase("S")
                    && !aprovado.equalsIgnoreCase("N"));

            if (aprovado.equalsIgnoreCase("N")) {

                System.out.println(
                        "\nPagamento recusado.");

                sc.close();
                return;
            }

            System.out.println(
                    "\nReserva Nº "
                            + reserva.getNumeroReserva());

            System.out.println(
                    "Hospedagem registrada.");

            System.out.println(
                    "Confirmação enviada por e-mail.");

            System.out.println(
                    "Reserva confirmada.");

            sc.close();
        }
    }

