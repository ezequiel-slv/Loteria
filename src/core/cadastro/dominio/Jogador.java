package core.cadastro.dominio;

public class Jogador extends Pessoa{
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
}
