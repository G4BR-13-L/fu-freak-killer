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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Turma {

    public static final int QUANTIDADE_DE_ATIVIDADES = 4;
    public static final int PONTUACAO_TOTAL = 100;
    public static final int QUANTIDADE_DE_AULAS = 20;
    public static final int QUANTIDADE_DE_ALUNOS = 20;

    private LinkedList<Aluno> alunos = new LinkedList<>();
    private int[] atividades;
    private int[] codigoDaTurma;

    /* ================== CONSTRUTOR ==================== */
    public Turma(int[] codigoDaTurma) {
        this.atividades = new int[QUANTIDADE_DE_ATIVIDADES];
        this.setCodigoDaTurma(codigoDaTurma);

    }
    
    public Turma(int i, int j, int k) {
        int[] codigo = { i, j, k };
        this.atividades = new int[QUANTIDADE_DE_ATIVIDADES];
        this.setCodigoDaTurma(codigo);
    }
    /* ================== UTILITÁRIOS==================== */

    /**
     * Valida um código de turma passado em um array por
     * parametro
     * @param codigoDaTurma
     * @return
     */
    public static boolean validarCodigo(int[] codigoDaTurma) {
        if (codigoDaTurma.length == 3 &&
                (codigoDaTurma[0] >= 1 && codigoDaTurma[0] <= 8) &&
                (codigoDaTurma[1] >= 2 && codigoDaTurma[1] <= 6) &&
                (codigoDaTurma[2] >= 1 && codigoDaTurma[2] <= 3)) {
            return true;

        }
        return false;

    }

    /**
     * Instancia um novo aluno
     * @param nomeNovato nome do novo aluno
     */
    public void matricular(String nomeNovato) {
        Aluno novato = new Aluno(nomeNovato);
        this.addAluno(novato);
    }

    /**
     * Adiciona aluno a lista de alunos
     * @param novato
     */
    private void addAluno(Aluno novato) {
        if (alunos.size() < 20) {
            alunos.add(novato);
        }
    }

    /* ================== GETTERS ==================== */
    /**
     * Retorna o código da turma em um array
     * @return array[]3 int
     */
    public int[] getCodigoDaTurma() {
        return this.codigoDaTurma;
    }

    /**
     * Retorna o codigo em String
     * @return String de comprimento 3
     */
    public String getStringCodigoDaTurma() {
        return "" + this.codigoDaTurma[0] + this.codigoDaTurma[1] + this.codigoDaTurma[2] + "";
    }

    /**
     * 
     * @return
     */
    public Object getQuantidadeAlunos() {
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
     * Retorna a média das notas do aluno
     * @return
     */
    public double getMediaDeNotas() {
        int soma = 0;
        for (int i = 0; i < alunos.size(); i++) {
            soma += alunos.get(i).getSomaDasNotas();
        }
        return Double.parseDouble(String.format("%.1f", (double) soma / alunos.size()).replace(',', '.'));
    }

    /**
     * Retorna a média das frequencias
     * de todos os alunos matriculados na turma
     * @return
     */
    public double getMediaDeFrequencia() {
        int soma = 0;
        for (int i = 0; i < alunos.size(); i++) {
            soma += alunos.get(i).getFrequencia();
        }
        return Double.parseDouble(String.format("%.1f", (double) soma / alunos.size()).replace(',', '.'));
    }

    /**
     * Retorna a instancia de aluno com melhor desempenho
     * @return Objeto Aluno
     */
    public Aluno alunoDeMelhorDesempenho() {
        Aluno melhorDesempenho = alunos.get(0);
        for (int i = 1; i < alunos.size(); i++) {
            Aluno aux = alunos.get(i);
            if (aux.getDesempenho() > melhorDesempenho.getDesempenho()) {
                melhorDesempenho = aux;
            }
        }
        return melhorDesempenho;
    }

    /* ================== SETTERS ==================== */
    /**
     * 
     * Define o código da turma
     * @param dadosParaOCodigo Array de int
     */
    public void setCodigoDaTurma(int[] dadosParaOCodigo) {
        if (validarCodigo(dadosParaOCodigo)) {
            this.codigoDaTurma = dadosParaOCodigo;
        } else {
            this.codigoDaTurma[0] = 0;
            this.codigoDaTurma[1] = 0;
            this.codigoDaTurma[2] = 0;
        }
    }
    /* ================== STRING E RELATÓRIOS ==================== */

    /**
     * Retorna o relatório da turma em String
     * @return String relatório
     */
    public String getRelatorio() {
        Collections.sort(alunos, new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return a1.getNome().compareTo(a2.getNome());
            }
        });
        String relatorio = "RELATORIO DE AlUNOS\n------------------------------\n";
        relatorio += "Matricula  | Nome                      | Nota | Situação  |\n";
        for (int i = 0; i < alunos.size(); i++) {
            relatorio += alunos.get(i).relatorio();
        }
        return relatorio;
    }






}