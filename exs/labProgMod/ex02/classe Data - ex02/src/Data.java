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
 * ----- CLASSE DATA ------:
 * 
 * Metodos:
 * verificarData(int dia, int mes, int ano)
 * adicionarDias(int dias) 
 * qualDataMaisFutura(Data data1, Data data2)
 * verificarAnoBisexto()
 * informarData()
 * getDataInteira()
 * getDataInteira()
 */
public class Data {
    private int dia;
    private int mes;
    private int ano;
    private int diasMes[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /*CONSTRUTOR*/
    Data() {
        this.dia = 25;
        this.mes = 2;
        this.ano = 2022;
    }

    Data(int dia, int mes, int ano) {
        if (verificarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    /**
     * verifica se uma data é valida
     * @param dia
     * @param mes
     * @param ano
     * @return boolean
     */
    public boolean verificarData(int dia, int mes, int ano) {
        this.verificarAnoBisexto(ano);
        if ((mes >= 1 && mes <= 12) && (dia >= 1 && dia <= this.diasMes[mes - 1])) {
            return true;
        }
        ;
        return false;
    }

    /**
     * Adiciona dias a data
     * @param dias
     */
    public void adicionarDias(int dias) {

        for (int i = dias; i > 0; i--) {
            if (this.dia == diasMes[mes - 1]) {
                this.dia = 1;
                this.mes++;
                if (this.mes == 13) {
                    this.mes = 1;
                    this.ano++;
                    this.verificarAnoBisexto();
                }
            } else {
                this.dia++;
            }
        }

    }

    /**
     * Verifica qual a data mais futura entre duas data
     * @param data1
     * @param data2
     * @return Instancia de uma classe data
     */
    public static Data qualDataMaisFutura(Data data1, Data data2) {
        int diasData1 = data1.getDataInteira();
        int diasData2 = data2.getDataInteira();
        if( diasData1 >= diasData2 ){
            return data1;
        }else{
            return data2;
        }
    }

    /**
     * Metodo para verificar se o ano atual é bisexto
     */
    private void verificarAnoBisexto() {
        if (((this.ano % 4 == 0) && !(this.ano % 100 == 0)) || (this.ano % 400 == 0)) {
            this.diasMes[1] = 29;
        } else {
            this.diasMes[1] = 28;
        }
    }

    /**
     * Metodo que verifica se um ano específico é bisexto
     * @param ano
     */
    private void verificarAnoBisexto(int ano) {
        if (((ano % 4 == 0) && !(ano % 100 == 0)) || (ano % 400 == 0)) {
            this.diasMes[1] = 29;
        } else {
            this.diasMes[1] = 28;
        }
    }

    /**
     * Retorana String data formatada dd/mm/yyyy
     * @return
     */
    public String informarData() {
        return mes < 10 ? this.dia + "/0" + this.mes + "/" + this.ano : this.dia + "/" + this.mes + "/" + this.ano;

    }

    /**
     * Retorna o valor inteiro da data atual
     * @return
     */
    public int getDataInteira() {
        return ( this.ano * 365 ) + this.diasMes[this.mes - 1] + this.dia;
    }




    /*==================== GETTERS E SETTERS ======================*/



    /**
     * @return int return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return int return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return int return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

}
