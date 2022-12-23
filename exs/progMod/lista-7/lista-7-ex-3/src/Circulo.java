public class Circulo extends Figura{
    //atributo
    private double raio;

    public Circulo(double raio){
        this.raio = 1;
        if(raio>1)
            this.raio = raio;
    }

    @Override
    public double area(){
        return Math.PI * Math.pow(this.raio,2);
    }

    public double getRaio(){
        return this.raio;
    }
}