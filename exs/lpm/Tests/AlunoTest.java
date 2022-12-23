package Tests;

import src.Aluno.Aluno;
import src.Turma.TurmaPresencial;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class AlunoTest {

    Aluno aluno;

    @BeforeEach
    public void iniciarTeste() {
        aluno = new Aluno("Fulana");
    }

    @Test
    public void verificaNomeDoAluno() {
        assertEquals("Fulana", aluno.getNome());
    }

    @Nested
    class valoresDasAtividades {

        Aluno alunoComNotas;

        @BeforeEach
        public void iniciarBateriaDeTestesComNotas() {
            alunoComNotas = new Aluno("Fulana");
            aluno.zerarNotas();
        }

        @Test
        public void verificaSomaDasNotas() {
            int[] arrayDeNotas = { 25, 25, 25, 25 };
            alunoComNotas.setNotasAtv(arrayDeNotas);
            assertEquals(100, alunoComNotas.getSomaDasNotas());
        }

        @Test
        public void verificaSomaDasNotasAltas() {
            int[] arrayDeNotas = { 27, 25, 25, 42 };
            alunoComNotas.setNotasAtv(arrayDeNotas);
            assertEquals(0, alunoComNotas.getSomaDasNotas());
        }

        
        @Test
        public void verificaSomaDeNotasNegativas() {
            int[] arrayDeNotas = { -254, -56, -3, -25 };
            alunoComNotas.setNotasAtv(arrayDeNotas);
            assertEquals(0, alunoComNotas.getSomaDasNotas());
        }
        @Test
        public void testarSituacaoDeAprovacaoDoAluno() {
            int[] arrayDeNotas = { 25, 25, 25, 25 };
            alunoComNotas.setNotasAtv(arrayDeNotas);
            alunoComNotas.setFrequencia(15);
            assertEquals("APROVADO", alunoComNotas.getSituacao());
        }

        @Test
        public void darNotaComValorPositivo(){
            alunoComNotas.darNota(3, 20);;
            assertEquals(20, alunoComNotas.getSomaDasNotas());
        }
        @Test
        public void darNotaComValorNegativo(){
            alunoComNotas.darNota(3, -20);;
            assertEquals(20, alunoComNotas.getSomaDasNotas());
        }

    }

    @Nested
    class testesDeFrequenciaEmAulas {

        Aluno alunoComFrequencia;

        @BeforeEach
        public void iniciarBateriaDeTestesComFrequencia() {
            alunoComFrequencia = new Aluno("Fulano");
        }

        @Test
        public void testarFrequencia() {
            aluno.setFrequencia(20);
            assertEquals(20, aluno.getFrequencia());
        }

        @Test
        public void testarIncrementoDeFrequencia() {
            aluno.setFrequencia(10);
            aluno.darPresenca();
            assertEquals(11, aluno.getFrequencia());
        }

        @Test
        public void testeDeFrequenciaAcimaDoNormal() {
            aluno.setFrequencia(TurmaPresencial.QUANTIDADE_DE_AULAS);
            aluno.darPresenca();
            assertEquals(TurmaPresencial.QUANTIDADE_DE_AULAS, aluno.getFrequencia());
        }

        @Test
        public void testeDeFrequenciaAbaixoDoNormal() {
            aluno.setFrequencia(-1);
            assertEquals(0, aluno.getFrequencia());
        }

    }

    @Test
    public void testeDeDesempenho(){
        int[] arrayDeNotas = {20,19,15,22};
        aluno.setNotasAtv(arrayDeNotas);
        aluno.setFrequencia(18);
        assertEquals(64.0, aluno.getDesempenho());
    }
}
