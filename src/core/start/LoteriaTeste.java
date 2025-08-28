package core.start;

import core.cadastro.dominio.CadastroEndereco;
import core.cadastro.dominio.CadastroUsuario;

import java.sql.SQLException;

public class LoteriaTeste {
    public static void main(String[] args) {
        CadastroEndereco endereco = new CadastroEndereco();
        endereco.cadastarEndereco();

        try {
            endereco.addDataAdress();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        CadastroUsuario cadastroUser = new CadastroUsuario();
        cadastroUser.criarUsuario();
        try {
            cadastroUser.addDataUser();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
