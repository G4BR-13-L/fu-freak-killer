import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Excecoes.ConsultaDataInvalida;

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

public class Retorno extends Consulta{

    private static final int PRAZO_RETORNO = 30;
    public Consulta consultaOriginal;

    public Retorno(LocalDate data, Especialidade espec, Consulta consultaOriginal) throws ConsultaDataInvalida{
        super(data, espec);
        if( data.until(consultaOriginal.data, ChronoUnit.DAYS) < 30 ){
            this.consultaOriginal = consultaOriginal;
        }
    }

    @Override
    public double valorAPagar() {
        return 0;
    }
}