/**
 * 1. Modificado para retornar diretamente os estados de true ou false sem depender de uma variavel
 * 2.remoção de elses desnecessários. Porque ao fazer um retor a função deixa de ser executada, não importando qual passo viria em seguida no código
 * 3. Criação de uma ondicional unica para o programa
 */


public class Codigo_04 {
    public static void main(String[] args) {
        System.out.println(condicao(400));
    }
    public static boolean condicao(int n) {
        if (((n % 4 == 0) && !(n % 100 == 0)) || (n % 400 == 0 )){
            return true;
        }
        return false;
    }
}