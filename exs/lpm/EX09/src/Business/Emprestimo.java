/*  Código desenvolvido por:
**
**    ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗     
**    ██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║     
**    ██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║     
**    ██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║     
**    ╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
**     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
**/
package Business;
import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class Emprestimo extends Thread implements Serializable{
    private final String COD_EMPRESTIMO; 
    private LocalDateTime dataDoEmprestimo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Livro livro;
    private boolean isAtrasado;

    public Emprestimo( Livro livro ){
        this.COD_EMPRESTIMO = gerarCodigo(10);
        dataDoEmprestimo = LocalDateTime.now();
        dataInicio = dataDoEmprestimo;
        dataFim = dataInicio.plusDays(7);
        livro.setIsEmprestado(true);
        this.setLivro(livro);
        this.setIsAtrasado(false);
    }

    public synchronized void renovar(){
        dataInicio = LocalDateTime.now();
        dataFim = dataInicio.plusDays(7);
    }

    public void devolver(){
        this.livro.setIsEmprestado(false);
    }

    public static String gerarCodigo(int length) {
        char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        return new String(result);
    }

    public void verificarData(){
        if( dataFim.isBefore(LocalDateTime.now()) ){
            this.setIsAtrasado(true);
        }
    }

    public String toString(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("| %-20s | %-20s | %-14s | %-14s | %-35s |\n",
        this.getCodigo(), this.getDataDoEmprestimo().format(dateTimeFormatter),
        this.getDataInicio().format(dateTimeFormatter), this.getDataFim().format(dateTimeFormatter), this.getLivro().getTitulo());
    }
    public String getCodigo(){
        return this.COD_EMPRESTIMO;
    }
    /**
     * @return LocalDate return the dataDoEmprestimo
     */
    public LocalDateTime getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }

    /**
     * @param dataDoEmprestimo the dataDoEmprestimo to set
     */
    public void setDataDoEmprestimo(LocalDateTime dataDoEmprestimo) {
        this.dataDoEmprestimo = dataDoEmprestimo;
    }

    /**
     * @return LocalDate return the dataInicio
     */
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return LocalDate return the dataFim
     */
    public LocalDateTime getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }


    /**
     * @return Livro return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }


    /**
     * @return boolean return the isAtrasado
     */
    public boolean isIsAtrasado() {
        return isAtrasado;
    }

    /**
     * @param isAtrasado the isAtrasado to set
     */
    private void setIsAtrasado(boolean isAtrasado) {
        this.isAtrasado = isAtrasado;
    }

}
