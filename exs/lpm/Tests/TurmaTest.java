package Tests;

/*  Código desenvolvido por:
**
**    ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗     
**    ██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║     
**    ██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║     
**    ██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║     
**    ╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
**     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
**    PUC MINAS - 2022
**    ENGENHARIA DE SOFTWARE - LABORATÓRIO DE PROGRAMAÇÃO MODULAR
**    Gabriel Victor Couto Martins de Paula
**/

import org.junit.jupiter.api.Test;

import src.Turma.CursoLivre;
import src.Turma.TurmaEAD;
import src.Turma.TurmaPresencial;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class TurmaTest {
    
    TurmaPresencial turmaP;
    TurmaEAD turmaE;
    CursoLivre turmaL;

    @BeforeEach
    public void iniciarTeste(){
        String codigoDaTurma = "E123";
        turmaP = new TurmaPresencial("P123");
        turmaE = new TurmaEAD("E142");
        turmaL = new CursoLivre(codigoDaTurma);
    }

    @Test
    public void verificaCodigoDaTurma(){
        String codigoDaTurma = "947";
        turma.setCodigoDaTurma(codigoDaTurma);
        String arrayEsperado = "000";
        assertArrayEquals("000", turma.getCodigoDaTurma());
    }
    @Nested
    class testarListaDeAlunos{
    
        @Test
        public void testarQuantidadeDeAlunos(){
            assertEquals(0, turma.getQuantidadeAlunos());
            turma.matricular("Gabriel");
            assertEquals(1, turma.getQuantidadeAlunos());

        }
    }

    @Test
    public void testeDeMatricula(){
        turma.matricular("Fulano");
        assertEquals("Fulano", turma.getAluno(0).getNome());
    }

    @Test 
    public void testarAcessoAAlunoEspecífico(){
        turma.matricular("Joseph Joestar");
        turma.getAluno(0).darNota(0,20);
        assertEquals("Joseph Joestar", turma.getAluno(0).getNome() );
        assertEquals(20, turma.getAluno(0).getSomaDasNotas() );

    }

    @Nested
    class testesComRelatoriosDeMedia{
        @BeforeEach
        public void setup(){
            turma = new TurmaPresencial(3,4,2);
            int[][] matrizDeNotas = {
                {8,4,9,12},
                {21,15,15,23},
                {15,13,24,9}
            };
            String[] nomes = {
                "Fulana",
                "Tomahawk",
                "Argent",
            };
            int[] presencaNasAulas = {
                20,15,14
            };
    
            for ( int i = 0; i < 3 ; i++){
                turma.matricular(nomes[i]);
                turma.getAluno(i).setFrequencia(presencaNasAulas[i]);
                for( int j = 0 ; j < 4 ; j++  ){
                    turma.getAluno(i).darNota(j, matrizDeNotas[i][j]);
                }
    
            }
        }

        @Test
        public void testarMediaDasNotas(){
            assertEquals(56.0, turma.getMediaDeNotas());
        }

        @Test
        public void testarMediaDasFrequencia(){
            assertEquals(16.3, turma.getMediaDeFrequencia());
        }

        @Test
        public void validarMelhorDesmpenho(){
            assertEquals("Nome: Tomahawk\nMatricula: 11\nAtividades: [ 21, 15, 15, 23 ]\nSituação: APROVADO", turma.alunoDeMelhorDesempenho().toString());
        }
    }
    
}
