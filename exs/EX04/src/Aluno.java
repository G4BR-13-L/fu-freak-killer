package src;


public class Aluno {
    private int[] atividades; 
    private int frequencia;
    
    


    private String nome = "Batman";

    public Aluno(){
        this.atividades = new int[Turma.QUANTIDADE_DE_ATIVIDADES];
    }
    public String getNome() {
        return this.nome;
    }

    public void setNotasAtv(int[] Atvs) {

        for (int i = 0 ; i < Turma.QUANTIDADE_DE_ATIVIDADES ; i++) {
            if( Atvs[i] < 0 ){
                Atvs[i] = converterParaPositivo(Atvs[i]);
            }
        }

        if ( somaNotas(Atvs) <= Turma.PONTUACAO_TOTAL ){
            this.atividades = Atvs;
        }

    }

    public int getSomaDasNotas() {
        int soma = 0;
        for (int i = 0 ; i < Turma.QUANTIDADE_DE_ATIVIDADES ; i++) {
            soma += this.atividades[i];
        }
        return soma;
    }

    public int somaNotas(int[] arrayDeNotas) {
        int soma = 0;
        for (int i = 0 ; i < Turma.QUANTIDADE_DE_ATIVIDADES ; i++) {
            soma += arrayDeNotas[i];
        }
        return soma;
    }

    public void zerarNotas() {
        for (int i = 0 ; i < Turma.QUANTIDADE_DE_ATIVIDADES ; i++) {
            atividades[i] = 0;
        }
        
    }

    private static int converterParaPositivo(int num){
        return num += - ( num *2 );
    }
    public void setFrequencia(int frequencia) {
        if ( frequencia >= 0 && frequencia <= Turma.QUANTIDADE_DE_AULAS){
            this.frequencia = frequencia;
        }
    }
    public int getFrequencia() {
        return this.frequencia;
    }
    public void darPresenca() {
        if( this.frequencia < Turma.QUANTIDADE_DE_AULAS ){
            this.frequencia++;
        }
    }

}