package src;

public class ExcecaoDataInvalida extends Exception {
	
	private static final long serialVersionUID = -1247269667828514123L;

	public ExcecaoDataInvalida() {
		super("A data deve possuir um valor positivo");
	}

}
class ExcecaoAnoInvalido extends Exception {
	
	private static final long serialVersionUID = -1247269667828514123L;

	public ExcecaoAnoInvalido() {
		super("A data deve possuir um ano de valor positivo");
	}

}
class ExcecaoMesInvalido extends Exception {
	
	private static final long serialVersionUID = -1247269667828514123L;

	public ExcecaoMesInvalido() {
		super("A data deve possuir um mes de valor positivo");
	}

}

class ExcecaoDiaInvalido extends Exception {
	
	private static final long serialVersionUID = -1247269667828514123L;

	public ExcecaoDiaInvalido() {
		super("A data deve possuir um dia de valor positivo");
	}

}