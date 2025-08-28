package core.cadastro.dominio;

import core.bancodedados.conexao.ConexaoBD;
import core.endereco.Endereco;
import core.exception.ErrorCriarUsuario;

import java.sql.*;
import java.util.Scanner;

public class Cadastro{
    private final Jogador jogador = new Jogador();
    private int idGerado;
    private static final String rotulo = "---- Cadastro ----";

    static {
        System.out.println(rotulo);
    }
    public void cadastarEndereco() throws ErrorCriarUsuario {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("Estado: ");
            this.jogador.setEstadoDB(entrada.nextLine());

            System.out.println("Cidade: ");
            this.jogador.setCidadeDB(entrada.nextLine());

            System.out.println("Bairro: ");
            this.jogador.setBairroDB(entrada.nextLine());

            System.out.println("Rua: ");
            this.jogador.setRuaDB(entrada.nextLine());

            System.out.println("Logradouro: ");
            this.jogador.setLogradouroDB(entrada.nextLine());

            System.out.println("Número: ");
            this.jogador.setNumeroResidenciaDB(entrada.nextInt());
            entrada.nextLine();

            System.out.println("Cep: ");
            this.jogador.setCepDB(entrada.nextLine());

            boolean estadoInvalido = jogador.getEstadoDB() == null || jogador.getEstadoDB().isEmpty();
            boolean cidadeInvalido = jogador.getCidadeDB() == null || jogador.getCidadeDB().isEmpty();
            boolean bairroInvalido = jogador.getBairroDB() == null || jogador.getBairroDB().isEmpty();
            boolean ruaInvalido = jogador.getRuaDB() == null || jogador.getRuaDB().isEmpty();
            boolean lograInvalido = jogador.getLogradouroDB() == null || jogador.getLogradouroDB().isEmpty();
            boolean numeroInvalido = jogador.getNumeroResidenciaDB() == 0;
            boolean cepInvalido = jogador.getCepDB() == null || jogador.getCepDB().isEmpty();

            if (!estadoInvalido) {
                return;
            } else {
                System.out.println("Digite um estado válido!");
            }

            if (!cidadeInvalido) {
                return;
            } else {
                System.out.println("Digite uma cidade válida!");
            }

            if (!bairroInvalido) {
                return;
            } else {
                System.out.println("Digite um bairro válido!");
            }

            if (!ruaInvalido) {
                return;
            } else {
                System.out.println("Digite uma válida!");
            }

            if (!lograInvalido) {
                return;
            } else {
                System.out.println("Digite um logradouro válido!");
            }

            if (!numeroInvalido) {
                return;
            } else {
                System.out.println("Digite um número válido!");
            }

            if (!cepInvalido) {
                return;
            } else {
                System.out.println("Digite um Cep válido!");
            }
        }
    }

    public void addDataAdress() throws SQLException {
        String sql = "INSERT INTO endereco (estado, cidade, bairro, rua, logradouro, numero, cep) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement;
        try (Connection connection = ConexaoBD.getConectado()) {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, jogador.getEstadoDB());
            statement.setString(2, jogador.getCidadeDB());
            statement.setString(3, jogador.getBairroDB());
            statement.setString(4, jogador.getRuaDB());
            statement.setString(5, jogador.getLogradouroDB());
            statement.setInt(6, jogador.getNumeroResidenciaDB());
            statement.setString(7, jogador.getCepDB());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            int idEndereco = -1;
            if (rs.next()){
                idEndereco = rs.getInt(1);
            }else{
                throw new RuntimeException("Erro ao buscar id");
            }

            setIdGerado(idEndereco);

        }catch (SQLException e){
            throw new RuntimeException("Erro ao cadstrar endereço; " + e.getMessage());
        }
    }
    public void criarUsuario() throws ErrorCriarUsuario {
        Scanner entrada = new Scanner(System.in);

        while (true){
            System.out.println("Digite seu nome completo: ");
            this.jogador.setNomeDB(entrada.nextLine());

            System.out.println("Digite seu Email: ");
            this.jogador.setEmailDB(entrada.nextLine());

            System.out.println("Digite uma senha: ");
            this.jogador.setSenhaDB(entrada.nextLine());

            boolean nomeDBInvalido = jogador.getNomeDB() == null || jogador.getNomeDB().isEmpty();
            boolean emailInvalido = !jogador.getEmailDB().matches(".*[@].*") || jogador.getEmailDB().isEmpty();
            boolean upper = jogador.getSenhaDB().matches(".*[A-Z].*");
            boolean low = jogador.getSenhaDB().matches(".*[a-z].*");
            boolean num = jogador.getSenhaDB().matches(".*[0-9].*");
            boolean upperAndLow = upper && low;
            boolean especialCharacter = jogador.getSenhaDB().matches(".*[!@#$%^&*()\\-+_=~`{}\\[\\]:;\"'<>,.?/|\\\\].*");
            boolean senhaInvalida = !(upperAndLow && num && especialCharacter);

            if (!nomeDBInvalido){
                return;
            }else{
                System.out.println("Digite um nome válido!");
            }

            if (!emailInvalido){
                return;
            }else{
                System.out.println("Digite um email válido!");
            }

            if (!senhaInvalida){
                System.out.println("Cadastro feito com sucesso!");
                break;
            }else {
                System.out.println("Digite uma senha válida!");
            }
        }
        entrada.close();
    }
    public void addDataUser() throws SQLException {
        String sql = "INSERT INTO user (nome, email, senha, id_endereco) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConexaoBD.getConectado();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, jogador.getNomeDB());
            statement.setString(2, jogador.getEmailDB());
            statement.setString(3, jogador.getSenhaDB());
            statement.setInt(4, getIdGerado());
            statement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException("Erro ao salvar usuário: " + e.getMessage());
        }
    }
    public int getIdGerado() {
        return idGerado;
    }
    public void setIdGerado(int idGerado) {
        this.idGerado = idGerado;
    }
}
