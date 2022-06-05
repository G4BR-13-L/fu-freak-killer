package src.Aluno;
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

import src.Turma.TurmaPresencial;

public class Aluno {
    private static int QUANTIDADE_DE_ALUNOS = 0;
    private int[] atividades;
    private int frequencia;
    private int matricula;
    private String nome;

    /*============== CONSTRUTOR ==============*/
    public Aluno(String nome, int qtdAtividades) {
        this.atividades = new int[qtdAtividades];
        this.nome = nome;
        this.gerarNumeroDeMatricula();
    }

    public Aluno(String nome) {
        this.nome = nome;
        this.gerarNumeroDeMatricula();
    }


    /*============= UTILITÁRIOS =============*/

    /**
     * Gera o numero de matrícula com base no contexto estático
     * da classe Aluno
     */
    private void gerarNumeroDeMatricula() {
        incrementarQuantidadeDeAlunos();
        this.matricula = Aluno.QUANTIDADE_DE_ALUNOS;
    }

    /**
     * Incrementa a quantidade de alunos no contexto
     */
    private void incrementarQuantidadeDeAlunos() {
        Aluno.QUANTIDADE_DE_ALUNOS++;
    }

    /**
     * Define uma nota para uma atividade específica 
     * do aluno
     * @param ativdade
     * @param valor
     */
    public void darNota(int ativdade, int valor) {
        valor = converterParaPositivo(valor);
        if (ativdade < TurmaPresencial.QUANTIDADE_DE_ATIVIDADES && validarNota(valor)) {
            this.atividades[ativdade] = valor;
        }
    }

    /**
     * Converte notas e frequencias para positivo
     * @param num
     * @return
     */
    private static int converterParaPositivo(int num) {
        if (num < 0) {
            return num += -(num * 2);
        }
        return num;
    }

    /**
     * Verifica se a nota está de acordo com a pontuação
     * prevista para cada atividade
     * @param nota
     * @return
     */
    private static boolean validarNota(int nota) {
        return nota >= 0 && nota <= TurmaPresencial.PONTUACAO_TOTAL / TurmaPresencial.QUANTIDADE_DE_ATIVIDADES;
    }

    /**
     * Utilitário para somar um array de notas 
     * e retornar o valor
     * @param arrayDeNotas
     * @return
     */
    public int somaNotas(int[] arrayDeNotas) {
        int soma = 0;
        for (int i = 0; i < TurmaPresencial.QUANTIDADE_DE_ATIVIDADES; i++) {
            soma += arrayDeNotas[i];
        }
        return soma;
    }

    /**
     * Retorna a soma das notas do proprio aluno
     * @return soma total da nota
     */
    public int somaNotas() {
        int soma = 0;
        for (int i = 0; i < TurmaPresencial.QUANTIDADE_DE_ATIVIDADES; i++) {
            soma += this.atividades[i];
        }
        return soma;
    }

    /**
     * Utilitário para zerar todas as notas do aluno
     */
    public void zerarNotas() {
        for (int i = 0; i < TurmaPresencial.QUANTIDADE_DE_ATIVIDADES; i++) {
            atividades[i] = 0;
        }

    }

    /**
     * Incrementa a presença / frequencia do aluno
     */
    public void darPresenca() {
        if (this.frequencia < TurmaPresencial.QUANTIDADE_DE_AULAS) {
            this.frequencia++;
        }
    }
    /**
     * Incrementa a presença / frequencia do aluno
     */
    public void conteudoAssistido(int c) {
            this.frequencia += c;
    }
    public void conteudoAssistido() {
        this.conteudoAssistido(1);
    }


    /*============= SETTERS ============= */

    /**
     * Define todas as quatro notas do semestre por 
     * um array de valores
     * @param Atvs array de valores inteiros válidos
     */
    public void setNotasAtv(int[] Atvs) {
        for (int i = 0; i < TurmaPresencial.QUANTIDADE_DE_ATIVIDADES; i++) {
            Atvs[i] = converterParaPositivo(Atvs[i]);
        }
        if (somaNotas(Atvs) <= TurmaPresencial.PONTUACAO_TOTAL) {
            this.atividades = Atvs;
        }
    }

    /**
     * Define a frequencia do aluno
     * @param frequencia
     */
    public void setFrequencia(int frequencia) {
        if (frequencia >= 0 && frequencia <= TurmaPresencial.QUANTIDADE_DE_AULAS) {
            this.frequencia = frequencia;
        }
    }

    /* ============= GETTERS ============= */
    
    

    /**
     * Retorna o nome do aluno
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna a frequencia
     * @return valor inteiro
     */
    public int getFrequencia() {
        return this.frequencia;
    }

    /**
     * Retorna a matricula
     * @return matricula em string
     */
    public String getMatricula() {
        return ""+this.matricula;
    }

    /**
     * Retiorna a soma das notas do aluno
     * @return
     */
    public int getSomaDasNotas() {
        int soma = 0;
        for (int i = 0; i < TurmaPresencial.QUANTIDADE_DE_ATIVIDADES; i++) {
            soma += this.atividades[i];
        }
        return soma;
    }

    /* ================ String e relatórios ===================*/

    /**
     * Retorna uma string que descreve 
     * o estado obejto aluno
     */
    @Override
    public String toString() {
        return "Nome: "+this.getNome()+
        "\nMatricula: "+this.getMatricula();
    }
}