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

// ==========================================================
// APP MAIN
// ==========================================================
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {

        int min_val = 1;
        int max_val = 120;
        ThreadLocalRandom tlr = ThreadLocalRandom.current();

        ListaDeFiguras lista = new ListaDeFiguras();

        for (int i = 0; i < 2; i++) {
            lista.figuras.add(new Quadrado(tlr.nextInt(min_val, max_val + 1)));
        }
        for (int i = 0; i < 2; i++) {
            lista.figuras.add(new Circulo(tlr.nextInt(min_val, max_val + 1)));
        }

        lista.calcularAreaTotal();
        System.out.println(lista.quadradosQueTemAAreaSuperiorAMediaDasAreasDosCrculos());
        lista.CirculosRaioSuperior(10).stream().forEach(System.out::println);
    }
}


// ==========================================================
// LISTA DE FIGURAS
// ==========================================================
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListaDeFiguras {
    
    public  List<Figura> figuras = new ArrayList<Figura>();


    // Um método para calcular a área total de todas as figuras da lista.
    public void calcularAreaTotal(){
        this.figuras.stream()
        .map(fig -> fig.area())
        .forEach(System.out::println);
    }

    // Um método que retorne quantos quadrados tem a área superior à média das áreas dos círculos.

    public double quadradosQueTemAAreaSuperiorAMediaDasAreasDosCrculos(){

        double mediaAreaCirculos = this.figuras.stream()
        .filter(fig -> fig instanceof Circulo)
        .mapToDouble(fig -> fig.area())
        .average()
        .getAsDouble();

        return this.figuras.stream()
        .filter(fig -> fig instanceof Quadrado )
        .filter(quad -> quad.area() > mediaAreaCirculos)
        .count();
    }


    // Um método que retorne a lista de Círculos cujo raio seja superior a um valor passado como parâmetro.

    public List<Figura> CirculosRaioSuperior(double raio){
        return this.figuras.stream()
        .filter(fig -> fig instanceof Circulo)
        .filter(circ -> ((Circulo) circ).getRaio() > raio)
        .collect(Collectors.toList());
    }



}

// ==========================================================
// CLASSE ABSTRATA DE FIGURA
// ==========================================================
public abstract class Figura{

    public abstract double area();

}

// ==========================================================
// CIRCULO
// ==========================================================
public class Circulo extends Figura{
    //atributo
    private double raio;

    public Circulo(double raio){
        this.raio = 1;
        if(raio>1)
            this.raio = raio;
    }

    @Override
    public double area(){
        return Math.PI * Math.pow(this.raio,2);
    }

    public double getRaio(){
        return this.raio;
    }
}

// ==========================================================
// QUADRADO
// ==========================================================
public class Quadrado extends Figura{
    
    private int lado;
    
    public Quadrado(int lado){
        this.lado = lado;
    }

    @Override
    public final double area(){
        return Math.pow(lado, 2);
    }
}
