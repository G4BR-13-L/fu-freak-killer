package src.Turma;

import java.util.LinkedList;

import src.Aluno.Aluno;

public abstract class TurmaComNota extends Turma {

    private int qtdAtividades;
    public static final int QUANTIDADE_DE_ATIVIDADES = 4;

    public TurmaComNota(String codigo, int qtdAtividades) {
        super(codigo);
        this.setQtdAtividades(qtdAtividades);
    }

    public void setQtdAtividades(int qtdAtividades) {
        this.qtdAtividades = qtdAtividades;
    }

    public int getQuantidadeDeAtividades() {
        return QUANTIDADE_DE_ATIVIDADES;
    }

    /**
     * Retorna a média das notas do aluno
     * 
     * @return
     */
    public double getMediaDeNotas() {
        int soma = 0;
        for (int i = 0; i < this.getQuantidadeAlunos(); i++) {
            soma += this.getAluno(i).getSomaDasNotas();
        }
        return Double.parseDouble(String.format("%.1f", (double) soma / this.getQuantidadeAlunos()).replace(',', '.'));
    }

    public abstract Aluno alunoDeMelhorDesempenho();

}
