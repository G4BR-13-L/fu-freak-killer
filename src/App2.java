import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App2 {
    static void trocar(int[] dados, int pos1, int pos2){
        int aux = dados[pos1];
        dados[pos1] = dados[pos2];
        dados[pos2] = aux;
    }

    static public int[] geraVetor(int tamanho, boolean ordenado){
        Random sorteio = new Random(42);
        int[] dados = new int[tamanho];
        for (int i = 0; i < dados.length; i++) {
            dados[i] = i+1;
        }
        if(!ordenado){
            for (int i = 0; i < dados.length*3; i++) {
                int pos1 = sorteio.nextInt(dados.length);
                int pos2 = sorteio.nextInt(dados.length);
                trocar(dados, pos1, pos2);
            }
        }
        return dados;
    }

    static public void bolha(int[] dados){
        for (int i = dados.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(dados[j] > dados[j+1])
                    trocar(dados, j, j+1);
            }

        }
    }

    static public int particao(int[] dados, int inicio, int fim){
        int posicao = inicio-1;
        int pivot = dados[fim];
        for (int i = inicio; i < fim; i++) {
            if(dados[i]<pivot){
                posicao++;
                trocar(dados, posicao, i);
            }
        }
        posicao++;
        trocar(dados, posicao, fim);
        return posicao;
    }

    static public void quicksort(int[] dados, int inicio, int fim){
        if(inicio>=fim)
            return;
        else{
            int particao = particao(dados, inicio, fim);
            quicksort(dados, inicio, particao-1);
            quicksort(dados, particao+1, fim);
        }
    }

    public static void saveToFile(String str, String met) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(met+".txt"));
        writer.write(str);

        writer.close();
    }

    public static Long media(List<Long> inteiros){
        Long soma = 0L;
        for(Long n : inteiros){
            soma += n;
        }
        return (soma / inteiros.size());
    }

    public static void primeiraParte() throws IOException {
        List<Integer> tamanhos = new ArrayList<>();
        tamanhos.add(62500);
        tamanhos.add(125000);
        tamanhos.add(250000);
        tamanhos.add(375000);

        for(Integer tam : tamanhos){
            List<Long> tempoBolha = new ArrayList<>();
            List<Long> tempoQuick = new ArrayList<>();

            for(int i = 0; i < 50; i++){
                int[] vetor = geraVetor(tam, false);

                System.out.println("Bolha "+(i+1));

                LocalDateTime antes = LocalDateTime.now();
                bolha(vetor.clone());
                tempoBolha.add(Duration.between(antes, LocalDateTime.now()).toMillis());

                System.out.println("Quicksort "+(i+1));

                antes = LocalDateTime.now();
                quicksort(vetor.clone(), 0, tam-1);
                tempoQuick.add(Duration.between(antes, LocalDateTime.now()).toMillis());

            }
            System.out.println("FIM");
            saveToFile("Média: " + media(tempoBolha) + " " + tempoBolha.toString(), "Bolha - " + tam);
            saveToFile("Média: " + media(tempoQuick) + " " + tempoQuick.toString(), "Quicksort - " + tam);
        }
    }

    public static void segundaParte() throws IOException {
        int tam = 375000;
        List<Long> tempoRandom = new ArrayList<>();
        List<Long> tempoSorted = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            int[] vetorAleatorio = geraVetor(tam, false);
            System.out.println("Aleatorio "+(i+1));

            LocalDateTime antes = LocalDateTime.now();
            quicksort(vetorAleatorio, 0, tam-1);
            tempoRandom.add(Duration.between(antes, LocalDateTime.now()).toMillis());

            int[] vetorOrdenado = geraVetor(tam, true);
            System.out.println("Ordenado "+(i+1));

            antes = LocalDateTime.now();
            quicksort(vetorOrdenado, 0, tam-1);
            tempoSorted.add(Duration.between(antes, LocalDateTime.now()).toMillis());

        }
        System.out.println("FIM");
        saveToFile("Média: " + media(tempoRandom) + " " + tempoRandom.toString(), "Random - " + tam);
        saveToFile("Média: " + media(tempoSorted) + " " + tempoSorted.toString(), "Sorted - " + tam);
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Primeira Parte: \n");
        // primeiraParte();
        System.out.println("Segunda Parte: \n");
        segundaParte();
    }
}
