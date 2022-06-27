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
