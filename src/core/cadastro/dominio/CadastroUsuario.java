package core.cadastro.dominio;

import core.bancodedados.conexao.ConexaoBD;
import core.exception.ErrorCriarUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroUsuario extends Jogador{
    private String emailDB;
    private String senhaDB;

    private static final String rotulo = "---- Cadastro ----";

    static {
        System.out.println(rotulo);
    }
    public void criarUsuario() throws ErrorCriarUsuario {
        Scanner entrada = new Scanner(System.in);

        while (true){
            System.out.println("Digite seu nome completo: ");
            this.nomeDB = entrada.nextLine();

            System.out.println("Digite seu Email: ");
            this.emailDB = entrada.nextLine();

            System.out.println("Digite uma senha: ");
            this.senhaDB = entrada.nextLine();

            boolean nomeDBInvalido = getNomeDB() == null || getNomeDB().isEmpty();
            boolean emailInvalido = !emailDB.matches(".*[@].*") || emailDB.isEmpty();
            boolean upper = senhaDB.matches(".*[A-Z].*");
            boolean low = senhaDB.matches(".*[a-z].*");
            boolean num = senhaDB.matches(".*[0-9].*");
            boolean upperAndLow = upper && low;
            boolean especialCharacter = senhaDB.matches(".*[!@#$%^&*()\\-+_=~`{}\\[\\]:;\"'<>,.?/|\\\\].*");
            boolean senhaInvalida = !(upperAndLow && num && especialCharacter);

            if (!nomeDBInvalido){
                if (!emailInvalido){
                    if (!senhaInvalida){
                        System.out.println("Cadastro feito com sucesso!");
                        break;
                    }else {
                        System.out.println("Digite uma senha válida!");
                    }
                }else{
                    System.out.println("Digite um email válido!");
                }
            }else{
                System.out.println("Digite um nome válido!");
            }
        }
        entrada.close();
    }

    public void Salvar() throws SQLException {
        String sql = "INSERT INTO user (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection connection = ConexaoBD.getConectado();
             PreparedStatement statement = connection.prepareStatement(sql)){
                 statement.setString(1, getNomeDB());
                 statement.setString(2, getEmailDB());
                 statement.setString(3, getSenhaDB());
                 statement.executeUpdate();

        }catch (SQLException e){
                 throw new RuntimeException("Erro ao salvar usuário: " + e.getMessage());
        }

    }

    public String getEmailDB() {
        return emailDB;
    }

    public String getSenhaDB() {
        return senhaDB;
    }
}
