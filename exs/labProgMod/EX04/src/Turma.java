package src;

public class Turma {

    public static final int QUANTIDADE_DE_ATIVIDADES = 4;
    public static final int PONTUACAO_TOTAL = 100;
    public static final int QUANTIDADE_DE_AULAS = 100;
    public static final int QUANTIDADE_DE_ALUNOS = 20;

    private int[] atividades;
    private Aluno[] alunos;
    private int[] codigoDaTurma;

    public static boolean validarCodigo(int[] codigoDaTurma) {

        if (codigoDaTurma.length == 3 &&
                (codigoDaTurma[0] >= 1 && codigoDaTurma[0] <= 8) &&
                (codigoDaTurma[1] >= 2 && codigoDaTurma[0] <= 6) &&
                (codigoDaTurma[2] >= 1 && codigoDaTurma[2] <= 3)) {
            return true;

        }
        return false;

    }

    public Turma(int[] codigoDaTurma) {
        this.atividades = new int[QUANTIDADE_DE_ATIVIDADES];
        this.alunos = new Aluno[QUANTIDADE_DE_ALUNOS];
        this.setCodigoDaTurma(codigoDaTurma);

    }

    public void setCodigoDaTurma(int[] dadosParaOCodigo){
        if (validarCodigo(dadosParaOCodigo)) {
            this.codigoDaTurma = dadosParaOCodigo;
        }else{
            this.codigoDaTurma[0] = 0;
            this.codigoDaTurma[1] = 0;
            this.codigoDaTurma[2] = 0;
        }
    }
    public int[] getCodigoDaTurma() {
        return this.codigoDaTurma;
    }

    public Turma(int i, int j, int k) {
    }

    public Object getQuantidadeAlunos() {
        return 20;
    }

}