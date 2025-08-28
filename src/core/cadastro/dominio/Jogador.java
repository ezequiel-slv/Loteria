package core.cadastro.dominio;

import core.endereco.Endereco;

public class Jogador extends Pessoa{
    private String emailDB;
    private String senhaDB;
    private static int codJogador = 0;

    public int gerarCodigo(){
        return  codJogador++;
    }
    @Override
    public String getNomeDB() {
        return super.getNome();
    }

    @Override
    public void setNomeDB(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getdatanascimentoDB() {
        return super.getdatanascimentoDB();
    }

    @Override
    public void setdatanascimentoDB(String datanascimentoDB) {
        super.setdatanascimentoDB(datanascimentoDB);
    }

    @Override
    public String getCpfDB() {
        return super.getCpfDB();
    }

    @Override
    public void setCpfDB(String cpfDB) {
        super.setCpfDB(cpfDB);
    }

    public String getEmailDB() {
        return emailDB;
    }

    public void setEmailDB(String emailDB) {
        this.emailDB = emailDB;
    }

    public String getSenhaDB() {
        return senhaDB;
    }

    public void setSenhaDB(String senhaDB) {
        this.senhaDB = senhaDB;
    }
}
