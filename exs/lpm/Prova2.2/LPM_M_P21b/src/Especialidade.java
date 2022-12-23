import kotlin.contracts.Returns;

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

public enum Especialidade {
    NEUROLOGIA, ORTOPEDIA,
    OTORRINO, ALERGOLOGIA,
    UROLOGIA;

    public double preco(Especialidade tipo) {
        switch (tipo) {
            case NEUROLOGIA:
                return 400;

            case ORTOPEDIA:
                return 200;

            case OTORRINO:
                return 180;
            case ALERGOLOGIA:
                return 160;

            case UROLOGIA:
                return 300;

            default:
                return 0;

        }
    }

}
