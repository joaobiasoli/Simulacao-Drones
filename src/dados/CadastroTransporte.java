package dados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CadastroTransporte {
    private ArrayList<Transporte> transportesCadastrados;
    private Queue<Transporte> transportesPendentes;
    private ArrayList<Drone> dronesDisponiveis;


    public CadastroTransporte() {
        transportesCadastrados = new ArrayList<>();
        transportesPendentes = new LinkedList<>();
        dronesDisponiveis = new ArrayList<>();
    }

    public String processarTransportesPendentes() {

        if (transportesPendentes.isEmpty()) {
            return "Não há transportes na fila de transportes pendentes.";
        }
        if(dronesDisponiveis.isEmpty()){
            return "Não há drones disponíveis para atender os transportes pendentes.";
        }

        Queue<Transporte> naoAlocados = new LinkedList<>();
        while (!transportesPendentes.isEmpty()) {
            Transporte transporte = transportesPendentes.poll();
            boolean alocado = false;

            for (Drone drone : dronesDisponiveis) {
                if(drone instanceof DroneCarga) {
                    if (((DroneCarga) drone).podeAtender(transporte)) {
                        transporte.setSituacao(Estado.ALOCADO);
                        transporte.setDrone(drone);
                        buscarTransporte(transporte.getNumero()).setSituacao(Estado.ALOCADO);
                        alocado = true;
                        break;
                    }
                }
            }

            if (!alocado) {
                naoAlocados.add(transporte);
                return "Erro: Não há drones disponíveis para atender o transporte " + transporte.getNumero() + ".";
            }
        }

        transportesPendentes = naoAlocados;
        return "Processamento de transportes pendentes concluído.";
    }

    public String cadastrarTransporte(Transporte transporte) {
        for (Transporte t : transportesCadastrados) {
            if (t.getNumero() == transporte.getNumero()) {
                return "Erro: dados.Transporte com o número indicado já existe.";
            }
        }
        transportesCadastrados.add(transporte);
        transportesPendentes.add(transporte);
        return "dados.Transporte cadastrado com sucesso!";
    }

    public String mostrarTransportes() {
        if (transportesCadastrados.isEmpty()) {
            return "Não há transportes cadastrados.";
        }
        StringBuilder sb = new StringBuilder("Transportes Cadastrados:\n");
        for (Transporte t : transportesCadastrados) {
            sb.append(t).append("\n");
            sb.append("\n");
        }
        return sb.toString();
    }


    public List<Transporte> getTransportesCadastrados() {
        return transportesCadastrados;
    }
    public List<Transporte> getTransportesPendentes() {
        return new ArrayList<>(transportesPendentes);
    }


    public Transporte buscarTransporte(int numero) {
        for (Transporte t : transportesCadastrados) {
            if (t.getNumero() == numero) {
                return t;
            }
        }
        for (Transporte t : transportesPendentes) {
            if (t.getNumero() == numero) {
                return t;
            }
        }
        return null;
    }

    public void alterarSituacaoTransporte(int numero, String novaSituacao) {
        Transporte transporte = buscarTransporte(numero);
        if (transporte == null) {
            return;
        }
        if(transporte.getSituacao().equals(Estado.TERMINADO) || transporte.getSituacao().equals(Estado.CANCELADO)){
            return ;
        }
        transporte.setSituacao(Estado.valueOf(novaSituacao));
    }

    public String cadastrarDrone(Drone drone) {
        for (Drone d : dronesDisponiveis) {
            if (d.getCodigo().equals(drone.getCodigo())) {
                return "Erro: dados.Drone com esse código já cadastrado.";
            }
        }

        int index = 0;
        while (index < dronesDisponiveis.size() && dronesDisponiveis.get(index).getCodigo().compareTo(drone.getCodigo()) < 0) {
            index++;
        }
        dronesDisponiveis.add(index, drone);
        return "dados.Drone cadastrado com sucesso!";
    }

    public ArrayList<Drone> getDronesCadastrados() {
        return dronesDisponiveis;
    }

}