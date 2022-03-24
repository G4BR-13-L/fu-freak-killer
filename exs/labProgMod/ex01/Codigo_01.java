/**
 * MELHORIAS NO CÓDIGO
 * 
 * 1. Variaveis vt e b inicializadas com zero na classe
 * 2. Criação de um loop para a soma do vetor vendas[]
 * 3. Reomoção de condicional desnecessaria if do meio
 * 4. remoção do ultimo if condicional, deixando somente o else
 * 5. Declaração de todas as variaveis em uma unica linha
 * 
 */
import java.io.*;
class Contabilidade {
    int vendas[] = { 2000, 4000, 6000, 8000, 1000, 1200, 1400, 1600, 180, 2000, 2200, 2300 };
    public double bonus() {
        double vt = 0, b = 0;
        for (int i = 0 ; i < vendas.length ; i++) {
            vt += vendas[i];
        }
        if (vt >= 24000 && vt < 36000)
            b = 0.1;
        else if (vt < 50000)
            b = 0.2;
        else
            b = 0.35;
        return vt * b;
    }
}

public class Codigo_01 {
    public static void main(String[] args) {

        Contabilidade auditoria = new Contabilidade();
        System.out.println(auditoria.bonus());
    }
}
