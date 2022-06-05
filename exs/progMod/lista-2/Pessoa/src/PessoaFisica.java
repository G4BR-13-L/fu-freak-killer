package src;

public class PessoaFisica extends Pessoa{
    
    private String cpf;

    public PessoaFisica(String nome ,String telefone ,String cep ,String endereco ,String uf, String cpf){
        super(nome ,telefone ,cep ,endereco ,uf);
        this.setCpf(cpf);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
