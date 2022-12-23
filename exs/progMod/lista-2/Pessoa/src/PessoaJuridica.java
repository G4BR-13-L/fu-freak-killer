package src;
public class PessoaJuridica extends Pessoa{
    
    private String cnpj;

    public PessoaJuridica(String nome ,String telefone ,String cep ,String endereco ,String uf, String cnpj){
        super(nome ,telefone ,cep ,endereco ,uf);
        this.setCnpj(cnpj);
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
