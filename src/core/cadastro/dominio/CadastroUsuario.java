package core.cadastro.dominio;

import core.endereco.Endereco;
import core.exception.ErrorCriarUsuario;

import java.util.Scanner;

public class CadastroUsuario extends Jogador{
    private String emailDB;
    private String senhaDB;
    private long numeroTelefoneDB;
    private Endereco  endereco;

    private static final String rotulo = "---- Cadastro ----";

    static {
        System.out.println(rotulo);
    }
    public void criarUsuario() throws ErrorCriarUsuario {
        Scanner entrada = new Scanner(System.in);

        while (true){
            System.out.println("Digite seu nomeDB completo: ");
            this.nomeDB = entrada.nextLine();

            System.out.println("Digite seu Email: ");
            this.emailDB = entrada.nextLine();

            System.out.println("Digite uma senha: ");
            this.senhaDB = entrada.nextLine();

            boolean nomeDBInvalido = getNomeDB() == null || getNomeDB().isEmpty();
            boolean emailInvalido = !emailDB.matches(".*[@].*") && emailDB.isEmpty();
            boolean upper = senhaDB.matches(".*[A-Z].*");
            boolean low = senhaDB.matches(".*[a-z].*");
            boolean num = senhaDB.matches(".*[0-9].*");
            boolean upperAndLow = upper && low;
            boolean especialCharacter = senhaDB.matches(".*[!@#$%^&*()\\-+_=~`{}\\[\\]:;\"'<>,.?/|\\\\].*");
            boolean senhaInvalida = !upperAndLow || !num || especialCharacter;

            if (!nomeDBInvalido){
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
