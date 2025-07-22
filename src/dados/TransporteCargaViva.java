package dados;

public class TransporteCargaViva extends Transporte {
    private double temperaturaMinima;
    private double temperaturaMaxima;

    public TransporteCargaViva(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, double temperaturaMinima, double temperaturaMaxima) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    @Override
    public double calculaCusto() {
        if(getDrone()!=null) {
            if (temperaturaMinima - temperaturaMaxima > 10 || temperaturaMaxima - temperaturaMinima > 10) {
                return (getDrone().calculaCustoKm() * calculaDistancia()) + 1000;
            } else {
                return (getDrone().calculaCustoKm() * calculaDistancia());
            }
        }
        else
            return 0;
    }

    public double getTempMin() {
        return temperaturaMinima;
    }
    public double getTempMax() {
        return temperaturaMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTemperatura Mínima: " + temperaturaMinima + "\nTemperatura Máxima: " + temperaturaMaxima ;
    }
}