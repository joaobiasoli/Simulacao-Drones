package dados;

public class DronePessoal extends Drone {
    private int quantidadeMaximaPessoas;

    public DronePessoal(String codigo, double custoFixo, double autonomia, int quantidadeMaximaPessoas) {
        super(codigo, custoFixo, autonomia);
        this.quantidadeMaximaPessoas = quantidadeMaximaPessoas;
    }

    @Override
    public double calculaCustoKm() {
        return getCustoFixo() +  quantidadeMaximaPessoas*2;
    }

    public int getQtdMaxPessoas() {
        return quantidadeMaximaPessoas;
    }
}