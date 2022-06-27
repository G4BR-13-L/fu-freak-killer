
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
