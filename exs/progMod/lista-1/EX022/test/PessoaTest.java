package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import src.Pessoa;

import java.time.LocalDateTime;

public class PessoaTest {

    Pessoa pessoa;

    @BeforeEach
    public void iniciarTestes() {
        pessoa = new Pessoa();
    }

    @Nested
    class TestarValoresPadraoDoConstrutor {
        @Test
        public void validarCPFpadrao() {
            assertEquals("000.000.000-00", pessoa.getCpf());
        }

        @Test
        public void validarNome() {
            assertEquals("sem-nome", pessoa.getNome());
        }

        @Test
        public void validarSexo() {
            assertEquals("indefinido", pessoa.getSexo());
        }

        @Test
        public void validarIdadePadrao() {
            assertEquals(0, pessoa.getIdade());
        }
    }

    @Nested
    class construtorComValoresEspecificados {

        @BeforeEach
        public void iniciarTestes() {
            pessoa = new Pessoa(2002, "Gabriel", "123.456.789-10", "Masculino");
        }

        @Test
        public void validarCPFpadrao() {
            assertEquals("123.456.789-10", pessoa.getCpf());
        }

        @Test
        public void validarNome() {
            assertEquals("Gabriel", pessoa.getNome());
        }

        @Test
        public void validarSexo() {
            assertEquals("Masculino", pessoa.getSexo());
        }

        @Test
        public void validarIdadePadrao() {
            LocalDateTime dataAtual = LocalDateTime.now();
            int ano = dataAtual.getYear();

            assertEquals(ano - 2002, pessoa.getIdade());
        }
    }
}