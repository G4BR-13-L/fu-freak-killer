public class Quadrado extends Figura{
    
    private int lado;
    
    public Quadrado(int lado){
        this.lado = lado;
    }

    @Override
    public final double area(){
        return Math.pow(lado, 2);
    }
}