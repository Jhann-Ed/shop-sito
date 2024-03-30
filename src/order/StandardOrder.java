package order;

public class StandardOrder extends Order {

    public StandardOrder(Details details) {
        super(details);
    }

    @Override
    public void processOrder() {
        System.out.println("Procesando pedido estándar para " + details.getBuyerName());
        System.out.println("Dirección de envío: " + details.getShippingAddress());

        notifyObservers("Pedido estándar despachado.");
    }

    @Override
    public double calculateShippingCost() {
        return 5.0;
    }
}

