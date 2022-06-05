package src;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Pessoa {
    
    private String nome;
    private String telefone;
    private String cep;
    private String endereco;
    private String uf;

    public Pessoa(String nome ,String telefone ,String cep ,String endereco ,String uf) {
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setCep(cep);
        this.setEndereco(endereco);
        this.setUf(uf);
    }
    

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }

}








