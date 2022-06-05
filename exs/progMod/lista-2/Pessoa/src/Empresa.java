package src;

import java.util.LinkedList;

public class Empresa{
    private LinkedList<Cliente> clientes = new LinkedList<>();
    private LinkedList<Funcionario> funcionarios = new LinkedList<>();
    private Funcionario presidente;
    
    public void contratar(PessoaFisica pessoaDesempregada, double salario, String cargo) {
        Funcionario novoFuncionario = new Funcionario(cargo, salario, pessoaDesempregada);
        funcionarios.add(novoFuncionario);
    }

    public Funcionario getFuncionario(int i) {
        return funcionarios.get(i);
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Cliente getCliente(int i) {
        return clientes.get(i);
    }
    public void setPresidente(Funcionario funcionario){
        this.presidente = funcionario;
    }
    public Funcionario getPresidente(){
        return this.presidente;
    }

    public void removeCliente(Cliente clienteJuridico) {
        clientes.remove(clienteJuridico);
    }

    public Integer getQtdClientes() {
        return clientes.size();
    }

    public Integer getQtdFuncionarios() {
        return funcionarios.size();
    }

    public void demitir(Funcionario funcionario) {
        if( funcionario == this.getPresidente() ){
            funcionarios.remove(funcionario);
            this.presidente = null;
        }else{
            funcionarios.remove(funcionario);
        }
    }

}

