package core.cadastro.dominio;

import core.endereco.Endereco;
import core.exception.ErrorCriarUsuario;

import java.util.Scanner;

public class CadastroEndereco extends Endereco {

    public void cadastarEndereco() throws ErrorCriarUsuario {
        Scanner entrada = new Scanner(System.in);

        while(true){
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
            this.numeroResidenciaDB = entrada.nextInt();

            System.out.println("Cep: ");
            this.cepDB = entrada.nextLine();
            

        }
    }
}
