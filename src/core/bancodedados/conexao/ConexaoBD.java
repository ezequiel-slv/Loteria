package core.bancodedados.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String caminhoConexaoBD = "jdbc:mysql://localhost:3308/loteria";
    private static final String UsuarioBD = "root";
    private static final String senhaBD = "password";
    public static Connection getConectado(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(caminhoConexaoBD, UsuarioBD, senhaBD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
