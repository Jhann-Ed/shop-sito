package order;

public class ExpressOrder extends Order {
    public ExpressOrder(Details details) {
        super(details);
    }

    @Override
    public void processOrder() {
        System.out.println("Procesando pedido expréss para " + details.getBuyerName());
        System.out.println("Dirección de envío: " + details.getShippingAddress());

        notifyObservers("Pedido expréss despachado");
    }

    @Override
    public double calculateShippingCost() {
        return 15.0;
    }
}
