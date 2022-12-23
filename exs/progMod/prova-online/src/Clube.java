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
