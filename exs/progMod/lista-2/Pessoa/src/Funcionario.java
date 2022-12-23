package src;

public class Funcionario{
    private String cargo;
    private double salario;
    private PessoaFisica pessoa;
  
    public Funcionario(String cargo, double salario, PessoaFisica pessoa){

        this.setCargo(cargo);
        this.setSalario(salario);
        this.setPessoa(pessoa);

    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }
}
