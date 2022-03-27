package src;
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
import src.Turma;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Escola {


    private LinkedList<Turma> turmas = new LinkedList<>();

    /**
     * Retorna a quantidade de turmas existentes na escola
     * @return
     */
    public int getQuantidadeDeTurmas() {
        return turmas.size();
    }

    /**
     * Cria uma nova turma com código obrigatorio passado
     * por parâmetro. Se o código estive incorreto, a turma 
     * é instanciada com o código 000
     * @param i
     * @param j
     * @param k
     */
    public void criarTurma(int i, int j, int k) {
        Turma novaTurma = new Turma(i,j,k);
        turmas.add(novaTurma);
        
    }


    /**
     * Adiciona uma turma no va a partir de 
     * uma instancia passada por parâmetro
     * @param novaTurma
     */
    public void adicionarTurma(Turma novaTurma){
            turmas.add(novaTurma);
        
    }

    /**
     * Gera um relatório da lista de turmas com
     * codigo, quantidade de alunos e o nome do aluno
     * de melhor desempenho
     * @return
     */
    public String relatorioListaDeTurmas(){
        
        String relatorio = "RELATORIO DE TURMAS\n------------------------------\n";
        relatorio += String.format("%-12s | %-20s | %-25s |\n", "CodTurma", "Quantidade Alunos", "Melhor Desempenho");
        if( !turmas.isEmpty() ){
            for( int i = 0 ; i < turmas.size() ; i++ ){
                Turma turmaAtual = turmas.get(i) ;
                relatorio += String.format("%-12s | %-20d | %-25s |\n", 
                turmaAtual.getStringCodigoDaTurma(), turmaAtual.getQuantidadeAlunos(), 
                turmaAtual.alunoDeMelhorDesempenho().getNome());
            }
        }
            
        return relatorio;
    }
    
}
