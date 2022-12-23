package src.Turma;

import java.util.Collections;
import java.util.Comparator;

import src.Aluno.Aluno;

public class CursoLivre extends Turma{
    
    private int qtdMateriais;

    public CursoLivre(String codigo, int qtdMateriais){
        super(codigo);
        this.setQtdMateriais(qtdMateriais);
    }

    private void setQtdMateriais(int qtdMateriais2) {
        this.qtdMateriais = qtdMateriais2;
    }

    @Override
    public int getQuantidadeDeAtividades() {
        return this.qtdMateriais;
    }

    @Override
    protected void addAluno(Aluno novato) {
        this.getAlunos().add(novato);
    }

    @Override
    public String getRelatorio() {
        Collections.sort(this.getAlunos(), new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return a1.getNome().compareTo(a2.getNome());
            }
        });
        String relatorio = "RELATORIO DE AlUNOS\n------------------------------\n";
        relatorio += "Matricula  | Nome                      | Conteudos Asistidos |\n";
        for (int i = 0; i < this.getQuantidadeAlunos(); i++) {
            Aluno alunoTemp = this.getAluno(i);
            relatorio += String.format("%-10s | %-25s | %-21s |\n", 
            alunoTemp.getMatricula(), 
            alunoTemp.getNome(), 
            alunoTemp.getFrequencia()+"/"+this.getQuantidadeDeAtividades());
            
        }
        return relatorio;
    }
}
