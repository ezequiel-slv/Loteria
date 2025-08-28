package core.cadastro.dominio;

import core.bancodedados.conexao.ConexaoBD;
import core.endereco.Endereco;
import core.exception.ErrorCriarUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroEndereco extends Endereco {

    public void cadastarEndereco() throws ErrorCriarUsuario {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("Estado: ");
            this.estadoDB = entrada.nextLine();

            System.out.println("Cidade: ");
            this.cidadeDB = entrada.nextLine();

            System.out.println("Bairro: ");
            this.bairroDB = entrada.nextLine();

            System.out.println("Rua: ");
            this.ruaDB = entrada.nextLine();

            System.out.println("Logradouro: ");
            this.logradouroDB = entrada.nextLine();

            System.out.println("Número: ");
            this.numeroResidenciaDB = Integer.parseInt(entrada.nextLine());

            System.out.println("Cep: ");
            this.cepDB = entrada.nextLine();

            boolean estadoInvalido = estadoDB == null || estadoDB.isEmpty();
            boolean cidadeInvalido = cidadeDB == null || cidadeDB.isEmpty();
            boolean bairroInvalido = bairroDB == null || bairroDB.isEmpty();
            boolean ruaInvalido = ruaDB == null || ruaDB.isEmpty();
            boolean lograInvalido = logradouroDB == null || logradouroDB.isEmpty();
            boolean numeroInvalido = numeroResidenciaDB == 0;
            boolean cepInvalido = cepDB == null || cepDB.isEmpty();

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
        String sql = "INSERT INTO endereco (estado, cidade, bairro, rua, logradouro, numero, cep, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement;
        try (Connection connection = ConexaoBD.getConectado()) {
            statement = connection.prepareStatement(sql);

            statement.setString(1, getEstadoDB());
            statement.setString(2, getCidadeDB());
            statement.setString(3, getBairroDB());
            statement.setString(4, getRuaDB());
            statement.setString(5, getLogradouroDB());
            statement.setInt(6, getNumeroResidenciaDB());
            statement.setString(7, getCepDB());
            statement.setInt(8, i);

            statement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException("Erro ao cadstrar endereço; " + e.getMessage());
        }
    }
}
