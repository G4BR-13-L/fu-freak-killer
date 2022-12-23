package src.Turma;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import src.Aluno.Aluno;

public class TurmaEAD extends TurmaComNota {
    
    
    public TurmaEAD(String codigo, int qtdAtividades){
        super(codigo, qtdAtividades);
    }
    /**
     * Adiciona aluno a lista de alunos
     * @param novato
     */
    protected void addAluno(Aluno novato) {
       this.getAlunos().add(novato);
    }

    /**
     * Retorna a instancia de aluno com melhor desempenho
     * @return Objeto Aluno
     */
    @Override
    public Aluno alunoDeMelhorDesempenho() {
        Aluno melhorDesempenho = this.getAluno(0);
        for (int i = 1; i < this.getQuantidadeAlunos(); i++) {
            Aluno aux = this.getAluno(i);
            if (aux.getSomaDasNotas() > melhorDesempenho.getSomaDasNotas()) {
                melhorDesempenho = aux;
            }
        }
        return melhorDesempenho;
    }


    /**
     * Retorna uma string que diz se o aluno está aprovado
     * ou reprovado
     * 
     * @return APROVADO | REPROVADO
     */
    private static String getSituacaoDoAluno(Aluno a) {
        if (a.getSomaDasNotas() >= 60) {
            return "APROVADO";
        }
        return "REPROVADO";
    }
    /**
     * Retorna o relatório da turma em String
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
