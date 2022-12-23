/*  Código desenvolvido por:
**
**    ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗     
**    ██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║     
**    ██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║     
**    ██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║     
**    ╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
**     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
**/
package Business;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cliente implements Serializable{
    private String matricula;
    private String nome;
    private HashMap<String, Emprestimo> emprestimos = new HashMap<>();

    public Cliente(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public void fazerEmprestimo(Livro livro) {
        Emprestimo emprestimo = new Emprestimo(livro);
        emprestimos.put(emprestimo.getCodigo(), emprestimo);
    }

    public void renovarEmprestimo(String codEmprestimo) {
        emprestimos.get(codEmprestimo).renovar();
    }

    public void matricular() {
        Biblioteca.addCliente(this);
    }
    @Override
    public String toString(){
        String str = this.getDadosDoClienteString()+"\n\n"+this.getListaDeEmprestimosString();
        return str;
    }

    public String getDadosDoClienteString(){
        return "Maticula: " + this.matricula + "\nNome: " +this.nome ; 
    }
    public String getListaDeEmprestimosString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Emprestimo> lista = new ArrayList<Emprestimo>(emprestimos.values());
        String tabelaDeEmprestimos = String.format("| %-20s | %-20s | %-14s | %-14s | %-35s |\n",
                "CÓDIGO_EMPRESTIMO", "Data do emprestimo", "Data Inicial", "Data Final", "Livro");
        for (Emprestimo e : lista) {
            tabelaDeEmprestimos += String.format("| %-20s | %-20s | %-14s | %-14s | %-35s |\n",
                    e.getCodigo(), e.getDataDoEmprestimo().format(dateTimeFormatter),
                    e.getDataInicio().format(dateTimeFormatter), e.getDataFim().format(dateTimeFormatter), e.getLivro().getTitulo());
        }
        return tabelaDeEmprestimos;
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        ArrayList<Emprestimo> listaDeEmprestimosAtual = new ArrayList<Emprestimo>(emprestimos.values());
        return listaDeEmprestimosAtual;
    }

    /**
     * @return String return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
