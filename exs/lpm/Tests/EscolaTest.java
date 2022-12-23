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

import src.Escola;
import src.Turma.TurmaPresencial;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class EscolaTest {
    Escola escola;

    @BeforeEach
    public void iniciarTeste(){
        escola = new Escola();
    }

    @Nested
    class testesComTurmas{

        @BeforeEach
        public void setup(){
            escola.criarTurma("641");
        }

        @Test
        public void verificaQuantidadeDeTurmas(){
            assertEquals(1, escola.getQuantidadeDeTurmas());
        } 
        @Test
        public void adicionarNovaTurma(){
            escola.criarTurma("142");
            assertEquals(2, escola.getQuantidadeDeTurmas());
        }
    }
        
}
