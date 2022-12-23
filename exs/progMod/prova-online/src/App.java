import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.Utilitário;

public class App {
    public static void main(String[] args) throws Exception {

        Clube clube = new Clube("JavaClube");
        LocalDateTime dataSimulada = LocalDateTime.now();

        // ADICIONANDO PESSOAS AO CLUBE
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                clube.cadastrarPessoa(new Socio(Utilitário.gerarNome()));
            }
            for (int j = 0; j < 5; j++) {
                Visitante visitante = new Visitante(Utilitário.gerarNome());
                clube.cadastrarPessoa(new Visitante(Utilitário.gerarNome()));
            }
        }

        // PESSOAS ACESSAM O CLUBE

        for (int i = 0; i < clube.numeroDePessoasCadastradas(); i++) {
            for (int j = 0; j < 5; j++) {
                clube.addAcesso(clube.getPessoa(i), dataSimulada);
            }
            for (int j = 0; j < 5; j++) {

                /*
                 * Para gerar um pouco de variedade entre pessoas que compram os convites ou não
                 */
                if (j % 2 == 0) {
                    ((Visitante) clube.getPessoa(i)).comprarConvite();
                    clube.addAcesso(clube.getPessoa(i), dataSimulada);
                } else {
                    clube.addAcesso(clube.getPessoa(i), dataSimulada);
                }
            }
            // Atualizando a data 
            dataSimulada.plusDays(2);
        }

        /**
         * O clube deve conseguir consultar a lista de visitantes
         *  que acessaram o clube em um determinado dia.
         */

         // O Metodo com stream propriamente dito
         List<Visitante> visitantes = clube.visitantesDoDia(LocalDateTime.now().plusDays(2));
         
        
        /**
         * O clube deve conseguir consultar o total de acessos
         *  ao clube em um intervalo de data, seja de sócios
         *  ou visitantes.
         */

         double visitasPeriodo = clube.acessosIntervalo(LocalDateTime.now(), LocalDateTime.now().plusDays(20));
    }
}