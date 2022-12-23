/*
=====================================================
Código desenvolvido por:
 ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗
██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║
██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║
██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║
╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
 ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
 =====================================================
*/

//=====================================================
// METODO MAIN
//=====================================================

import src.Data;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();

        try {
            data.adicionarDias(-30);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


//=====================================================
// EXECEÇAO DE DATA INVÁLIDA
//=====================================================
package src;

public class ExcecaoDataInvalida extends Exception {
	
	private static final long serialVersionUID = -1247269667828514123L;

	public ExcecaoDataInvalida() {
		super("A data deve possuir um valor positivo");
	}

}
class ExcecaoAnoInvalido extends Exception {
	
	private static final long serialVersionUID = -1247269667828514123L;

	public ExcecaoAnoInvalido() {
		super("A data deve possuir um ano de valor positivo");
	}

}
class ExcecaoMesInvalido extends Exception {
	
	private static final long serialVersionUID = -1247269667828514123L;

	public ExcecaoMesInvalido() {
		super("A data deve possuir um mes de valor positivo");
	}

}

class ExcecaoDiaInvalido extends Exception {
	
	private static final long serialVersionUID = -1247269667828514123L;

	public ExcecaoDiaInvalido() {
		super("A data deve possuir um dia de valor positivo");
	}

}

//=====================================================
// TESTE DE EXCEÇÃO COM ASSERTTHROWS
//=====================================================

package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import src.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDateTime;

public class DataExceptionTest {

    Data data;

    @BeforeEach
    public void iniciarTestes() throws ExcecaoDataInvalida {
        data = new Data();
    }

    @Nested
    class TesteDeExcecaoEmDataInvalida{

        void testDiaNegativo() {
            assertThrows(ExcecaoDataInvalida.class, () -> {data.adicionarDias(-50);});
        }
        
    }

}

//=====================================================
// CLASSE DATA
//=====================================================

package src;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Data {
    private int dia;
    private int mes;
    private int ano;
    private int diasMes[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Data(int dia, int mes, int ano) throws ExcecaoDataInvalida, ExcecaoAnoInvalido, ExcecaoDiaInvalido, ExcecaoMesInvalido {
        this.setData(dia, mes, ano);
    }

    public Data(int dia, int mes) throws ExcecaoDataInvalida, ExcecaoAnoInvalido, ExcecaoDiaInvalido, ExcecaoMesInvalido {
        LocalDateTime dataAtual = LocalDateTime.now();
        int ano = dataAtual.getYear();
        this.setData(dia, mes, ano);
    }

    public Data(int dia) throws ExcecaoDataInvalida, ExcecaoAnoInvalido, ExcecaoDiaInvalido, ExcecaoMesInvalido {
        LocalDateTime dataAtual = LocalDateTime.now();
        int ano = dataAtual.getYear();
        int mes = dataAtual.getMonthValue();
        this.setData(dia, mes, ano);
    }

    public Data() throws ExcecaoDataInvalida, ExcecaoAnoInvalido, ExcecaoDiaInvalido, ExcecaoMesInvalido {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String data = dtf.format(now);
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));
        this.setData(dia, mes, ano);
    }

    private void setData(int dia, int mes, int ano) throws ExcecaoDataInvalida, ExcecaoAnoInvalido, ExcecaoDiaInvalido, ExcecaoMesInvalido {
        this.setAno(ano);
        if (mes < 1) {
            this.setMes(1);
        } else if (mes > 12) {
            do {
                this.ano++;
                mes -= 12;
                this.setMes(mes);
            } while (mes > 12);
        } else {
            this.setMes(mes);
        }
        this.setDia(dia);
        this.corrigirData();
    }

    public void proximoDia() throws ExcecaoDataInvalida {
        this.adicionarDias(1);
    }

    public void adicionarDias(int dias) throws ExcecaoDataInvalida {
        if (dias < 0) {
            throw new ExcecaoDataInvalida();
        } else {
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

    public void setDia(int dia) throws ExcecaoDiaInvalido {

        if (dia < 0) {
            throw new ExcecaoDiaInvalido();
        } else {
            this.dia = dia;
            this.corrigirData();

        }

    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) throws ExcecaoMesInvalido {
        if (mes < 0) {
            throw new ExcecaoMesInvalido();
        } else {
            this.mes = mes;
        }
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) throws ExcecaoAnoInvalido {
        if (ano < 0) {
            throw new ExcecaoAnoInvalido();
        } else {

            this.ano = ano;
        }

    }
}