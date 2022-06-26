package Excecoes;

public class ConsultaDataInvalida extends Exception{
    private static final long serialVersionUID = -7546139900483470139L;
	
	private int dias;
	
	public int getDias() {
		return dias;
	}
	
	public ConsultaDataInvalida(int dias, int max) {
		super("A consulta de retorno deve ser agendada com o prazo máximo de " + max + " dias após a consulta original.");
		this.dias = dias;
	}
}
