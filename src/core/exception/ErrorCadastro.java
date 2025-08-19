package core.exception;

import java.io.IOException;

public class ErrorCadastro extends RuntimeException{
    public ErrorCadastro() {
        super("Erro ao fazer cadastro!");
    }

    public ErrorCadastro(String message) {
        super(message);
    }
}
