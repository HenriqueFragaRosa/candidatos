import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos = selecaoCandidato();
        for (String candidato: candidatos) {
           entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativas = 0;
        boolean atendeu = false;
        do{
            tentativas++;
            atendeu = atender();

        }while(tentativas < 3 && !atendeu);

        if (atendeu) {
            System.out.println("Candidato " + candidato + " atendeu a ligação na tentativa " + tentativas);
        } else {
            System.out.println("Candidato " + candidato + " não atendeu a ligação");
        }
        
    }

    static String [] selecaoCandidato() {
        String [] candidatos = {"FELIPE", "MARIA", "JOÃO", "ANA", "CARLOS", "LUCAS", "MARCOS", "JULIA", "PEDRO", "PAULO"};
        String [] listaCandidatosSelecionados = new String[5];

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        while (candidatosSelecionados<5 && candidatoAtual <= candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            if (analisarCandidato(salarioPretendido)) {
                listaCandidatosSelecionados[candidatosSelecionados] = candidato;
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
        System.out.println("Lista de candidatos selecionados: ");
        for (String candidato: listaCandidatosSelecionados) {
            System.out.println(candidato);
        }
        return listaCandidatosSelecionados;
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static double valorPretendido() {
        
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean analisarCandidato(double salarioPretendido){
        double salarioBase = 2000;
        if (salarioPretendido > salarioBase ) {
            return false;
        } 
        return true;
    }
}
