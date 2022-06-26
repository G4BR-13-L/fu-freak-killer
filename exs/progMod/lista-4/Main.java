import src.Data;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();

        try {
            data.adicionarDias(-30);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
