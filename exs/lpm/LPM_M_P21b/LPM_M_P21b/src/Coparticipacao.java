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

public class Coparticipacao implements IPlanoDeSaude {

    public double COPARTICIPACAO = 0.3;
    public double MENSALIDADE_BASICA = 150;


    @Override
    public double calcMensalidade(int idade) {
        if( idade < 45 ){
            return MENSALIDADE_BASICA;
        }else if(idade< 55){
            return MENSALIDADE_BASICA * 1.15;
        }else if(idade < 65){
            return MENSALIDADE_BASICA * 1.25;
        }else{
            return MENSALIDADE_BASICA * 1.4;
        }
    }

    @Override
    public double coparticipacao() {
        return COPARTICIPACAO;
    }

    /*
     *  A mensalidade deste plano começa em R$150 e depois tem aumentos fixos: de 45 a 55 anos há um acréscimo de 15%; de 55 a 65 anos o acréscimo é de 25% e acima dos 65 anos há um acréscimo de 40%.
     */

  
}
