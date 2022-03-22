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

import org.junit.jupiter.api.Test;

import src.Turma;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class TurmaTest {
    
    Turma turma;

    @BeforeEach
    public void iniciarTeste(){
        int[] codigoDaTurma = { 1,2,3 };
        turma = new Turma(codigoDaTurma);
    }

    @Test
    public void verificaCodigoDaTurma(){
        int[] codigoDaTurma = { 9,7,4 };
        turma.setCodigoDaTurma(codigoDaTurma);
        int[] arrayEsperado = { 0,0,0 };
        assertArrayEquals({0,0,0}, turma.getCodigoDaTurma());
    }

    
}
