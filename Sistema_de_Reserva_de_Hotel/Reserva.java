package Sistema_de_Reserva_de_Hotel;

public class Reserva {

    private String quarto;
    private int diarias;
    private double valorTotal;
    private int numeroReserva;

    public Reserva(String quarto, int diarias) {

        this.quarto = quarto;
        this.diarias = diarias;

        double valorDiaria;

        if (quarto.equalsIgnoreCase("Luxo")) {
            valorDiaria = 350;
        } else {
            valorDiaria = 200;
        }

        valorTotal = valorDiaria * diarias;

        if (diarias > 5) {
            valorTotal *= 0.90;
        }

        numeroReserva = (int) (Math.random() * 10000);
    }

    public String getQuarto() {
        return quarto;
    }

    public int getDiarias() {
        return diarias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }
}

