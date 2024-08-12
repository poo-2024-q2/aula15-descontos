/**
 * A policy that applies a full discount for every n items.
 */
public final class DescontoCompreAlgunsGanheUm extends Desconto {
    private int quantidadeMinima;

    public DescontoCompreAlgunsGanheUm(Pedido pedido, int quantidadeMinima) {
        super(pedido);
        this.quantidadeMinima = quantidadeMinima;
    }

    @Override
    public double getDesconto() {
        return pedido.getQuantidade() / quantidadeMinima * pedido.getPrecoUnitario();
    }
}
