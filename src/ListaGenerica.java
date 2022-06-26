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

import java.util.Comparator;

/**
 * Exemplo: polimorfismo paramétrico (genérico) com lista estática
 * Classe parâmetro implementa Comparable para retornar maior/menor
 */
public class ListaGenerica<T extends Comparable<T>> {
    
    //atributos de lista estática
    private T[] dados;
    private int qtDados;
    private int tamanhoLista;

    /**
     * Construtor com definição de tamanho máximo (estática)
     * @param tamanhoMax Inteiro (mínimo 2)
     */
    public ListaGenerica(int tamanhoMax){
        this.tamanhoLista = 2;
        if(tamanhoMax>2) this.tamanhoLista = tamanhoMax;
        this.qtDados = 0;
        this.dados = (T[])(new Comparable[this.tamanhoLista]);  //cast 'perigoso'. Não é a melhor prática em Java
    }

    /**
     * Esvazia a lista, colocando null em cada uma das posições
     */
    public void esvaziar(){
        if(this.qtDados>0)
            for (int i = 0; i < dados.length; i++) {
                    this.dados = null;
            }
        this.qtDados = 0;
    }
    /**
     * Adiciona um elemento, se couber (não depende de operações da classe-parâmetro)
     * @param novo Elemento a ser adicionado
     */
    public void adicionar(T novo){
        if(this.qtDados<this.tamanhoLista){
            this.dados[this.qtDados] = novo;
            this.qtDados++;
        }
    }

    /**
     * Procura um elemento por sua descrição (usa 'contains')
     * @param chave String para busca
     * @return Um elemento da lista ou null, se não encontrar. 
     */
    public T buscar(String chave){
        T resp = null;
        for (int i = 0; i < this.qtDados; i++) {
            if(this.dados[i].toString().contains(chave))
                resp = this.dados[i];
        }
        return resp;
    }

    /**
     * Procura um elemento por igualdade (polimorfismo em 'equals')
     * @param quem Elemento-mock para busca
     * @return Um elemento da lista ou null, se não encontrar. 
     */
    public T buscar(T quem){
        T resp = null;
        for (int i = 0; i < this.qtDados; i++) {
            if(this.dados[i].equals(quem))
                resp = this.dados[i];
        }
        return resp;
    }

    /**
     * Remove um elemento por igualdade (polimorfismo em 'equals')
     * @param quem Elemento-mock para retirada
     * @return O elemento retirado ou null, se não existir
     */
    public T remover(T quem){
        T resp = null;
        for (int i = 0; i < this.qtDados; i++) {
            if(this.dados[i].equals(quem)){
                resp = this.dados[i];
                for(int j = i+1; j<this.qtDados; j++)
                    this.dados[j-1] = this.dados[j];
                this.qtDados--;
                return resp;
            }
        }
        return resp;
    }

    /**
     * Retorna o maior elemento da lista (polimorfismo em 'compareTo')
     * @return O maior elemento, de acordo com o comparador nativo da classe-parâmetro
     */
    public T maior(){
        T resp = this.dados[0];

        for (int i = 1; i < this.qtDados; i++) {
            if(this.dados[i].compareTo(resp)>0)
                resp = this.dados[i];
        }
        return resp;
    }

    /**
     * Retorna o maior elemento da lista com comparador parametrizado (polimorfismo paramétrico)
     * @param comp O comparador a ser usado
     * @return O maior elemento, de acordo com o comparador usado
     */
    public T maior(Comparator<T> comp){
        T resp = this.dados[0];

        for (int i = 1; i < this.qtDados; i++) {
            if(comp.compare(this.dados[i], resp)>0)
                resp = this.dados[i];
        }
        return resp;
    }

    /**
     * Descrição da lista, com seus elementos (um por linha)
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("CONTEÚDO DA LISTA:\n");
        for (int i = 0; i < this.qtDados; i++) {
            sb.append(String.format("%02d", (i+1))+" - "+this.dados[i]+"\n");
        }
        sb.append("==========");
        return sb.toString();
    }

}
