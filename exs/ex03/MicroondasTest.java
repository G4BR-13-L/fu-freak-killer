// import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;

public class MicroondasTest{
    
    Microondas micro;

    @BeforeEach
    public void startTest(){
        micro = new Microondas();
    }

    @Test
    public void verificaTempoValido(){
        assertEquals(10, micro.getTemporizador());
    }

    



}