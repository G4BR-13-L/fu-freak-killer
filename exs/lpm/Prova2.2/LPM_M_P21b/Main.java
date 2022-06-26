import java.time.LocalDate;
import src.*;
public class Main {
    public static void main(String[] args) throws Exception {

        Paciente p = new Paciente("Teste", "26/01/1972");
        Coparticipacao planoCopart = new Coparticipacao();

        Consulta c = new Agendada(LocalDate.now(), Especialidade.NEUROLOGIA);
        Consulta c1 = new Agendada(LocalDate.now(), Especialidade.NEUROLOGIA);
        Consulta c2= new Agendada(LocalDate.now(), Especialidade.NEUROLOGIA);
        Consulta c3 = new Agendada(LocalDate.now().plusMonths(3), Especialidade.ALERGOLOGIA);
        Consulta c4 = new Agendada(LocalDate.now().plusDays(8), Especialidade.ALERGOLOGIA);
        Consulta c5 = new Agendada(LocalDate.now().minusYears(3), Especialidade.ALERGOLOGIA);
        Consulta c6 = new Agendada(LocalDate.now().plusWeeks(7), Especialidade.ALERGOLOGIA);
        Consulta c7 = new Agendada(LocalDate.now().plusDays(2), Especialidade.ALERGOLOGIA);
        Consulta c8 = new Agendada(LocalDate.now().minusDays(20), Especialidade.ALERGOLOGIA);

        p.adicionarPlano(planoCopart);
        p.addConsulta(c);
        p.addConsulta(c1);
        p.addConsulta(c2);
        p.addConsulta(c3);
        p.addConsulta(c4);
        p.addConsulta(c5);
        p.addConsulta(c6);
        p.addConsulta(c7);
        p.addConsulta(c8);

        System.out.println(p.historicoAnual());
    }
}
