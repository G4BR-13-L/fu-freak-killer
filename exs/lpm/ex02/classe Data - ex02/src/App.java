
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Data data = new Data();
        Data data2 = new Data(31,12,5022);

        
        data.adicionarDias(50000);
        System.out.println("Data Atual: "+data.informarData());
        
        
        System.out.println(Data.qualDataMaisFutura(data, data2).informarData());
    }
}
