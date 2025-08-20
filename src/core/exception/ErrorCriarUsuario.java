package core.exception;

public class ErrorCriarUsuario extends RuntimeException{
    public ErrorCriarUsuario() {
        super("Erro ao criar usuário!");
    }

    public ErrorCriarUsuario(String message) {
        super(message);
    }
}
