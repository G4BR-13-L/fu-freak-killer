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