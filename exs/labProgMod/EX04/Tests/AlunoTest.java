package Tests;

/*  Código desenvolvido por:
**
**    ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗     
**    ██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║     
**    ██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║     
**    ██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║     
**    ╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
**     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
**/

import src.Aluno;
import src.Turma;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class AlunoTest {
    
    Aluno aluno;
    @BeforeEach
    public void iniciarTeste(){
        aluno = new Aluno();
    }

    @Test
    public void verificaNomeDoAluno(){
        assertEquals("Batman", aluno.getNome());
    }

    @Nested
    class valoresDasAtividades{

        Aluno alunoComNotas;
        @BeforeEach
        public void iniciarBateriaDeTestesComNotas(){
            alunoComNotas = new Aluno();
            alunoComNotas.zerarNotas();
        }

        @Test
        public void verificaSomaDasNotas(){
            int[] arrayDeNotas =  {25,25,25,25};
            alunoComNotas.setNotasAtv(arrayDeNotas);
            assertEquals(100, alunoComNotas.getSomaDasNotas());
        }

        @Test
        public void verificaSomaDasNotasAltas(){
            int[] arrayDeNotas = {27,25,25,42} ;
            alunoComNotas.setNotasAtv(arrayDeNotas);
            assertEquals(0, alunoComNotas.getSomaDasNotas());
        }

        @Test
        public void verificaSomaDeNotasNegativas(){
            int[] arrayDeNotas = {-254,-56,-3,-25};
            alunoComNotas.setNotasAtv(arrayDeNotas);
            assertEquals(0, alunoComNotas.getSomaDasNotas());
        }

    }

    @Nested
    class testesDeFrequenciaEmAulas{

        Aluno alunoComFrequencia;
        
        @BeforeEach
        public void iniciarBateriaDeTestesComFrequencia(){
            alunoComFrequencia = new Aluno();
        }

        @Test
        public void testarFrequencia(){
            aluno.setFrequencia(100);
            assertEquals(100, aluno.getFrequencia());
        }

        @Test
        public void testarIncrementoDeFrequencia(){
            aluno.setFrequencia(10);
            aluno.darPresenca();
            assertEquals(11, aluno.getFrequencia());
        }

        @Test
        public void testeDeFrequenciaAcimaDoNormal(){
            aluno.setFrequencia(Turma.QUANTIDADE_DE_AULAS);
            aluno.darPresenca();
            assertEquals(Turma.QUANTIDADE_DE_AULAS, aluno.getFrequencia());
        }

        @Test
        public void testeDeFrequenciaAbaixoDoNormal(){
            aluno.setFrequencia(-1);
            assertEquals(0, aluno.getFrequencia());
        }

    }

}
