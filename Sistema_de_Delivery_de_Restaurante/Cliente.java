package Sistema_de_Delivery_de_Restaurante;



import java.util.Scanner;



    public class Cliente {

        private String email;
        private String senha;

        public Cliente(String email, String senha) {
            this.email = email;
            this.senha = senha;
        }

        public String getEmail() {
            return email;
        }

        public String getSenha() {
            return senha;
        }
    }