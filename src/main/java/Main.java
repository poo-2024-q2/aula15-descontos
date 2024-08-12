/**
 * Adhoc tests.
 */
public final class Main {

    private Main() {}
    
    /**
     * Main code.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        var cliente1 = new Cliente("Fulano", "a@a.a", true);
        var cliente2 = new Cliente("Beltrano", "b@b.b", false);

        
        var pedido1 = new PedidoEncomenda(10, 10.0, cliente1, Pedido.MeioPagamento.CARTAO, 5.0, "Rua X");
        var pedido2 = new PedidoProntaEntrega(10, 10.0, cliente2, Pedido.MeioPagamento.DINHEIRO);

        System.out.println(pedido1);
        System.out.println(pedido2);

        pedido1.addDesconto(new DescontoFixo(pedido1, 0.1));
        System.out.println(pedido1);
        pedido1.addDesconto(new DescontoGrandesQuantidades(pedido1, 10, 0.5));
        System.out.println(pedido1);
    }
}
