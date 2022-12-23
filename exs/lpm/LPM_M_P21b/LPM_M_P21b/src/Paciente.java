/*
=====================================================
Código desenvolvido por:
 ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗
██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║
██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║
██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║
╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
 ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
 =====================================================
*/
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Paciente {

    public String nome;
    private Map<LocalDate, Consulta> consultas;
    private IPlanoDeSaude plano;
    private LocalDate dataNascimento;
    
    public Paciente(String nome, String dataString){
        this.nome = nome;
        String[] dadosData = dataString.split("/");
        int dia = Integer.parseInt(dadosData[0]);
        int mes = Integer.parseInt(dadosData[1]);
        int ano = Integer.parseInt(dadosData[2]);
        
        this.dataNascimento = LocalDate.of(ano, mes, dia);
        this.plano = null;
        this.consultas = new HashMap();
    }

    

    private int idade(){
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    

    /**
     * @return Map<LocalDate, Consulta> return the consultas
     */
    public Map<LocalDate, Consulta> getConsultas() {
        return consultas;
    }
    /**
     * @return IPlanoDeSaude return the plano
     */
    public IPlanoDeSaude getPlano() {
        return plano;
    }

    /**
     * @param plano the plano to set
     */
    public void setPlano(IPlanoDeSaude plano) {
        this.plano = plano;
    }

    /**
     * @return LocalDate return the dataNascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }



    public void adicionarPlano(IPlanoDeSaude plano) {
        this.plano = plano;
    }



    public void addConsulta(Consulta c) {
        double valor = plano.coparticipacao() * c.valorAPagar();
        c.valorPago = valor;
        this.consultas.put(c.data, c);
    }

    public double calcularMensalidade() {
        return this.plano.calcMensalidade(this.idade());
    }

    



}
