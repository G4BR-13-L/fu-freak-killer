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


public class Aluno {
    private static int QUANTIDADE_DE_ALUNOS = 0;
    private int[] atividades;
    private int frequencia;
    private int matricula;
    private String nome;

    /*============== CONSTRUTOR ==============*/
    public Aluno(String nome) {
        this.atividades = new int[Turma.QUANTIDADE_DE_ATIVIDADES];
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
        if (ativdade < Turma.QUANTIDADE_DE_ATIVIDADES && validarNota(valor)) {
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
        return nota >= 0 && nota <= Turma.PONTUACAO_TOTAL / Turma.QUANTIDADE_DE_ATIVIDADES;
    }

    /**
     * Utilitário para somar um array de notas 
     * e retornar o valor
     * @param arrayDeNotas
     * @return
     */
    public int somaNotas(int[] arrayDeNotas) {
        int soma = 0;
        for (int i = 0; i < Turma.QUANTIDADE_DE_ATIVIDADES; i++) {
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
        for (int i = 0; i < Turma.QUANTIDADE_DE_ATIVIDADES; i++) {
            soma += this.atividades[i];
        }
        return soma;
    }

    /**
     * Utilitário para zerar todas as notas do aluno
     */
    public void zerarNotas() {
        for (int i = 0; i < Turma.QUANTIDADE_DE_ATIVIDADES; i++) {
            atividades[i] = 0;
        }

    }

    /**
     * Incrementa a presença / frequencia do aluno
     */
    public void darPresenca() {
        if (this.frequencia < Turma.QUANTIDADE_DE_AULAS) {
            this.frequencia++;
        }
    }


    /*============= SETTERS ============= */

    /**
     * Define todas as quatro notas do semestre por 
     * um array de valores
     * @param Atvs array de valores inteiros válidos
     */
    public void setNotasAtv(int[] Atvs) {
        for (int i = 0; i < Turma.QUANTIDADE_DE_ATIVIDADES; i++) {
            Atvs[i] = converterParaPositivo(Atvs[i]);
        }
        if (somaNotas(Atvs) <= Turma.PONTUACAO_TOTAL) {
            this.atividades = Atvs;
        }
    }

    /**
     * Define a frequencia do aluno
     * @param frequencia
     */
    public void setFrequencia(int frequencia) {
        if (frequencia >= 0 && frequencia <= Turma.QUANTIDADE_DE_AULAS) {
            this.frequencia = frequencia;
        }
    }

    /* ============= GETTERS ============= */

    /**
     * Retorna o valor do desempenho do aluno
     * que na verdade é a média ponderada entre 
     * a nota e a frequencia
     * @return
     */
    public double getDesempenho() {
        return ((this.getSomaDasNotas() * 8) + (this.getFrequencia() * 2)) / (2+8);
    }
    
    /**
     * Retorna uma string que diz se o aluno está aprovado 
     * ou reprovado
     * @return APROVADO | REPROVADO
     */
    public String getSituacao() {
        if (this.getSomaDasNotas() >= 60 && this.getFrequencia() >= Turma.QUANTIDADE_DE_AULAS * 0.75) {
            return "APROVADO";
        }
        return "REPROVADO";
    }

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
    private String getMatricula() {
        return ""+this.matricula;
    }

    /**
     * Retiorna a soma das notas do aluno
     * @return
     */
    public int getSomaDasNotas() {
        int soma = 0;
        for (int i = 0; i < Turma.QUANTIDADE_DE_ATIVIDADES; i++) {
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
        "\nMatricula: "+this.getMatricula()+
        "\nAtividades: [ "+this.atividades[0]+", "+this.atividades[1]+", "+this.atividades[2]+", "+this.atividades[3]+" ]"+
        "\nSituação: "+this.getSituacao();
    }

    /**
     * Retorna a linha do aluno no relatório
     * @return
     */
    public String relatorio(){
        int somaDeAtividades = this.getSomaDasNotas();
        String situacao = this.getSituacao();
        return String.format("%-10d | %-25s | %-4d | %-9s |\n", this.matricula, this.nome, somaDeAtividades, situacao);
    }
}