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
