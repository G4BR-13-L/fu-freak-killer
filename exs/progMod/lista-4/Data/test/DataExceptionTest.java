package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import src.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDateTime;

public class DataExceptionTest {

    Data data;

    @BeforeEach
    public void iniciarTestes() throws ExcecaoDataInvalida {
        data = new Data();
    }

    @Nested
    class TesteDeExcecaoEmDataInvalida{

        void testDiaNegativo() {
            assertThrows(ExcecaoDataInvalida.class, () -> {data.adicionarDias(-50);});
        }
        
    }

}
