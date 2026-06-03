package Sistema_de_Delivery_de_Restaurante;

 class Pedido {




         private double valorTotal;
         private int numeroPedido;

         public Pedido(double valorTotal) {
             this.valorTotal = valorTotal;
             this.numeroPedido = (int) (Math.random() * 10000);
         }

         public double getValorTotal() {
             return valorTotal;
         }

         public int getNumeroPedido() {
             return numeroPedido;
         }

         public double calcularTotalComFrete() {

             if (valorTotal < 50) {
                 return valorTotal + 8;
             }

             return valorTotal;
         }
     }