package core.login.dominio;

import java.util.Scanner;

public class LoginUsuario {
    private String usuarioLog;
    private String senhaLog;

    public void fazerLogin(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite seu usuário");
        this.usuarioLog = entrada.nextLine();

        System.out.println("Digite sua senha");
        this.senhaLog = entrada.nextLine();
    }

    public String getUsuarioLog() {
        return usuarioLog;
    }

    public String getSenhaLog() {
        return senhaLog;
    }
}
