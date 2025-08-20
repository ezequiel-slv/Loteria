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

            boolean estadoInvalido = estadoDB == null || estadoDB.isEmpty();
            boolean cidadeInvalido = cidadeDB == null || cidadeDB.isEmpty();
            boolean bairroInvalido = bairroDB == null || bairroDB.isEmpty();
            boolean ruaInvalido = ruaDB == null || ruaDB.isEmpty();
            boolean lograInvalido = logradouroDB == null || logradouroDB.isEmpty();
            boolean numeroInvalido = numeroResidenciaDB == 0;
            boolean cepInvalido = cepDB == null || cepDB.isEmpty();

            if (!estadoInvalido){
                if (!cidadeInvalido){
                    if (!bairroInvalido){
                        if (!ruaInvalido){
                            if (!lograInvalido){
                                if (!numeroInvalido){
                                    if (!cepInvalido){

                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
