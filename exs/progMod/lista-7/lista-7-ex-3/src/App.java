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
