package dados;

public class TransportePessoal extends Transporte {
    private int qtdPessoas;

    public TransportePessoal(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, int qtdPessoas) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.qtdPessoas = qtdPessoas;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    @Override
    public double calculaCusto() {
        if(getDrone()!=null) {
            return (getDrone().calculaCustoKm() * calculaDistancia()) + qtdPessoas*10;
        }
        else
            return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nQuantidade de Pessoas: " + qtdPessoas ;
    }
}