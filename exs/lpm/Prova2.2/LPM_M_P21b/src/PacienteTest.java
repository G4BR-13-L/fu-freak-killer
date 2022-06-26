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
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Excecoes.ConsultaDataInvalida;

public class PacienteTest {

    Paciente pac;
    IPlanoDeSaude planoCompleto;
    IPlanoDeSaude planoCopart;

    @Nested
    class PlanoCopart {
        @BeforeEach
        public void init() {
            pac = new Paciente("Teste", "26/01/1972");
            planoCopart = new Coparticipacao();
        }
    
        @Test
        @Order(1)
        public void valorConsultaNeuroCoparticipacao() {
            Consulta c = new Agendada(LocalDate.now(), Especialidade.NEUROLOGIA);
            pac.adicionarPlano(planoCopart);
            pac.addConsulta(c);
            assertEquals(120, c.valorPago, 0.1);
        }
    
        @Test
        @Order(2)
        public void valorMensalidadeCoparticipacao50Anos() {
            pac.adicionarPlano(planoCopart);
            assertEquals(172.5, pac.calcularMensalidade(), 0.1d);
        }
    }

    @Nested
    class PlanoCompleto {
        @BeforeEach
        public void init() {
            pac = new Paciente("Teste", "26/01/1972");
            planoCompleto = new Completo();
        }
    
        @Test
        @Order(1)
        public void valorConsultaNeuroCompleto() {
            Consulta c = new Agendada(LocalDate.now(), Especialidade.NEUROLOGIA);
            pac.adicionarPlano(planoCompleto);
            pac.addConsulta(c);
            assertEquals(0, c.valorPago, 0.1);
        }
    
        @Test
        @Order(2)
        public void valorMensalidadeCompleto50Anos() {
            pac.adicionarPlano(planoCompleto);
            assertEquals(282.8, pac.calcularMensalidade(), 0.1d);
        }
    }
    @Nested
    class ConsultaRetorno {
        @BeforeEach
        public void init() {
            pac = new Paciente("Teste", "26/01/1972");
            planoCompleto = new Completo();
        }
    
        @Test
        @Order(1)
        public void dataConsultaRetorno() {
            Consulta c = new Agendada(LocalDate.now(), Especialidade.NEUROLOGIA);
            pac.adicionarPlano(planoCompleto);
            pac.addConsulta(c);

            
            Retorno r;
            try {
                r = new Retorno(LocalDate.now().plusDays(29), Especialidade.NEUROLOGIA, c);
                assertEquals(0, r.valorPago, 0.1);

            } catch (ConsultaDataInvalida e) {
                e.printStackTrace();
            }
            assertEquals(0, c.valorPago, 0.1);
        }
    
        @Test
        @Order(2)
        public void valorMensalidadeCompleto50Anos() {
            pac.adicionarPlano(planoCompleto);
            assertEquals(282.8, pac.calcularMensalidade(), 0.1d);
        }
    }


}
