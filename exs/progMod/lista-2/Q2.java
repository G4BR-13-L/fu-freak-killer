


/**TESTES */
package test;
import src.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import src.Pessoa;

import java.time.LocalDateTime;

public class PessoaTest {

    PessoaFisica pessoa;
    Empresa empresa;

    @BeforeEach
    public void setup() {
        pessoa = new PessoaFisica(
                "Gabriel",
                "(12)91234-5678",
                "0001203-12",
                "Rua algum lugar, Belo Horizonte",
                "MG", "000.000.000-00");
         empresa = new Empresa();
        
    }

    @Test
    public void contratacaoDeFuncionario(){
        empresa.contratar(pessoa, 3000, "Estagiario");
        assertEquals("Gabriel", empresa.getFuncionario(0).getPessoa().getNome());
    }

    @Test
    public void aquisicaoDeClientePessoaFisica(){
        Cliente cliente = new Cliente(pessoa, 10000);
        empresa.addCliente(cliente);
        assertEquals("Gabriel", empresa.getCliente(0).getNome());
    }
    @Test
    public void aquisicaoDeClientePessoaJuridica(){
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Google" ,"(10)00000-0000" ,"0123441-13" ,"Algum endereço de sao paulo" ,"SP", "000.214321.32143.214321.321.2");
        Cliente cliente = new Cliente(pessoaJuridica, 10000);
        empresa.addCliente(cliente);
        assertEquals("Google", empresa.getCliente(0).getNome());
    }

    @Test
    public void testarQuemEOPresidente(){
        empresa.contratar(pessoa, 3000, "Estagiario");
        empresa.setPresidente(empresa.getFuncionario(0));
        assertEquals("Gabriel", empresa.getPresidente().getPessoa().getNome());
    }

    @Test
    public void removerFuncionariosEClientes(){
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Google" ,"(10)00000-0000" ,"0123441-13" ,"Algum endereço de sao paulo" ,"SP", "000.214321.32143.214321.321.2");
        Cliente clienteJuridico = new Cliente(pessoaJuridica, 10000);
        empresa.removeCliente(clienteJuridico);
        assertEquals(0, empresa.getQtdClientes());

        Cliente clienteFisico = new Cliente(pessoa, 10000);
        empresa.removeCliente(clienteFisico);
        assertEquals(0, empresa.getQtdClientes());

        empresa.contratar(pessoa, 3000, "Estagiario");
        empresa.demitir(empresa.getFuncionario(0));
        assertEquals(0, empresa.getQtdFuncionarios());
    }
    

}


/**PESSOA */
package src;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Pessoa {
    
    private String nome;
    private String telefone;
    private String cep;
    private String endereco;
    private String uf;

    public Pessoa(String nome ,String telefone ,String cep ,String endereco ,String uf) {
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setCep(cep);
        this.setEndereco(endereco);
        this.setUf(uf);
    }
    

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }

}


/**PESSOA FISICA */
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

/**PESSOA JURIDICA */
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


/**EMPRESA */
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

/**FUNCIONARIO */
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


/**CLIENTE */
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






