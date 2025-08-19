package core.cadastro.dominio;

public class Jogador extends Pessoa{
    private static int codJogador = 0;

    public int gerarCodigo(){
        return  codJogador++;
    }
    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getDataNascimento() {
        return super.getDataNascimento();
    }

    @Override
    public void setDataNascimento(String dataNascimento) {
        super.setDataNascimento(dataNascimento);
    }

    @Override
    public String getCpf() {
        return super.getCpf();
    }

    @Override
    public void setCpf(String cpf) {
        super.setCpf(cpf);
    }
}
