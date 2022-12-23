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

import src.*;
import src.Aluno.Aluno;
import src.Turma.CursoLivre;
import src.Turma.TurmaEAD;
import src.Turma.TurmaPresencial;

public class Main {
    public static void main(String[] args) {

        String[] nomes = {
                "Fulana", "Tomahawk", "Sônia Tavares", "Shirlei Souza",
                "Argent", "Sinatra", "Bloodhound", "Unplugged",
                "Steven Styler", "Mindcrime", "Moby", "Lazy Eye",
                "Novoseli", "Gorillaz", "Sykes", "Feel Good",
                "Fabulous Killjoy", "Meat Grinder", "Arm Brother", "Primal Scream",
                "Gojira", "Sahara", "Maurício Nakata", "Antenor Chagas",
                "Juliano Bezerra", "Sérgio Assis", "Breno Kanashiro", "Fábio Câmara", "Sílvio Flores",
                "Diego Medina", "Enrico Monteiro", "Raul Moreira", "Kléber Couto",
                "José Pacheco", "César Paz", "Thiago Tavares", "Romeu Cruz",
                "Mário Assunção", "Davi Maldonado", "Álvaro Carvalho", "Pedro Peres",
                "Reginaldo Vidal", "Manoel Nakata",
                "Murilo Gonçalves", "Pedro Nascimento", "Francisco Andrade", "Marcos Dutra",
                "Cristiano Nakata", "Hugo Gonçalves", "Danilo Salgado", "Otávio Paim",
                "Mário Carmo", "Arnoldo Flores", "Enrico Paim", "Eduardo Reis",
                "Arnaldo Pimentel", "Benedito Passos", "Elísio Oliveira", "Neto Lourenço",
                "Augusto Braz", "Nicolas Prestes", "Romeu Rios", "Edgar Carvalho",
                "Cauê Nunes", "Émerson Carmo", "Joaquim Magalhães", "Murilo Saraiva", "Roberto Simões",
                "Leonardo Castilho", "Mateus Cunha", "Erasmo Gomes", "Geraldo Sá",
                "Amélia Ruiz", "Estela Morais", "Elza Prado", "Inês Oliveira",
                "Vanuza Corrêa", "Shirlei Aguiar", "Roberta Serra", "Letícia Vila",
                "Valéria Cruz", "Valentina Jesus", "Nicole Cabral", "Juliana Silveira",
                "Tânia Pereira", "Miriam Figueiredo", "Clarice Ribeiro", "Leila Carmo",
                "Suzana Linhares", "Luciana Maldonado", "Inês Shinoda", "Nicole Cavalcanti",
                "Jaqueline Boaventura", "Sabrina Cerqueira", "Lívia Higashi", "Cláudia Jesus",
                "Elza Delchiaro", "Priscila Barroso", "Arlene Araújo", "Roberta Paim",
                "Marli Pinheiro", "Sônia Nascimento", "Rita Silva", "Zilda Menezes",
                "Maiara Maldonado", "Eduarda Guedes", "Poliane Figueiredo", "Marina Salgado",
                "Maiara Fontes", "Emília Maciel", "Bárbara Borba", "Poliana Corrêa",
                "Isadora Leite", "Nina Fagundes", "Lavínia Nunes", "Liana Linhares",
                "Luana Lacerda", "Lorena Arruda", "Larissa Nazário", "Fernanda Souza",
        };

        int[][] matrizDeNotas = {
                { 8, 4, 9, 12 }, { 21, 15, 15, 23 }, { 8, 4, 9, 12 }, { 21, 15, 15, 23 }, { 8, 4, 9, 12 },{ 21, 15, 15, 23 },
                { 15, 13, 24, 9 }, { 17, 10, 12, 23 }, { 15, 13, 24, 9 }, { 17, 10, 12, 23 }, { 15, 13, 24, 9 },{ 17, 10, 12, 23 },
                { 9, 8, 20, 17 }, { 21, 9, 21, 21 }, { 9, 8, 20, 17 }, { 21, 9, 21, 21 }, { 9, 8, 20, 17 },{ 21, 9, 21, 21 },
                { 18, 17, 25, 23 }, { 23, 13, 15, 20 }, { 18, 17, 25, 23 }, { 23, 13, 15, 20 }, { 18, 17, 25, 23 },
                { 23, 13, 15, 20 },{ 21, 21, 22, 15 }, { 4, 8, 5, 10 }, { 21, 21, 22, 15 }, { 4, 8, 5, 10 }, { 21, 21, 22, 15 },
                { 4, 8, 5, 10 },{ 15, 16, 8, 9 }, { 9, 14, 16, 12 }, { 15, 16, 8, 9 }, { 9, 14, 16, 12 }, { 15, 16, 8, 9 },
                { 9, 14, 16, 12 },{ 21, 2, 20, 22 }, { 23, 17, 17, 22 }, { 21, 2, 20, 22 }, { 23, 17, 17, 22 }, { 21, 2, 20, 22 },
                { 23, 17, 17, 22 },{ 15, 20, 12, 15 }, { 23, 9, 9, 8 }, { 15, 20, 12, 15 }, { 23, 9, 9, 8 }, { 15, 20, 12, 15 },
                { 23, 9, 9, 8 },{ 5, 21, 1, 21 }, { 1, 25, 21, 15 }, { 5, 21, 1, 21 }, { 1, 25, 21, 15 }, { 5, 21, 1, 21 },{ 1, 25, 21, 15 },
                { 9, 2, 15, 20 }, { 8, 16, 17, 22 }, { 9, 2, 15, 20 }, { 8, 16, 17, 22 }, { 9, 2, 15, 20 },{ 8, 16, 17, 22 },
                { 8, 4, 9, 12 }, { 21, 15, 15, 23 }, { 8, 4, 9, 12 }, { 21, 15, 15, 23 }, { 8, 4, 9, 12 },{ 21, 15, 15, 23 },
                { 15, 13, 24, 9 }, { 17, 10, 12, 23 }, { 15, 13, 24, 9 }, { 17, 10, 12, 23 }, { 15, 13, 24, 9 },{ 17, 10, 12, 23 },
                { 9, 8, 20, 17 }, { 18, 17, 25, 23 }, { 9, 8, 20, 17 }, { 18, 17, 25, 23 }, { 9, 8, 20, 17 },{ 18, 17, 25, 23 },
                { 23, 13, 15, 20 }, { 21, 21, 22, 15 }, { 23, 13, 15, 20 }, { 21, 21, 22, 15 }, { 23, 13, 15, 20 },{ 21, 21, 22, 15 },
                { 4, 8, 5, 10 }, { 15, 16, 8, 9 }, { 4, 8, 5, 10 }, { 15, 16, 8, 9 }, { 4, 8, 5, 10 }, { 15, 16, 8, 9 },
                { 9, 14, 16, 12 }, { 21, 2, 20, 22 }, { 9, 14, 16, 12 }, { 21, 2, 20, 22 }, { 9, 14, 16, 12 },{ 21, 2, 20, 22 },
                { 23, 17, 17, 22 }, { 21, 9, 21, 21 }, { 23, 17, 17, 22 }, { 21, 9, 21, 21 }, { 23, 17, 17, 22 },{ 21, 9, 21, 21 },
                { 15, 20, 12, 15 }, { 23, 9, 9, 8 }, { 15, 20, 12, 15 }, { 23, 9, 9, 8 }, { 15, 20, 12, 15 },{ 23, 9, 9, 8 },
                { 5, 21, 1, 21 }, { 1, 25, 21, 15 }, { 5, 21, 1, 21 }, { 1, 25, 21, 15 }, { 5, 21, 1, 21 },{ 1, 25, 21, 15 },
                { 9, 2, 15, 20 }, { 8, 16, 17, 22 }, { 9, 2, 15, 20 }, { 8, 16, 17, 22 }, { 9, 2, 15, 20 },{ 8, 16, 17, 22 },
        };

        int[] presencaNasAulas = {
                20, 15, 14, 15, 16, 18, 16, 18, 15,
                20, 15, 9, 16, 12, 10, 18, 17, 17, 15, 17,
                20, 15, 14, 15, 20, 15, 14, 15, 16, 18, 16,
                18, 15, 20, 15, 9, 16, 12, 10, 18, 17, 17,
                15, 17, 16, 18, 16, 18, 15, 20, 15, 9, 16,
                12, 10, 20, 15, 14, 15, 16, 18, 20, 15,
                14, 15, 16, 18, 16, 18, 15, 20, 15, 9, 16,
                12, 10, 18, 17, 17, 15, 17, 16, 18, 15,
                20, 15, 9, 16, 12, 10, 18, 17, 9, 16, 12, 10,
                18, 17, 17, 15, 17, 16, 18, 16, 18, 15,
                20, 15, 9, 16, 12, 10, 20, 15, 14, 15, 16,
                18, 20, 15, 14, 15, 16, 18, 16, 18, 15,
                20, 15, 9, 16, 12, 10, 18, 17, 17, 15, 17,
                15, 17, 18, 17, 17, 15, 1720, 15, 14, 15,
                16, 18, 16, 18, 15, 20, 15, 9, 16, 12, 10,
                18, 17, 17, 15, 17
        };
        System.out.println("CURSO PRESENCIAL-------");
        String code = "P142";
        TurmaPresencial turmaPresencial = new TurmaPresencial(code, 4);
        for (int i = 0; i < 20; i++) {
            turmaPresencial.matricular(nomes[i]);
        }
        //System.out.println(turmaPresencial.getRelatorio());
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 4; j++) {
                turmaPresencial.getAluno(i).darNota(j, matrizDeNotas[i][j]);
            }
        }
        for (int i = 0; i < 20; i++) {
            turmaPresencial.getAluno(i).setFrequencia(presencaNasAulas[i]);
        }
        System.out.println(turmaPresencial.getRelatorio());
        System.out.println("Media das notas: " + turmaPresencial.getMediaDeNotas());
        System.out.println("Media de frequencia: " + turmaPresencial.getMediaDeFrequencia());
        System.out.println("Aluno de Melhor Desempenho: \n\n" + turmaPresencial.alunoDeMelhorDesempenho() + "\n\n\n");

        /* ======================TURMA EAD=========================== */
        System.out.println("CURSO EAD----------");
        TurmaEAD turmaEAD = new TurmaEAD("E351", 4);
        for (int i = 0; i < 30; i++) {
            turmaEAD.matricular(nomes[i + 20]);
        }
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 4; j++) {
                turmaEAD.getAluno(i).darNota(j, matrizDeNotas[i + 2][j]);
            }
        }

        System.out.println(turmaEAD.getRelatorio());
        System.out.println("Media das notas: " + turmaEAD.getMediaDeNotas());
        System.out.println("Aluno de Melhor Desempenho: \n\n" + turmaEAD.alunoDeMelhorDesempenho() + "\n\n\n");

        /** =========================================================== */

        /* ======================TURMA Curso Livre=========================== */
        System.out.println("CURSO LIVRE---------");
        CursoLivre turmaCursoLivre = new CursoLivre("L432", 25);
        for (int i = 0; i < 35; i++) {
            turmaCursoLivre.matricular(nomes[i + 30]);
        }
        for (int i = 0; i < 35; i++) {
            turmaCursoLivre.getAluno(i).conteudoAssistido(presencaNasAulas[i+10]);
        }

        System.out.println(turmaCursoLivre.getRelatorio());

        /** =========================================================== */

        Escola escola = new Escola();
        escola.adicionarTurma(turmaPresencial);
        escola.adicionarTurma(turmaEAD);
        escola.adicionarTurma(turmaCursoLivre);
        System.out.println(escola.relatorioListaDeTurmas());
    }
}
