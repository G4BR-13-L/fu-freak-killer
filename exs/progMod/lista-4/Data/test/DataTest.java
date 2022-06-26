package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import src.*;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

public class DataTest {

    Data data;

    @BeforeEach
    public void iniciarTestes() {
        data = new Data();
    }

    @Nested
    class verificarInteligenciaDoContrutorComDatasInvalidas {

        @Test
        public void contrutorComDataAtual() {
            data = new Data();
            assertEquals(LocalDateTime.now().getDayOfMonth(), data.getDia());
            assertEquals(LocalDateTime.now().getMonthValue(), data.getMes());
            assertEquals(LocalDateTime.now().getYear(), data.getAno());
        }

        @Test
        public void contrutorComDiaReal() {
            data = new Data(23, 3, 2022);
            assertEquals(23, data.getDia());
            assertEquals(3, data.getMes());
            assertEquals(2022, data.getAno());
        }
        @Test
        public void testeDeFormatacao(){
            data = new Data(23, 3, 2022);
            assertEquals("23/3/2022", data.getDataFormatada());
        }
        @Test
        public void contrutorComDiaIrreal() {
            data = new Data(43, 12, 2022);
            assertEquals(12, data.getDia());
            assertEquals(1, data.getMes());
            assertEquals(2023, data.getAno());
        }

        @Test
        public void contrutorComMesEDiaIrreal() {
            data = new Data(43, 13, 2022);
            assertEquals(12, data.getDia());
            assertEquals(2, data.getMes());
            assertEquals(2023, data.getAno());
        }

        @Test
        public void construtorComDiaEMesIrreaisApenas(){
            data = new Data(43, 13);
            assertEquals(12, data.getDia());
            assertEquals(2, data.getMes());
            assertEquals(2023, data.getAno());
        }

        @Test
        public void construtorComDiaEMesIrreaisAindaMaisIrreais(){
            data = new Data(63, 14);
            assertEquals(4, data.getDia());
            assertEquals(4, data.getMes());
            assertEquals(2023, data.getAno());
        }

        @Test
        public void construtorSomenteComDia(){
            data = new Data(2);
            assertEquals(2, data.getDia());
            assertEquals(LocalDateTime.now().getMonthValue(), data.getMes());
            assertEquals(LocalDateTime.now().getYear(), data.getAno());
        }
    }

    @Test
    public void testarInrementoDeData() throws ExcecaoDataInvalida {
        data = new Data(1, 2, 2022);
        data.adicionarDias(2);
        assertEquals(3, data.getDia());
    }

    @Test
    public void adicionarDiasNegativos() throws ExcecaoDataInvalida{
        data = new Data(1, 2, 2022);
        data.adicionarDias(-2);
        assertEquals(1, data.getDia());
    }

    class bateriasDeTesteComDatasPorExtenso{
        
        @Test
        public void testarDataPorExtenso(){
            data = new Data(43,12,2022);
            assertEquals("12 de Janeiro de 2023", data.porExtenso());
        }

        @Test
        public void testarDataPorExtensoIrreal(){
            data = new Data(63,14);
            assertEquals("4 de Abril de 2023", data.porExtenso());
        }
    }

    @Nested
    class testesComDiasDaSemana{

        @Test
        public void quinta(){
            data = new Data(24,03,2022);
            assertEquals("quinta-feira", data.diaDaSemana());
        }
        @Test
        public void sexta(){
            data = new Data(25,03,2022);
            assertEquals("sexta-feira", data.diaDaSemana());
        }
        @Test
        public void sabado(){
            data = new Data(4,6,2022);
            assertEquals("sábado", data.diaDaSemana());
        }
        @Test
        public void sabadoBisexto(){
            data = new Data(29,2,2020);
            assertEquals("sábado", data.diaDaSemana());
        }
    }
}
