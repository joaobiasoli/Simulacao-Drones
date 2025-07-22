package dados;

public class DroneCargaInanimada  extends DroneCarga {
    private boolean protecao;

    public DroneCargaInanimada(String codigo, double custoFixo, double autonomia, double pesoMaximo, boolean protecao) {
        super(codigo, custoFixo, autonomia, pesoMaximo);
        this.protecao = protecao;
    }

    public boolean isProtegido() {
        return protecao;
    }

    @Override
    public double calculaCustoKm() {
        if(protecao)
            return getCustoFixo() +  10;
        else
            return getCustoFixo() +  5;
    }

    @Override
    public String toString() {
        return "dados.Drone de Carga Inanimada " + getCodigo() + " - Custo por km: R$ " + calculaCustoKm() + " - Peso Máximo: " + getPesoMaximo() + "kg";
    }
}

