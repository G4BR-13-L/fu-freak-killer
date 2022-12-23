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

import src.Aluno.Aluno;

public abstract class Turma {
    
    private LinkedList<Aluno> alunos = new LinkedList<>();
    private String codigoDaTurma;

    public Turma(String codigo) {
        this.setCodigoDaTurma(codigo);
    }
    
    /**
     * Valida um código de turma passado em um array por
     * parametro
     * @param codigoDaTurma
     * @return
     */
    public static boolean validarCodigo(String codigoDaTurma) {
        if (
            codigoDaTurma.length() == 4 && 
            (
                codigoDaTurma.charAt(0) == 'P' ||
                codigoDaTurma.charAt(1) == 'E' ||
                codigoDaTurma.charAt(2) == 'L'
            )
         ) {
            return true;

        }
        return false;

    }

    public abstract int getQuantidadeDeAtividades();
    public void matricular(String nomeNovato) {
        Aluno novato = new Aluno(nomeNovato, this.getQuantidadeDeAtividades());
        this.addAluno(novato);
    }
    

    /**
     * Adiciona aluno a lista de alunos
     * @param novato
     */
    protected abstract void addAluno(Aluno novato);
    /**
     * Retorna o código da turma em um array
     * @return array[]3 int
     */
    public String getCodigoDaTurma() {
        return this.codigoDaTurma;
    }
    /**
     * 
     * @return
     */
    public int getQuantidadeAlunos() {
        return alunos.size();
    }
    /**
     * Retorna uma instancia específica de aluno
     * @param i index do aluno na lista
     * @return Objeto aluno
     */
    public Aluno getAluno(int i) {
        return alunos.get(i);
    }

    /**
     * 
     * Define o código da turma
     * @param dadosParaOCodigo Array de int
     */
    public void setCodigoDaTurma(String codigo) {
        if (validarCodigo(codigo)) {
            this.codigoDaTurma = codigo;
        } else {
            this.codigoDaTurma = "X000";
        }
    }

    /**
     * Retorna o relatório da turma em String
     * @return String relatório
     */
    public abstract String getRelatorio(); 

    public LinkedList<Aluno> getAlunos() {
        return alunos;
    }
}