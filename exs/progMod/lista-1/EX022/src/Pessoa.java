package src;

import java.time.LocalDateTime;

public class Pessoa {
    private int anoDeNascimento;
    private String nome;
    private String cpf;
    private String sexo;

    public Pessoa(int anoDeNascimento, String nome, String cpf, String sexo) {
        this.setAnoDeNascimento(anoDeNascimento);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSexo(sexo);
    }
    public Pessoa() {
        this.setAnoDeNascimento(2022);
        this.setNome("sem-nome");
        this.setCpf("000.000.000-00");
        this.setSexo("indefinido");
    }

    public boolean isMaiorDeIdade(){
        return this.getIdade() >= 18;
    }

    public String getCPF() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSexo() {
        return this.sexo;
    }

    public int getIdade() {
        LocalDateTime dataAtual = LocalDateTime.now();
        int ano = dataAtual.getYear();
        return ano - anoDeNascimento;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
