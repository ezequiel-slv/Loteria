package core.exception;

public class ErrorEndereco extends RuntimeException {

    public ErrorEndereco() {
        super("Erro ao cadastrar endereço!");
    }

    public ErrorEndereco(String message) {
        super(message);
    }
}
