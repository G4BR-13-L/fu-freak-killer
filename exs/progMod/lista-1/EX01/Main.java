import src.business.Data;

public class Main {
    public static void main(String[] args) {
        print( "- Instanciando objeto data" );
        print( "- O construtor sem parametros instancia o objeto com a data atual do sistema" );
        Data data = new Data();
        print("- Objeto data: "+data.getDataFormatada());

        print("Adicionando 31 dias a data...");
        data.adicionarDias(31);
        print("- Objeto data: "+data.getDataFormatada());
        
        print("========================================");
        print("Instanciando um objeto [data1] com uma data irreal: 43/16/2022");
        Data data1 = new Data( 43,16,2022 );
        print("- Objeto [data1]: "+data.getDataFormatada());

        print("- Dia da semana do objeto [data1]: "+ data1.diaDaSemana());
        print(data1.porExtenso());

    }

    public static void print(String x){
        System.out.println(x);
    }
}
