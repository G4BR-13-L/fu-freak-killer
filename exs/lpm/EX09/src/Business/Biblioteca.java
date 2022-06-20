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
import java.util.List;

public class Biblioteca implements Serializable {

    private static HashMap<String, Livro> livros = new HashMap<String, Livro>();
    private static HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();

    public static void addLivro(Livro livro) {
        livros.put(livro.getCodigo(), livro);
    }

    public Livro getLivro(String codigo) {
        return livros.get(codigo);
    }

    public static void addCliente(Cliente cliente) {
        clientes.put(cliente.getMatricula(), cliente);
    }

    public Cliente getCliente(String matricula) {
        return clientes.get(matricula);
    }

    public List<Emprestimo> getListaDeEmprestimos() {
        List<Cliente> listaDeClientes = new ArrayList<Cliente>(clientes.values());
        List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        for (Cliente cliente : listaDeClientes) {
            for (Emprestimo emprestimo : cliente.getEmprestimos()) {
                emprestimos.add(emprestimo);
            }
        }
        return emprestimos;
    }

    public String getListaDeEmprestimosString() {
        List<Cliente> listaDeClientes = new ArrayList<Cliente>(clientes.values());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String tabelaDeEmprestimos = String.format(
                "| %-20s | %-20s | %-20s | %-20s | %-14s | %-14s | %-15s | %-35s |\n",
                "CÓDIGO_EMPRESTIMO", "MATRICULA", "CLIENTE", "Data do emprestimo", "Data Inicial", "Data Final",
                "CODIGO_LIVRO", "Livro");
        for (Cliente c : listaDeClientes) {
            ArrayList<Emprestimo> listaDeEmprestimosDoCliente = c.getEmprestimos();
            for (Emprestimo e : listaDeEmprestimosDoCliente) {
                tabelaDeEmprestimos += String.format(
                        "| %-20s | %-20s | %-20s | %-20s | %-14s | %-14s | %-15s | %-35s |\n",
                        e.getCodigo(), c.getMatricula(), c.getNome(), e.getDataDoEmprestimo().format(dateTimeFormatter),
                        e.getDataInicio().format(dateTimeFormatter), e.getDataFim().format(dateTimeFormatter),
                        e.getLivro().getCodigo(), e.getLivro().getTitulo());
            }
        }
        return tabelaDeEmprestimos;
    }

    public String getLivrosEmprestadosString(){
        String stringLivros = "Emprestado | Titulo";
        for ( Livro livro : Biblioteca.livros.values() ) {
            //if( livro.isIsEmprestado() ){
                stringLivros  +=livro.isIsEmprestado()+" | "+livro.getTitulo()+"\n";
           // }
        }
        return stringLivros;


    }

}
