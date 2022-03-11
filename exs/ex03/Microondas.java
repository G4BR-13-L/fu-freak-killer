/*  Código desenvolvido por:
**
**    ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗     
**    ██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║     
**    ██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║     
**    ██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║     
**    ╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
**     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
**/



/**
 * ----- CLASSE MICROONDAS ------:
 * 
 * METODOS:
 * public Object getTemporizador()
 * public boolean isPortaAberta()
 * public void ligar()
 * public void desligar()
 * public void pausar()
 * public String getStatus()
 * public void abrirPorta()
 * public void fecharPorta()
 * public void programarTemporizador(int tempoEmSegundos)
 * public void programarTemporizador(int tempoEmMinutos, int tempoEmSegundos)
 * private int tratarTempoNegativo(int tempoNegativo)
 * public void reiniciar()
 * public void passarTempo(int tempoEmSegundos)
 * public String getContagemAtual()
 */


public class Microondas {

    private String status;
    private boolean porta;
    private int temporizador;
    private int contagem;

    Microondas() {
        this.status = "Desligado";
        this.porta = false;
        this.temporizador = 0;
        this.contagem = 0;
    }

    /**
     * 
     * @return tempo programado
     */
    public Object getTemporizador() {
        return this.temporizador;
    }

    /**
     * Verifica se a porta está aberta
     * @return estado booleando da porta
     */
    public boolean isPortaAberta() {
        return this.porta;
    }

    /**
     * Liga o Microondas se o temporizador estiver programado
     * e se a porta estiver fechada
     */
    public void ligar() {
        if (!this.porta && temporizador != 0) {
            this.status = "Ligado";
            this.contagem = this.temporizador;
        }
    }

    /**
     * Altera o estado do microondas para desligados e 
     * reseta os valores do temporizador e do contador
     */
    public void desligar() {
        this.status = "Desligado";
        this.temporizador = 0;
        this.contagem = 0;
    }

    /**
     * Pausa o microondas somente se ele estiver ligado e
     * programado previamente
     */
    public void pausar() {
        if (this.temporizador != 0 && this.status == "Ligado") {
            this.status = "Pausado";
        }
    }

    /**
     * Retorna uma String do Estado atual do microondas
     * @return Ligado | Desligado | Pausado
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Abre a porta do microondas se ele estiver desligado ou pausado
     */
    public void abrirPorta() {
        if (this.status != "Ligado") {
            this.porta = true;
        }
    }

    /**
     * Fecha a porta do microondas
     */
    public void fecharPorta() {
        this.porta = false;
    }

    /**
     * Programa o temporizador com tempo em segundos passados
     * como parâmetro. Além disso, verifica se o numero é negativo
     * @param tempoEmSegundos
     */
    public void programarTemporizador(int tempoEmSegundos) {
        if( tempoEmSegundos < 0 ){
            tempoEmSegundos = tratarTempoNegativo(tempoEmSegundos);
        }
        this.temporizador = tempoEmSegundos;
    }

    /**
     * Sobrecarda do método anterior, porem com paramenntros 
     * de minutos e segundos
     * @param tempoEmMinutos
     * @param tempoEmSegundos
     */
    public void programarTemporizador(int tempoEmMinutos, int tempoEmSegundos) {
        if( tempoEmSegundos< 0 ){
            tempoEmSegundos = tratarTempoNegativo(tempoEmSegundos);
        }
        if( tempoEmMinutos< 0 ){
            tempoEmMinutos = tratarTempoNegativo(tempoEmMinutos);
        }
        tempoEmSegundos += tempoEmMinutos * 60;
        this.temporizador = tempoEmSegundos;
    }

    /**
     * Método que converte tempos negativos para positivos
     * @param tempoNegativo
     * @return
     */
    private int tratarTempoNegativo(int tempoNegativo){
        return tempoNegativo += - ( tempoNegativo *2 );
    }

    /**
     * Reinicia o Microondas, setando o valor do contador como
     * o valor do temporizador
     */
    public void reiniciar() {
        if ((this.status == "Ligado" || this.status == "Pausado") && this.temporizador != 0) {
            this.contagem = this.temporizador;
        }
        if (!this.isPortaAberta()) {
            this.ligar();
        }
    }

    /**
     * Faz a passagem de tempo, com tempo passado em segundos
     * @param tempoEmSegundos
     */
    public void passarTempo(int tempoEmSegundos) {
        if (this.status == "Ligado") {
            if ( tempoEmSegundos < 0 ){
                tempoEmSegundos += -(tempoEmSegundos*2); 
            }
            if (tempoEmSegundos > this.contagem) {
                this.desligar();
            }else{
                this.contagem -= tempoEmSegundos;
            }
        }
    }

    /**
     * Retorna o o valor atual do contador
     * Geralmente esse metodo é utilizado após a passagem de tempo
     * @return
     */
    public String getContagemAtual() {

        int minutos = this.contagem / 60;
        int segundos = ((this.contagem % 60) * 100) / 100;
        String strMinutos = minutos < 10 ? "0" + minutos : "" + minutos;
        String strSegundos = segundos < 10 ? "0" + segundos : "" + segundos;

        return strMinutos + ":" + strSegundos;
    }

}
