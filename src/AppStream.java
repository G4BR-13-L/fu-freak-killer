/** 
 * MIT License
 *
 * Copyright(c) 2022 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * App-demo do uso de streams em coleções
 */
public class AppStream {
    static Random aleat = new Random(42);

    /**
     * Gerador de figuras aleatórias para a coleção.
     * @return Uma figura (herda de Figura)
     */
    public static Figura criarFigura(){
        Figura novaForma = null;
        int tipo = aleat.nextInt(4);
        double n1 = aleat.nextDouble()*100;
        double n2 = aleat.nextDouble()*100;
        switch(tipo){
            case 0: novaForma = new Circulo(n1);
            break;
            case 1: novaForma = new Retangulo(n1, n2);
            break;
            case 2: novaForma = new Quadrado(n1);
            break;
            case 3: novaForma = new TrianguloRetangulo(n1, n2);
            break;
        }
        return novaForma;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        LinkedList<Figura> listaFig = new LinkedList<>();

        for (int i = 0; i < 100; i++) {  //adicionando na lista/coleção
            listaFig.add(criarFigura());
        }

        //mapeamento e soma
        System.out.println("Sum: "+
            listaFig.stream()
                    .mapToDouble(fig -> fig.area()) //usa a área de cada figura
                    .sum()      //soma os valores
        );
        teclado.nextLine();
        System.out.println();
        
        //filtro: imprime as figuras com área maior que 2500
        System.out.println("Filtro: ");
        listaFig.stream()
                    .filter(fig -> fig.area()>2500)     //filtro para áreas > 2500
                    .map(fig ->fig.toString())          //'pega' o toString da figura
                    .forEach(System.out::println);      //imprime cada uma
        teclado.nextLine();
        System.out.println();
            
            
        //filtro usando reduce para gerar uma string única com o resultado
        System.out.println("------------------------");
        System.out.println("Filtro ousado: "+
        listaFig.stream()
                    .filter(fig -> fig.area()>5000)         //filtro para áreas
                    .map(fig ->fig.toString())              //'pega' o toString da figura
                    .reduce((a,b) -> a.concat("\n" +b))     //'reduz'(concatena) cada duas toString em uma string, para poder imprimir tudo sem necessidade do forEach
                    .get()      //'retorna' a string concatenada/reduzida
        );
        System.out.println("------------------------");
        teclado.nextLine();
        System.out.println();
        

        //contador após filtro
        System.out.println("Filtro + contador: "+
        listaFig.stream()
                    .filter(fig -> fig.area()>2500)
                    .count());  //conta os objetos que obedecem ao filtro
        teclado.nextLine();
        System.out.println();
                 
        
        //uso de max: por área da figura
        System.out.println(
            listaFig.stream()
                    .max((f1,f2) -> 
                        (f1.area()>f2.area()?1:-1))         //comparador retorna 1 ou -1, assim como compareTo. 'if' ternário verifica a área e retorna
                    .get() // pega a maior figura por área (e não o valor da área)
        );

        teclado.nextLine();
        System.out.println();
        
        //average/média
        System.out.println("Average: "+
        listaFig.stream()
                .mapToDouble(fig -> fig.area()) //pegamos a área das figuras...
                .average()                      //faz a média
                .getAsDouble()                  //transforma em double, pois 'average' é 'Optional'
        );
        teclado.nextLine();
        System.out.println();
        
        //filtros combinados
        System.out.println("Várias condições: "+
            listaFig.stream()
                .filter(f-> f.descricao.contains("Quadrado"))       //restringimos aos quadrados...
                .filter(q-> ((Quadrado)q).getBase()>50.0)              //destes, só os que têm base/lado > 50 ...
                .mapToDouble(Figura::perimetro)                        //pegamos o perímetro de cada um
                .sum()                                                 //soma de todos os perímetros
        );
        System.out.println("FIM");
        teclado.close();
    
}
    
}




