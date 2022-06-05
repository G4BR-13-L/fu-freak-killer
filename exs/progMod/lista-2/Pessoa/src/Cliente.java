package src;

public class Cliente{
    private double limiteDeCredito;
    private Pessoa pessoa;

    public Cliente(Pessoa pessoa, double limiteDeCredito){

        this.setPessoa(pessoa);
        this.setLimiteDeCredito(limiteDeCredito);
    }
    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }
    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }
    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    public Pessoa getPessoa(){
        return this.pessoa;
    }

    public String getNome(){
        return this.pessoa.getNome();
    }

}
