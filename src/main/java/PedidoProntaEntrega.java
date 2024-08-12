public class PedidoProntaEntrega extends Pedido {

    public PedidoProntaEntrega(int quantidade, double precoUnitario, Cliente cliente, Pedido.MeioPagamento pagamento) {
        super(quantidade, precoUnitario, cliente, pagamento);
        addDesconto(new DescontoFixo(this, 0.1));
    }

    @Override
    public double getAcrescimos() {
        return 0;
    }    
}
