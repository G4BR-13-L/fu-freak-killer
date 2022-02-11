
/**
 * 
 * 1. Utilização 
 * 
 * Sendo assim, coloquei todo o programa dentro do metodo main.
 */

import java.util.Scanner;

public class Codigo_03 {
    public static void main(String[] args) {
        double valor = 0;
        Scanner leitorScanner = new Scanner(System.in);
        System.out.print("Digite uns numeros: \nDigite 0 para finalizar\n\n");
        int a = leitorScanner.nextInt();
        valor += a ;
        while (a != 0) {
            a = leitorScanner.nextInt();
            valor += a;
        }
        System.out.println("Resultado = " + valor);
        leitorScanner.close();
    }

}