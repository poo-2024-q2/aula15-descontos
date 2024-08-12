import java.util.ArrayList;

public abstract class Pedido {
    protected int quantidade;
    protected double precoUnitario;
    protected Cliente cliente;
    protected ArrayList<Desconto> descontos;
    protected MeioPagamento pagamento;

    public enum MeioPagamento {
        DINHEIRO, CARTAO, PIX
    }

    public Pedido(int quantidade, double precoUnitario, Cliente cliente, MeioPagamento pagamento) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.cliente = cliente;
        this.descontos = new ArrayList<>();
        if (cliente.isFidelidade()) {
            descontos.add(new DescontoFixo(this, 0.05));
        }
        this.pagamento = pagamento;
        if (pagamento == MeioPagamento.PIX || pagamento == MeioPagamento.CARTAO) {
            descontos.add(new DescontoFixo(this, 0.04));
        }
    }

    public final double getPrecoTotal() {
        return quantidade * precoUnitario;
    }

    public double getDescontoTotal() {
        var descontoTotal = 0.0;

        for (var desconto : descontos) {
            descontoTotal += desconto.getDesconto();
        }

        return descontoTotal;
    }

    public abstract double getAcrescimos();

    public final double getPrecoFinal() {
        return getPrecoTotal() - getDescontoTotal() + getAcrescimos();
    }

    public void addDesconto(Desconto desconto) {
        descontos.add(desconto);
    }

    public void limpaDescontos() {
        descontos.clear();
        if (cliente.isFidelidade()) {
            descontos.add(new DescontoFixo(this, 0.05));
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDescontos(ArrayList<Desconto> descontos) {
        this.descontos = descontos;
    }

    @Override
    public String toString() {
        return String.format("Preço total: %.2f\n", getPrecoTotal())
                + String.format("Desconto total: %.2f\n", getDescontoTotal())
                + String.format("Preço final: %.2f\n", getPrecoFinal());
    }
    
}
