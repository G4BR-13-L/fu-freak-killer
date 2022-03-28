package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import src.Pessoa;
import static org.junit.Assert.assertEquals;

public class PessoaTest {

    Pessoa pessoa;

    @BeforeEach
    public void iniciarTestes() {
        pessoa = new Pessoa(2002, "Gabriel", "123.456.789-10","Masculino");
    }

    @Nested
    class TestarValoresPadraoDoConstrutor{
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
}