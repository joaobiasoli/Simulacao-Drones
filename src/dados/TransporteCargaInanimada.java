package dados;

public class TransporteCargaInanimada extends Transporte {
    private boolean cargaPerigosa;

    public TransporteCargaInanimada(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, boolean cargaPerigosa) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.cargaPerigosa = cargaPerigosa;
    }

    @Override
    public double calculaCusto() {
        if(getDrone()!=null) {
            if(cargaPerigosa) {
                return (getDrone().calculaCustoKm() * calculaDistancia()) + 500;
            }else {
                return (getDrone().calculaCustoKm() * calculaDistancia());
            }
        }
        else
            return 0;
    }

    public boolean isPerigosa() {
        return cargaPerigosa;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCarga Perigosa: " + cargaPerigosa;
    }
}