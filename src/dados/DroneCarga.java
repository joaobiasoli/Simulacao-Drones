package dados;

public abstract class DroneCarga extends Drone {
    private double pesoMaximo;

    public DroneCarga(String codigo, double custoFixo, double autonomia, double pesoMaximo) {
        super(codigo, custoFixo, autonomia);
        this.pesoMaximo = pesoMaximo;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }


    public boolean podeAtender(Transporte transporte) {
        if (transporte.getPeso() > this.pesoMaximo) {
            return false;
        }

        double distancia = calcularDistancia(transporte.getLatitudeOrigem(), transporte.getLongitudeOrigem(), transporte.getLatitudeDestino(), transporte.getLongitudeDestino());
        return !(distancia > this.getAutonomia());
    }

    private double calcularDistancia(double latitudeOrigem, double longitudeOrigem, double latitudeDestino, double longitudeDestino) {
        double theta = longitudeOrigem - longitudeDestino;
        double dist = Math.sin(Math.toRadians(latitudeOrigem)) * Math.sin(Math.toRadians(latitudeDestino)) + Math.cos(Math.toRadians(latitudeOrigem)) * Math.cos(Math.toRadians(latitudeDestino)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }

    @Override
    public String toString() {
        return "dados.Drone de Carga " + getCodigo() + " - Custo por km: R$ " + calculaCustoKm() + " - Peso Máximo: " + pesoMaximo + "kg";
    }
}
