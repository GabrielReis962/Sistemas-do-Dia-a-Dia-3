package Sistema_de_Delivery_de_Restaurante;
import java.util.Scanner;
import java.util.Scanner;



import java.util.Scanner;

 class Main {



         public static String lerCampoObrigatorio(
                 Scanner sc,
                 String mensagem) {

             String valor;

             do {
                 System.out.print(mensagem);
                 valor = sc.nextLine().trim();

                 if (valor.isEmpty()) {
                     System.out.println("Campo obrigatório. Tente novamente.");
                 }

             } while (valor.isEmpty());

             return valor;
         }

         public static void main(String[] args) {

             Scanner sc = new Scanner(System.in);

             System.out.println("===== CADASTRO =====");

             String emailCadastro =
                     lerCampoObrigatorio(
                             sc,
                             "Digite seu e-mail: ");

             String senhaCadastro =
                     lerCampoObrigatorio(
                             sc,
                             "Digite sua senha: ");

             Cliente cliente =
                     new Cliente(
                             emailCadastro,
                             senhaCadastro);

             System.out.println("\n===== LOGIN =====");

             String emailLogin =
                     lerCampoObrigatorio(
                             sc,
                             "E-mail: ");

             String senhaLogin =
                     lerCampoObrigatorio(
                             sc,
                             "Senha: ");

             if (!emailLogin.equals(cliente.getEmail())
                     || !senhaLogin.equals(cliente.getSenha())) {

                 System.out.println(
                         "\nUsuário ou senha inválidos.");

                 sc.close();
                 return;
             }

             System.out.println(
                     "\nLogin realizado com sucesso!");

             double total = 0;
             int opcao;

             System.out.println("\n===== CARDÁPIO =====");
             System.out.println("1 - Pizza ............ R$40");
             System.out.println("2 - Hambúrguer ....... R$25");
             System.out.println("3 - Refrigerante ..... R$8");

             do {

                 System.out.print(
                         "\nEscolha um produto (0 para finalizar): ");

                 while (!sc.hasNextInt()) {
                     System.out.println("Digite apenas números.");
                     sc.next();
                 }

                 opcao = sc.nextInt();

                 switch (opcao) {

                     case 1:
                         total += 40;
                         System.out.println("Pizza adicionada.");
                         break;

                     case 2:
                         total += 25;
                         System.out.println("Hambúrguer adicionado.");
                         break;

                     case 3:
                         total += 8;
                         System.out.println("Refrigerante adicionado.");
                         break;

                     case 0:

                         if (total == 0) {
                             System.out.println(
                                     "Você deve escolher pelo menos um produto.");
                             opcao = -1;
                         }

                         break;

                     default:
                         System.out.println("Opção inválida.");
                 }

             } while (opcao != 0);

             Pedido pedido = new Pedido(total);

             System.out.println(
                     "\n===== RESUMO DO PEDIDO =====");

             System.out.println(
                     "Valor dos produtos: R$"
                             + pedido.getValorTotal());

             if (pedido.getValorTotal() < 50) {

                 System.out.println(
                         "Taxa de entrega: R$8,00");

             } else {

                 System.out.println(
                         "Frete grátis!");
             }

             System.out.println(
                     "Total a pagar: R$"
                             + pedido.calcularTotalComFrete());

             sc.nextLine();

             String confirmar;

             do {

                 confirmar =
                         lerCampoObrigatorio(
                                 sc,
                                 "Deseja confirmar o pedido? (S/N): ");

                 if (!confirmar.equalsIgnoreCase("S")
                         && !confirmar.equalsIgnoreCase("N")) {

                     System.out.println(
                             "Digite apenas S ou N.");
                 }

             } while (!confirmar.equalsIgnoreCase("S")
                     && !confirmar.equalsIgnoreCase("N"));

             if (confirmar.equalsIgnoreCase("N")) {

                 System.out.println(
                         "\nPedido cancelado.");

                 sc.close();
                 return;
             }

             int formaPagamento;

             do {

                 System.out.println(
                         "\n===== PAGAMENTO =====");

                 System.out.println("1 - PIX");
                 System.out.println("2 - Cartão");
                 System.out.println("3 - Dinheiro");

                 System.out.print(
                         "Escolha a forma de pagamento: ");

                 while (!sc.hasNextInt()) {
                     System.out.println(
                             "Digite apenas números.");
                     sc.next();
                 }

                 formaPagamento = sc.nextInt();

                 if (formaPagamento < 1
                         || formaPagamento > 3) {

                     System.out.println(
                             "Forma de pagamento inválida.");
                 }

             } while (formaPagamento < 1
                     || formaPagamento > 3);

             sc.nextLine();

             String pagamento;

             do {

                 pagamento =
                         lerCampoObrigatorio(
                                 sc,
                                 "Pagamento aprovado? (S/N): ");

                 if (!pagamento.equalsIgnoreCase("S")
                         && !pagamento.equalsIgnoreCase("N")) {

                     System.out.println(
                             "Digite apenas S ou N.");
                 }

             } while (!pagamento.equalsIgnoreCase("S")
                     && !pagamento.equalsIgnoreCase("N"));

             if (pagamento.equalsIgnoreCase("N")) {

                 System.out.println(
                         "\nPagamento não autorizado.");

                 sc.close();
                 return;
             }

             System.out.println("\n===== PEDIDO =====");

             System.out.println(
                     "Número do pedido: "
                             + pedido.getNumeroPedido());

             System.out.println(
                     "Pedido registrado.");

             System.out.println(
                     "Pedido enviado para cozinha.");

             System.out.println(
                     "Status atualizado.");

             System.out.println(
                     "Pedido realizado com sucesso.");

             sc.close();
         }
     }



