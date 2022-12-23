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

public class Livro implements Serializable{

    private String codigo;
    private String titulo;
    private boolean isEmprestado;

    public Livro( String c, String t){
        this.codigo = c;
        this.titulo = t;
        
    }
    /**
     * @return String return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public void adicionarABiblioteca() {
        Biblioteca.addLivro(this);
    }


    /**
     * @return boolean return the isEmprestado
     */
    public boolean isIsEmprestado() {
        return isEmprestado;
    }

    /**
     * @param isEmprestado the isEmprestado to set
     */
    public void setIsEmprestado(boolean isEmprestado) {
        this.isEmprestado = isEmprestado;
    }

}
