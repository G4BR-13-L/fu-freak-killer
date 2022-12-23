package src.business;

/*

-public Data(int ano, int mes, int dia)
-public Data()                      // hoje
-public int getDia(), getMes(), getAno()
-public void adicionaDias(int dias) // avanca a data em dias
-public int diasNoMes()
-public String diaDaSemana()        // ex. "Segunda-feira"
-public boolean eAnoBisexto()
-public void proximoDia()           // avanca um dia
public String porExtenso()         // exibe a data por extens*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Data {
    private int dia;
    private int mes;
    private int ano;
    private int diasMes[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Data(int dia, int mes, int ano) {
        this.setData(dia, mes, ano);
    }

    public Data(int dia, int mes) {
        LocalDateTime dataAtual = LocalDateTime.now();
        int ano = dataAtual.getYear();
        this.setData(dia, mes, ano);
    }
    public Data(int dia) {
        LocalDateTime dataAtual = LocalDateTime.now();
        int ano = dataAtual.getYear();
        int mes = dataAtual.getMonthValue();
        this.setData(dia, mes, ano);
    }

    public Data() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String data = dtf.format(now);
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));
        this.setData(dia, mes, ano);
    }

    private void setData(int dia, int mes, int ano) {
        this.setAno(ano);
        if (mes < 1) {
            this.setMes(1);
        } else if (mes > 12) {
            do{
                this.ano++;
                mes-=12;
                this.setMes(mes);
            }while( mes > 12 );
            } else {
            this.setMes(mes);
        }
        this.setDia(dia);
        this.corrigirData();
    }

    public void proximoDia() {
        this.adicionarDias(1);
    }

    public void adicionarDias(int dias) {
        if( dias > 0 ){
            this.dia += dias;
            this.corrigirData();   
        }
    }

    private void corrigirData() {
        while (!this.validarDia()) {
            this.dia -= this.diasMes[this.mes - 1];
            this.mes++;
            if (this.mes > 12) {
                this.mes = 1;
                this.ano++;
                this.configuraAnoBisexto();
            }
        }
    }

    public boolean validarDia() {
        return this.dia < this.diasMes[this.mes - 1] && this.dia >= 1;
    }

    private void configuraAnoBisexto() {
        if (this.eAnoBisexto()) {
            this.diasMes[1] = 29;
        } else {
            this.diasMes[1] = 28;
        }
    }

    public boolean eAnoBisexto() {
        return ((ano % 4 == 0) && !(ano % 100 == 0)) || (ano % 400 == 0);
    }

    public String diaDaSemana() {
        String[] diasDaSemana = { "sábado",
                "domingo", "segunda-feira",
                "terça-feira", "quarta-feira",
                "quinta-feira", "sexta-feira" };

        int ano = this.getAno(), mes = this.getMes(), dia = this.getDia();
        if (mes < 3) {
            mes += 12;
            ano -= 1;
        }
        if (this.eAnoBisexto()) {
            dia--;
        }
        int k = ano % 100;
        int j = ano / 100;
        int w = ((dia + (((mes + 1) * 26) / 10) +
                k + (k / 4) + (j / 4)) + (5 * j)) % 7;
        return diasDaSemana[w];
    }

    public int diasNoMes() {
        return this.diasMes[mes - 1];
    }

    public String porExtenso() {
        String[] mesesPorExtenso = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
                "Setembro", "Outubro", "Novembro", "Dezembro" };
        return this.dia + " de " + mesesPorExtenso[this.mes - 1] + " de " + this.ano;
    }

    public String getDataFormatada() {
        return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
    }

    public int getDia() {
        return this.dia;
    }

    private void setDia(int dia) {
        this.dia = dia;
        this.corrigirData();
    }

    public int getMes() {
        return this.mes;
    }
    private void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return this.ano;
    }

    private void setAno(int ano) {
        this.ano = ano;
      
    }
}