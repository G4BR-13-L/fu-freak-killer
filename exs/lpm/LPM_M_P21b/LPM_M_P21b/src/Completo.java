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

public class Completo implements IPlanoDeSaude{

    double MENSALIDADE_BASICA = 280;
    double COPARTICIPACAO = 0;

    @Override
    public double calcMensalidade(int idade) {
        if( idade < 45 ){
            return MENSALIDADE_BASICA;
        }else{
            double coeficiente = (Math.floor(( idade - 45 ) / 5) / 100) + 1;
            return MENSALIDADE_BASICA * coeficiente;
        }
    }

    @Override
    public double coparticipacao() {
        return 0;
    }
    
}
