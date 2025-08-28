package core.start;

import core.cadastro.dominio.Cadastro;

import java.sql.SQLException;

public class LoteriaTeste {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();

        cadastro.cadastarEndereco();
        cadastro.criarUsuario();

        try {
            cadastro.addDataAdress();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            cadastro.addDataUser();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
