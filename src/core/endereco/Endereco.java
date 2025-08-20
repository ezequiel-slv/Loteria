package core.endereco;

public abstract class Endereco {
    protected String estadoDB;
    protected String cidadeDB;
    protected String bairroDB;
    protected String ruaDB;
    protected String logradouroDB;
    protected int numeroResidenciaDB;
    protected String cepDB;

    public String getEstadoDB() {
        return estadoDB;
    }

    public void setEstadoDB(String estadoDB) {
        this.estadoDB = estadoDB;
    }

    public String getCidadeDB() {
        return cidadeDB;
    }

    public void setCidadeDB(String cidadeDB) {
        this.cidadeDB = cidadeDB;
    }

    public String getBairroDB() {
        return bairroDB;
    }

    public void setBairroDB(String bairroDB) {
        this.bairroDB = bairroDB;
    }

    public String getRuaDB() {
        return ruaDB;
    }

    public void setRuaDB(String ruaDB) {
        this.ruaDB = ruaDB;
    }

    public String getLogradouroDB() {
        return logradouroDB;
    }

    public void setLogradouroDB(String logradouroDB) {
        this.logradouroDB = logradouroDB;
    }

    public int getNumeroResidenciaDB() {
        return numeroResidenciaDB;
    }

    public void setNumeroResidenciaDB(int numeroResidenciaDB) {
        this.numeroResidenciaDB = numeroResidenciaDB;
    }

    public String getCepDB() {
        return cepDB;
    }

    public void setCepDB(String cepDB) {
        this.cepDB = cepDB;
    }
}
