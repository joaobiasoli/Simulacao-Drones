package dados;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;

public abstract class Transporte {
    private int numero;
    private String nomeCliente;
    private String descricao;
    private double peso;
    private double latitudeOrigem;
    private double latitudeDestino;
    private double longitudeOrigem;
    private double longitudeDestino;
    private Estado situacao;
    private Drone drone;

    public Transporte(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.descricao = descricao;
        this.peso = peso;
        this.latitudeOrigem = latitudeOrigem;
        this.latitudeDestino = latitudeDestino;
        this.longitudeOrigem = longitudeOrigem;
        this.longitudeDestino = longitudeDestino;
        this.situacao = situacao;
    }

    public void setSituacao(Estado situacao) {
        this.situacao = situacao;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPeso() {
        return peso;
    }

    public Estado getSituacao() {
        return situacao;
    }

    public abstract double calculaCusto();


    @Override
    public String toString() {
        try {
            double custo = calculaCusto();
            return "Número: " + numero + "\nNome do Cliente: " + nomeCliente + "\nDescrição: " + descricao + "\nPeso: " + peso + "\nLatitude Origem: " + latitudeOrigem + "\nLatitude Destino: " + latitudeDestino + "\nLongitude Origem: " + longitudeOrigem + "\nLongitude Destino: " + longitudeDestino + "\ndados.Drone alocado: " + drone + "\nSituação: " + situacao + "\nCusto: R$ " + custo;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao calcular custo";
        }
    }

    public double getLatitudeOrigem() {
        return latitudeOrigem;
    }

    public double getLongitudeOrigem() {
        return longitudeOrigem;
    }

    public double getLatitudeDestino() {
        return latitudeDestino;
    }

    public double getLongitudeDestino() {
        return longitudeDestino;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public double calculaDistancia() {
        final int R = 6371;
        double latDistance = toRadians(latitudeDestino - latitudeOrigem);
        double lonDistance = toRadians(longitudeDestino - longitudeOrigem);
        double a = sin(latDistance / 2) * sin(latDistance / 2)
                + cos(toRadians(latitudeOrigem)) * cos(toRadians(latitudeDestino))
                * sin(lonDistance / 2) * sin(lonDistance / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return R * c;
    }
}