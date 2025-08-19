package core.cadastro.dominio;

import core.exception.ErrorCadastro;

import java.util.Scanner;

public class Cadastro extends Jogador{
    private String emailDB;
    private String senhaDB;

    private static final String rotulo = "---- Cadastro ----";

    static {
        System.out.println(rotulo);
    }

    public void fazerCadastro() throws ErrorCadastro {
        Scanner entrada = new Scanner(System.in);

        while (true){
            System.out.println("Digite seu nome completo: ");
            this.nome = entrada.nextLine();

            System.out.println("Digite seu Email: ");
            this.emailDB = entrada.nextLine();

            System.out.println("Digite uma senha: ");
            this.senhaDB = entrada.nextLine();

            boolean nomeInvalido = getNome() == null || getNome().isEmpty();
            boolean emailInvalido = !emailDB.matches(".*[@].*") && emailDB.isEmpty();
            boolean upper = senhaDB.matches(".*[A-Z].*");
            boolean low = senhaDB.matches(".*[a-z].*");
            boolean num = senhaDB.matches(".*[0-9].*");
            boolean upperAndLow = upper && low;
            boolean especialCharacter = senhaDB.matches(".*[!@#$%^&*()\\-+_=~`{}\\[\\]:;\"'<>,.?/|\\\\].*");
            boolean senhaInvalida = !upperAndLow || !num || especialCharacter;

            if (!nomeInvalido){
                if (!emailInvalido){
                    if (!senhaInvalida){
                        System.out.println("Cadastro feito com sucesso!");
                        break;
                    }
                }
            }
        }
    }
}
