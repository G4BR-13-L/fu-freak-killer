import java.time.LocalDate;

public abstract class Consulta {
    protected LocalDate data;
    protected Especialidade especialidade;
    protected double valorPago;

    public Consulta(LocalDate data, Especialidade espec){
        this.data = data;
        this.especialidade = espec;
        this.valorPago=0;
    }
    public abstract double valorAPagar();
    
}
