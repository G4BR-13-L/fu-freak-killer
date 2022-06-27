import java.time.LocalDate;
import java.time.LocalDateTime;

public class Acesso {
    private Pessoa pessoa;
    private LocalDateTime dataAcesso;

    public Acesso(Pessoa pessoa){
        this.pessoa = pessoa;
        dataAcesso = LocalDateTime.now();
    }

    public Acesso(Pessoa pessoa, LocalDateTime data){
        this.pessoa = pessoa;
        dataAcesso = data;
    }

    public LocalDateTime getData(){
        return this.dataAcesso;
    }
    public Pessoa getPessoa(){
        return this.pessoa;
    }
}
