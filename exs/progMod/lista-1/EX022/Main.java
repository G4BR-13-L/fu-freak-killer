
import src.*;
public class Main {
    public static void main(String[] args) {
      
        print("\nCriando instancia padrão da classe pessoa\n");
        Pessoa pessoa1 = new Pessoa();
        print("====Pessoa====\n"+
        "CPF: "+pessoa1.getCpf()+
        "\nNome: "+pessoa1.getNome()+
        "\nIdade: "+pessoa1.getIdade()+
        "\nSexo: "+ pessoa1.getSexo()+
        "\nMaior De Idade: "+pessoa1.isMaiorDeIdade());

        print("\n\nCriando instancia Customizada da classe pessoa\n");
        Pessoa pessoa2 = new Pessoa(2002, "Gabriel", "123.456.789-10", "Masculino");
        print("====Pessoa====\n"+
        "CPF: "+pessoa2.getCpf()+
        "\nNome: "+pessoa2.getNome()+
        "\nIdade: "+pessoa2.getIdade()+
        "\nSexo: "+ pessoa2.getSexo()+
        "\nMaior De Idade: "+pessoa2.isMaiorDeIdade());
    }

    public static void print(String x){
        System.out.println(x);
    }
}
