
/*
=====================================================
Código desenvolvido por:
 ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗
██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║
██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║
██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║
╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
 ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
 =====================================================
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

import Business.Biblioteca;
import Business.Cliente;
import Business.Emprestimo;
import Business.Livro;
import dao.ClienteDAO;
import dao.DAO;
import dao.LivroDAO;

public class Main {
    public static void main(String[] args) throws IOException {
        Biblioteca biblioteca = new Biblioteca();
        File fileLivros = new File("./Data/Livros.txt");
        Scanner sc1 = new Scanner(fileLivros);
        while (sc1.hasNext()) {
            String linha = sc1.nextLine();
            String[] partes = linha.split(";");
            String codigo = partes[0];
            String titulo = partes[1];
            Livro livro = new Livro(codigo, titulo);
            livro.adicionarABiblioteca();
        }
        sc1.close();

        File fileCliente = new File("./Data/Clientes.txt");
        Scanner sc2 = new Scanner(fileCliente);
        while (sc2.hasNext()) {
            String linha = sc2.nextLine();
            String[] partes = linha.split(";");
            String matricula = partes[0];
            String nome = partes[1];
            Cliente cliente = new Cliente(matricula, nome);
            cliente.matricular();
        }
        sc2.close();

        // =====================================================
        // FAZENDO EMPRESTIMOS
        // =====================================================
        biblioteca.getCliente("Q4E8A7").fazerEmprestimo(biblioteca.getLivro("DSBLVRN4"));
        biblioteca.getCliente("Q4E8A7").fazerEmprestimo(biblioteca.getLivro("LJ7AD37D"));
        biblioteca.getCliente("Q4E8A7").fazerEmprestimo(biblioteca.getLivro("ADS7ZK5P"));
        biblioteca.getCliente("Q4E8A7").fazerEmprestimo(biblioteca.getLivro("D279IVGE"));
        biblioteca.getCliente("Q4E8A7").fazerEmprestimo(biblioteca.getLivro("70WT64GO"));
        biblioteca.getCliente("Q4E8A7").fazerEmprestimo(biblioteca.getLivro("96KHUL73"));
        biblioteca.getCliente("Q4E8A7").fazerEmprestimo(biblioteca.getLivro("1VKB30XI"));
        biblioteca.getCliente("Q4E8A7").fazerEmprestimo(biblioteca.getLivro("X38AAT13"));
        biblioteca.getCliente("Q4E8A7").fazerEmprestimo(biblioteca.getLivro("6UDYSI0Z"));
        biblioteca.getCliente("N81I30").fazerEmprestimo(biblioteca.getLivro("8R0WB267"));
        biblioteca.getCliente("6E87ZK").fazerEmprestimo(biblioteca.getLivro("I70RTI47"));
        biblioteca.getCliente("NVCZD4").fazerEmprestimo(biblioteca.getLivro("RQCO839F"));
        biblioteca.getCliente("L0Y9IT").fazerEmprestimo(biblioteca.getLivro("QKIGJO3V"));
        biblioteca.getCliente("2SHDPX").fazerEmprestimo(biblioteca.getLivro("KC6BLJIU"));
        biblioteca.getCliente("JVMHXC").fazerEmprestimo(biblioteca.getLivro("EMDERJCB"));
        biblioteca.getCliente("ZP240C").fazerEmprestimo(biblioteca.getLivro("ZYK36NI5"));
        biblioteca.getCliente("D16413").fazerEmprestimo(biblioteca.getLivro("0FK8ZXSI"));
        biblioteca.getCliente("3IN3WK").fazerEmprestimo(biblioteca.getLivro("Q24CSAAG"));
        biblioteca.getCliente("5P8IJ4").fazerEmprestimo(biblioteca.getLivro("CYEQI01I"));
        biblioteca.getCliente("JA20Z3").fazerEmprestimo(biblioteca.getLivro("DQ8BAC4H"));

        // =====================================================
        // SALVANDO OBJETOS DE CLIENTES EM ARQUIVOS
        // =====================================================
        System.out.println("\n\nSALVANDO OBJETOS DE CLIENTES EM ARQUIVOS\n\n");
        DAO<Cliente, String> clientesDao = new ClienteDAO("Clientes.bin");
        clientesDao.add(biblioteca.getCliente("Q4E8A7"));
        clientesDao.add(biblioteca.getCliente("Q4E8A7"));
        clientesDao.add(biblioteca.getCliente("Q4E8A7"));
        clientesDao.add(biblioteca.getCliente("Q4E8A7"));
        clientesDao.add(biblioteca.getCliente("Q4E8A7"));
        clientesDao.add(biblioteca.getCliente("Q4E8A7"));
        clientesDao.add(biblioteca.getCliente("Q4E8A7"));
        clientesDao.add(biblioteca.getCliente("Q4E8A7"));
        clientesDao.add(biblioteca.getCliente("Q4E8A7"));
        clientesDao.add(biblioteca.getCliente("N81I30"));
        clientesDao.add(biblioteca.getCliente("6E87ZK"));
        clientesDao.add(biblioteca.getCliente("NVCZD4"));
        clientesDao.add(biblioteca.getCliente("L0Y9IT"));
        clientesDao.add(biblioteca.getCliente("2SHDPX"));
        clientesDao.add(biblioteca.getCliente("JVMHXC"));
        clientesDao.add(biblioteca.getCliente("ZP240C"));
        clientesDao.add(biblioteca.getCliente("D16413"));
        clientesDao.add(biblioteca.getCliente("3IN3WK"));
        clientesDao.add(biblioteca.getCliente("5P8IJ4"));
        clientesDao.add(biblioteca.getCliente("JA20Z3"));

        // =====================================================
        // SALVANDO OBJETOS DE LIVROS EM ARQUIVOS
        // =====================================================
        System.out.println("\n\nSALVANDO OBJETOS DE LIVROS EM ARQUIVOS\n\n");
        DAO<Livro, String> livrosDao = new LivroDAO("Livros.bin");

        livrosDao.add(biblioteca.getLivro("DSBLVRN4"));
        livrosDao.add(biblioteca.getLivro("LJ7AD37D"));
        livrosDao.add(biblioteca.getLivro("ADS7ZK5P"));
        livrosDao.add(biblioteca.getLivro("D279IVGE"));
        livrosDao.add(biblioteca.getLivro("70WT64GO"));
        livrosDao.add(biblioteca.getLivro("96KHUL73"));
        livrosDao.add(biblioteca.getLivro("1VKB30XI"));
        livrosDao.add(biblioteca.getLivro("X38AAT13"));
        livrosDao.add(biblioteca.getLivro("6UDYSI0Z"));
        livrosDao.add(biblioteca.getLivro("8R0WB267"));
        livrosDao.add(biblioteca.getLivro("I70RTI47"));
        livrosDao.add(biblioteca.getLivro("RQCO839F"));
        livrosDao.add(biblioteca.getLivro("QKIGJO3V"));
        livrosDao.add(biblioteca.getLivro("KC6BLJIU"));
        livrosDao.add(biblioteca.getLivro("EMDERJCB"));
        livrosDao.add(biblioteca.getLivro("ZYK36NI5"));
        livrosDao.add(biblioteca.getLivro("0FK8ZXSI"));
        livrosDao.add(biblioteca.getLivro("Q24CSAAG"));
        livrosDao.add(biblioteca.getLivro("CYEQI01I"));
        livrosDao.add(biblioteca.getLivro("DQ8BAC4H"));
       
       
       
        /*✩░▒▓▆▅▃▂▁𝐄𝐗𝟎𝟗▁▂▃▅▆▓▒░✩*/

        // =========================================================================================
        // PESQUISANDO CLIENTE POR MATRICULA
        Cliente cliente = biblioteca.getCliente("Q4E8A7");
        // =========================================================================================

        // =========================================================================================
        // PESQUISANDO PELO EMPRESTIMO MAIS RECENTE
        Emprestimo maisRecente = biblioteca.getCliente("Q4E8A7")
                .getEmprestimoMaisRecente();
        System.out.println("=======================\nEmprestimo mais recente: \n\n" +
                String.format("| %-28s | %-30s | %-30s |\n", "Data", "Livro", "Cliente") +
                String.format("| %-28s | %-30s | %-30s |\n", maisRecente.getDataDoEmprestimo(),
                        maisRecente.getLivro().getTitulo(), biblioteca.getCliente("Q4E8A7").getNome()));
        // =========================================================================================

        // =========================================================================================
        // PESQUISANDO TODOS OS EMPRESTIMOS EM ATRASO
        // essa data serve apenas para simular atrasos
        LocalDateTime dataFalsa = LocalDateTime.now().plusMonths(2);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String relatorioDeAtrasos = biblioteca.getCliente("Q4E8A7")
                .getEmprestimosAtrasados()
                .stream()
                .map(c -> c.toString())
                .reduce((a, b) -> a.concat(b)).get();

        System.out.println(
                "\n\n=======================\nData de simulação do atraso: " + dataFalsa.format(dateTimeFormatter)
                        + "\nEmprestimos ATRASADOS: \n\n" +
                        String.format("| %-20s | %-20s | %-14s | %-14s | %-35s |\n",
                                "CÓDIGO_EMPRESTIMO", "Data do emprestimo", "Data Inicial", "Data Final", "Livro")
                        +

                        relatorioDeAtrasos);
        // =========================================================================================

        // =========================================================================================
        // EXIBIR EMPRESTIMOS FEITOS NO MES ATUAL
        String emprestimosDoMes = biblioteca.getCliente("Q4E8A7")
                .getEmprestimosDoMeAtual()
                .stream()
                .map(c -> c.toString())
                .reduce((a, b) -> a.concat(b)).get();

        System.out.println("\n\n=======================\nEmprestimos DO MES ATUAL: \n\n" +
                String.format("| %-20s | %-20s | %-14s | %-14s | %-35s |\n",
                        "CÓDIGO_EMPRESTIMO", "Data do emprestimo", "Data Inicial", "Data Final", "Livro")
                +
                emprestimosDoMes);
        // =========================================================================================

        // OUTROS RELATÓRIOS

        /*
         * System.out.
         * println("RELATORIO DE TODOS OS EMPRESTIMOS DE APENAS UM CLIENTE\n\n");
         * System.out.println(biblioteca.getCliente("JA20Z3").toString());
         * 
         * System.out.println("\n\nRELATORIO DE TODOS OS EMPRESTIMOS DA BIBLIOTECA\n\n"
         * );
         * System.out.println(biblioteca.getListaDeEmprestimosString());
         * 
         * System.out.println("\n\nLIVROS EMPRESTADOS\n\n");
         * System.out.println(biblioteca.getLivrosEmprestadosString());
         */
    }

}