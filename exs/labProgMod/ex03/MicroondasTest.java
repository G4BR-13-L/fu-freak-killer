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
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class MicroondasTest{
    
    Microondas micro;

    @BeforeEach
    public void startTest(){
        micro = new Microondas();
    }

    @Test
    public void testarAbrirPortaComMicroLigado(){
        micro.programarTemporizador(30);
        micro.ligar();
        micro.abrirPorta();
        assertEquals(false, micro.isPortaAberta());
    }
    @Test
    public void testarAbrirPortaComMicroDesligado(){
        micro.desligar();
        micro.abrirPorta();
        assertEquals(true, micro.isPortaAberta());
    }

    @Test
    public void testeDeAcionamentoLigarDePortaAberta(){
        micro.desligar();
        micro.abrirPorta();
        micro.ligar();
        assertEquals("Desligado", micro.getStatus());
    }
    @Test
    public void testarFecharPorta(){
        micro.fecharPorta();
        assertEquals(false, micro.isPortaAberta());
    }

    @Test
    public void testeDeAcionamentoPausar(){
        micro.programarTemporizador(10);
        micro.ligar();
        micro.pausar();
        assertEquals("Pausado", micro.getStatus());
    }

    @Test
    public void pausarSemTemporizadorConfigurado(){
        micro.desligar();
        micro.pausar();
        assertEquals("Desligado", micro.getStatus());
    }

    @Test
    public void abrirPortaComMicroondasPausado(){
        micro.pausar();
        micro.abrirPorta();
        assertEquals(true, micro.isPortaAberta());
    }

    @Test
    public void testarReiniciarSemProgramacao(){
        micro.reiniciar();
        assertEquals("Desligado", micro.getStatus());
    }

    @Nested
    class programacaoDeTemporizador{

        @Test
        public void verificaTempoValidoEmSegundos(){
            micro.programarTemporizador(30);
            assertEquals(30, micro.getTemporizador());
        }
        
        @Test
        public void verificaTempoValidoEmMinutosESegundos(){
            micro.programarTemporizador(2,30);
            assertEquals(150, micro.getTemporizador());
        }
        @Test
        public void temporizadorComTempoNegativoEmSegundos(){
            micro.programarTemporizador(-30);
            assertEquals(30, micro.getTemporizador());
        }
        @Test
        public void temporizadorComTempoNegativoEmMinutosESegundos(){
            micro.programarTemporizador(-2, -30);
            assertEquals(150, micro.getTemporizador());
        }
    }
    @Test
    public void verificarDesligamento(){
        micro.desligar();
        assertEquals("Desligado", micro.getStatus());
    }

    
    @Nested
    class verificarPassagemValidaDeTempo{
        @BeforeEach
        void resetarTempo(){
            micro.desligar();
            micro.programarTemporizador(2, 90);
            micro.fecharPorta();
            micro.ligar();
        }

        @Test
        void passarTempoComMicroPausado(){
            micro.pausar();
            micro.passarTempo(15);
            assertEquals("Pausado", micro.getStatus());
            assertEquals("03:30", micro.getContagemAtual());
        }
        @Test
        void testarPassagemDeTempo(){
            micro.passarTempo(13);
            assertEquals("03:17", micro.getContagemAtual());
        }

        @Test
        void temposLongos(){
            
            micro.passarTempo(50000);
            assertEquals("00:00", micro.getContagemAtual());
        }
        @Test
        void temposCurtos(){
            
            micro.passarTempo(5);
            assertEquals("03:25", micro.getContagemAtual());
        }
        @Test
        void temposNegativos(){
            micro.passarTempo(-30);
            assertEquals("03:00", micro.getContagemAtual());
        }
    }


    



}