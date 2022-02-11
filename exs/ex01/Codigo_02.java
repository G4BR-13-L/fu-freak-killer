
/**
 * 1. encurtamento da condicional inicial de OU com logica para separar numeros
 * pares de impares
 * 
 */
import java.io.*;

public class Codigo_02 {

    public static void main(String[] args) {
        int d = 35, m = 10, a = 400;

        System.out.println(metodo(d, m, a));
    }

    public static boolean metodo(int d, int m, int a) {

        int diasMes[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (((a % 4 == 0) && !(a % 100 == 0)) || (a % 400 == 0))
            diasMes[1] = 29;
        if( ( m >= 1 && m <= 12 ) && (d >= 1 && d <= diasMes[m - 1]) ){
                return true;
        }
        return false;

    }
}