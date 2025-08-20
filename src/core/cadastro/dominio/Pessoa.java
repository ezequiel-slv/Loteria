package core.cadastro.dominio;

import core.endereco.Endereco;

public abstract class Pessoa {

    protected String nomeDB;
    protected String datanascimentoDB;
    protected String cpfDB;
    protected Endereco endereco;

    public String getNome() {
        return nomeDB;
    }

    public void setNome(String nome) {
        this.nomeDB = nome;
    }

    public String getdatanascimentoDB() {
        return datanascimentoDB;
    }

    public void setdatanascimentoDB(String datanascimentoDB) {
        this.datanascimentoDB = datanascimentoDB;
    }

    public String getNomeDB() {
        return nomeDB;
    }

    public void setNomeDB(String nomeDB) {
        this.nomeDB = nomeDB;
    }

    public String getDatanascimentoDB() {
        return datanascimentoDB;
    }

    public void setDatanascimentoDB(String datanascimentoDB) {
        this.datanascimentoDB = datanascimentoDB;
    }

    public String getCpfDB() {
        return cpfDB;
    }

    public void setCpfDB(String cpfDB) {
        this.cpfDB = cpfDB;
    }
}
