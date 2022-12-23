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

public class Main {
    public static void main(String[] args) {

        String[] nomes = {
                "Fulana",
                "Tomahawk",
                "Argent",
                "Sinatra",
                "Bloodhound",
                "Unplugged",
                "Steven Styler",
                "Mindcrime",
                "Moby",
                "Lazy Eye",
                "Novoseli",
                "Gorillaz",
                "Sykes",
                "Feel Good",
                "Fabulous Killjoy",
                "Meat Grinder",
                "Arm Brother",
                "Primal Scream",
                "Gojira",
                "Sahara",
        };

        int[][] matrizDeNotas = {
            {8,4,9,12},
            {21,15,15,23},
            {15,13,24,9},
            {17,10,12,23},
            {9,8,20,17},
            {18,17,25,23},
            {23,13,15,20},
            {21,21,22,15},
            {4,8,5,10},
            {15,16,8,9},
            {9,14,16,12},
            {21,2,20,22},
            {23,17,17,22},
            {21,9,21,21},
            {15,20,12,15},
            {23,9,9,8},
            {5,21,1,21},
            {1,25,21,15},
            {9,2,15,20},
            {8,16,17,22},
        };

        int[] presencaNasAulas = {
            20,15,14,15,16,18,16,18,15,
            20,15,9,16,12,10,18,17,17,15,17
        };

        int[] code = { 1, 4, 2 };
        Turma turma = new Turma(code);
        for (int i = 0; i < 20; i++) {
            turma.matricular(nomes[i]);
        }

        System.out.println(turma.getRelatorio());

        for (int i = 0; i < 20; i++) {
            for ( int j = 0 ; j < 4 ; j++ ){
                turma.getAluno(i).darNota(j, matrizDeNotas[i][j]);
            }
        }
        for( int i  = 0 ; i < 20 ; i++){
            turma.getAluno(i).setFrequencia(presencaNasAulas[i]);
        }


        System.out.println(turma.getRelatorio());
        System.out.println("Media das notas: "+turma.getMediaDeNotas());
        System.out.println("Media de frequencia: "+turma.getMediaDeFrequencia());
        System.out.println("Aluno de Melhor Desempenho: \n\n"+turma.alunoDeMelhorDesempenho()+"\n\n\n");


        Escola escola = new Escola();
        escola.adicionarTurma(turma);

        System.out.println(escola.relatorioListaDeTurmas());
    }
}
