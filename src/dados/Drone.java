package dados;

public abstract class Drone implements Comparable<Drone> {
    private String codigo;
    private double custoFixo;
    private double autonomia;
    public Drone(String codigo, double custoFixo, double autonomia) {
        this.codigo = codigo;
        this.custoFixo = custoFixo;
        this.autonomia = autonomia;
    }

    public abstract double calculaCustoKm();

    public String toString() {
        return "dados.Drone " + codigo + " - Custo por km: R$ " + calculaCustoKm();
    }

    public String getCodigo() {
        return codigo;
    }

    public int compareTo(Drone drone) {
        return this.codigo.compareTo(drone.getCodigo());
    }

    public double getAutonomia() {
        return autonomia;
    }
    public double getCustoFixo() {
        return custoFixo;
    }

}