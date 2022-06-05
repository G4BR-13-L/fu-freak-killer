package src.Turma;

/*  Código desenvolvido por:
**
**    ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗     
**    ██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║     
**    ██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║     
**    ██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║     
**    ╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
**     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
**    PUC MINAS - 2022
**    ENGENHARIA DE SOFTWARE - LABORATÓRIO DE PROGRAMAÇÃO MODULAR
**    Gabriel Victor Couto Martins de Paula
**/
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import src.Aluno.Aluno;

public class TurmaPresencial extends TurmaComNota {

    public static final int PONTUACAO_TOTAL = 100;
    public static final int QUANTIDADE_DE_AULAS = 20;
    public static final int QUANTIDADE_DE_ALUNOS = 20;

    public TurmaPresencial(String codigo, int qtdAtividades) {
        super(codigo, qtdAtividades);
    }

    @Override
    public void matricular(String nomeNovato) {
        Aluno novato = new Aluno(nomeNovato, this.getQuantidadeDeAtividades());
        this.addAluno(novato);
    }

    /**
     * Adiciona aluno a lista de alunos
     * 
     * @param novato
     */
    protected void addAluno(Aluno novato) {
        if (this.getQuantidadeAlunos() < 20) {
            this.getAlunos().add(novato);
        }
    }

    /**
     * Retorna a instancia de aluno com melhor desempenho
     * 
     * @return Objeto Aluno
     */
    @Override
    public Aluno alunoDeMelhorDesempenho() {
        Aluno melhorDesempenho = this.getAluno(0);
        for (int i = 1; i < this.getQuantidadeAlunos(); i++) {
            Aluno aux = this.getAluno(i);
            if (((aux.getSomaDasNotas() * 8) + (aux.getFrequencia() * 2))
                    / (2 + 8) > ((melhorDesempenho.getSomaDasNotas() * 8) + (melhorDesempenho.getFrequencia() * 2))
                            / (2 + 8)) {
                melhorDesempenho = aux;
            }
        }
        return melhorDesempenho;
    }

    /**
     * Retorna a média das frequencias
     * de todos os alunos matriculados na turma
     * 
     * @return
     */
    public double getMediaDeFrequencia() {
        int soma = 0;
        for (int i = 0; i < this.getQuantidadeAlunos(); i++) {
            soma += this.getAluno(i).getFrequencia();
        }
        return Double.parseDouble(String.format("%.1f", (double) soma / this.getQuantidadeAlunos()).replace(',', '.'));
    }

    /**
     * Retorna uma string que diz se o aluno está aprovado
     * ou reprovado
     * 
     * @return APROVADO | REPROVADO
     */
    private static String getSituacaoDoAluno(Aluno a) {
        if (a.getSomaDasNotas() >= 60 && a.getFrequencia() >= TurmaPresencial.QUANTIDADE_DE_AULAS * 0.75) {
            return "APROVADO";
        }
        return "REPROVADO";
    }

    /**
     * Retorna o relatório da turma em String
     * 
     * @return String relatório
     */
    public String getRelatorio() {

        Collections.sort(this.getAlunos(), new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return a1.getNome().compareTo(a2.getNome());
            }
        });
        String relatorio = "RELATORIO DE AlUNOS\n------------------------------\n";
        relatorio += "Matricula  | Nome                      | Nota | Situação  |\n";
        for (int i = 0; i < this.getQuantidadeAlunos(); i++) {
            Aluno alunoTemp = this.getAluno(i);
            relatorio += String.format("%-10s | %-25s | %-4d | %-9s |\n",
                    alunoTemp.getMatricula(),
                    alunoTemp.getNome(),
                    alunoTemp.getSomaDasNotas(),
                    getSituacaoDoAluno(alunoTemp));

        }
        return relatorio;
    }
}