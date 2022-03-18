package src;

public class Aluno {
    private int[] atividades; 

    private String nome = "Batman";

    public Aluno(){
        this.atividades = new int[4];
    }
    public String getNome() {
        return this.nome;
    }

    public void setNotasAtv(int[] Atvs) {

        for (int i = 0 ; i < 4 ; i++) {
            if( Atvs[i] < 0 ){
                Atvs[i] = converterParaPositivo(Atvs[i]);
            }
        }

        if ( somaNotas(Atvs) <= 100 ){
            this.atividades = Atvs;

        }

    }

    public int getSomaDasNotas() {
        int soma = 0;
        for (int i = 0 ; i < 4 ; i++) {
            soma += this.atividades[i];
        }
        return soma;
    }

    public int somaNotas(int[] arrayDeNotas) {
        int soma = 0;
        for (int i = 0 ; i < 4 ; i++) {
            soma += arrayDeNotas[i];
        }
        return soma;
    }

    public void zerarNotas() {
        for (int i = 0 ; i < 4 ; i++) {
            atividades[i] = 0;
        }
        
    }

    private static int converterParaPositivo(int num){
        return num += - ( num *2 );
    }

}