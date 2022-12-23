package exceptions;

import java.time.LocalDateTime;

public class ExcecaoDataInvalida extends Exception {
    
    private static final long serialVersionUID = -7546139900483470139L;
	
	public ExcecaoDataInvalida(LocalDateTime d1, LocalDateTime d2) {
		super("A data "+d1+" deve ser anterior a data "+d2);
	}
}
