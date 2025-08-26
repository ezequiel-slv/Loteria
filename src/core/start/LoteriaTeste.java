package core.start;

import core.cadastro.dominio.CadastroUsuario;

import java.sql.SQLException;

public class LoteriaTeste {
    public static void main(String[] args) {
        CadastroUsuario cadastro = new CadastroUsuario();
        cadastro.criarUsuario();
        try {
            cadastro.Salvar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
