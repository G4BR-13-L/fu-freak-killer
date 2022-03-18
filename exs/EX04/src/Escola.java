package src;

import src.Turma;

public class Escola {

    private Turma [] turmas;

    public Escola(){
        this.turmas = new Turma[100];
    }

    public int getTurmas() {
        return this.turmas.length;
    }
    
}
