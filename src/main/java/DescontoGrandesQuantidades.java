/**
 * Implement a policy for bulk discounts.
 */
public final class DescontoGrandesQuantidades extends Desconto {
    private int minimo;
    private double taxaDesconto;

    public DescontoGrandesQuantidades(Pedido pedido, int minimo, double taxaDesconto) {
        super(pedido);
        this.minimo = minimo;
        this.taxaDesconto = taxaDesconto;
    }

    @Override
    public double getDesconto() {
        return pedido.getQuantidade() >= minimo ? pedido.getPrecoTotal() * taxaDesconto : 0;
    }
}
