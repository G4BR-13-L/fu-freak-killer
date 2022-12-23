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

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.Utilitário;

public class App {
    public static void main(String[] args) throws Exception {

        Clube clube = new Clube("JavaClube");
        LocalDateTime dataSimulada = LocalDateTime.now();

        // ADICIONANDO PESSOAS AO CLUBE
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                clube.cadastrarPessoa(new Socio(Utilitário.gerarNome()));
            }
            for (int j = 0; j < 5; j++) {
                Visitante visitante = new Visitante(Utilitário.gerarNome());
                clube.cadastrarPessoa(new Visitante(Utilitário.gerarNome()));
            }
        }

        // PESSOAS ACESSAM O CLUBE

        for (int i = 0; i < clube.numeroDePessoasCadastradas(); i++) {
            for (int j = 0; j < 5; j++) {
                clube.addAcesso(clube.getPessoa(i), dataSimulada);
            }
            for (int j = 0; j < 5; j++) {

                /*
                 * Para gerar um pouco de variedade entre pessoas que compram os convites ou não
                 */
                if (j % 2 == 0) {
                    ((Visitante) clube.getPessoa(i)).comprarConvite();
                    clube.addAcesso(clube.getPessoa(i), dataSimulada);
                } else {
                    clube.addAcesso(clube.getPessoa(i), dataSimulada);
                }
            }
            // Atualizando a data 
            dataSimulada.plusDays(2);
        }

        /**
         * O clube deve conseguir consultar a lista de visitantes
         *  que acessaram o clube em um determinado dia.
         */

         // O Metodo com stream propriamente dito
         List<Visitante> visitantes = clube.visitantesDoDia(LocalDateTime.now().plusDays(2));
         
        
        /**
         * O clube deve conseguir consultar o total de acessos
         *  ao clube em um intervalo de data, seja de sócios
         *  ou visitantes.
         */

         double visitasPeriodo = clube.acessosIntervalo(LocalDateTime.now(), LocalDateTime.now().plusDays(20));
    }
}

import java.awt.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import exceptions.ExcecaoDataInvalida;

public class Clube {
    private List<Acesso> acessos = new ArrayList<Acesso>();
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private String nome;
    
    public Clube(String nome){
        this.nome = nome;
    }

    public void addAcesso(Pessoa pessoa){
        if( pessoa.autenticar()){
            Acesso acesso = new Acesso(pessoa);
            this.acessos.add(acesso);
        }
    }
    public void addAcesso(Pessoa pessoa, LocalDateTime data){
        if( pessoa.autenticar()){
            Acesso acesso = new Acesso(pessoa, data);
            this.acessos.add(acesso);
        }
    }

    public void cadastrarPessoa(Pessoa pessoa){
        this.pessoas.add(pessoa);
    }

    public int numeroDePessoasCadastradas() {
        return this.pessoas.size();
    }

    public Pessoa getPessoa(int i){
        return this.pessoas.get(i);
    }

    public List<Visitante> visitantesDoDia(LocalDateTime dia){
        return this.acessos.stream()
        .filter( ac -> ac.getPessoa() instanceof Visitante )
        .filter(ac -> ac.getData().isEqual(dia))
        .map(ac -> (Visitante) ac.getPessoa())
        .collect(Collectors.toList());
    }

    public double acessosIntervalo(LocalDateTime data1, LocalDateTime data2) throws ExcecaoDataInvalida{
        if( data1.isBefore(data2) ){
            return this.acessos.stream()
            .filter(ac -> ac.getData().isAfter(data1) && ac.getData().isBefore(data2))
            .count();
        }else{
            throw new ExcecaoDataInvalida(data1, data2);
        }
    }
}

package exceptions;

import java.time.LocalDateTime;

public class ExcecaoDataInvalida extends Exception {
    
    private static final long serialVersionUID = -7546139900483470139L;
	
	public ExcecaoDataInvalida(LocalDateTime d1, LocalDateTime d2) {
		super("A data "+d1+" deve ser anterior a data "+d2);
	}
}

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    private String nome;
    
    public Pessoa(String nome){
        this.nome = nome;
    }

    public abstract boolean autenticar();

}


import utils.*;
public class Socio extends Pessoa{
    private String numero;

    public Socio(String nome){
        super(nome);
        this.numero = Utilitário.gerarCodigo(6);
    }

    @Override 
    public boolean autenticar(){
        // Para extensão no futuro
        return true;
    }
}

public class Visitante extends Pessoa {
    
    public boolean isConvite;

    public Visitante(String nome) {
        super(nome);
    }

    public void comprarConvite(){
        this.isConvite = true;
    }

    public void conviteUsado(){
        this.isConvite = false;
    }

    @Override
    public boolean autenticar(){
        if ( this.isConvite ){
            this.conviteUsado();
            return true;
        }else{
            return false;
        }
    }
}






