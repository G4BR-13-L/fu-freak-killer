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
