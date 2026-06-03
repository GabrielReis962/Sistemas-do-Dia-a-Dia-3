package Sistema_de_Reserva_de_Hotel;

public class Hospede {

    private String cidade;
    private String checkIn;
    private String checkOut;
    private int quantidadeHospedes;

    public Hospede(String cidade, String checkIn,
                   String checkOut, int quantidadeHospedes) {

        this.cidade = cidade;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.quantidadeHospedes = quantidadeHospedes;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }
}

