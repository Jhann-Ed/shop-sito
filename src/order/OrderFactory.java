package order;

public class OrderFactory {
    public static Order createOrder(OrderType type, Details details) {
        switch (type) {
            case STANDARD:
                return new StandardOrder(details);
            case EXPRESS:
                return new ExpressOrder(details);
            default:
                throw new IllegalArgumentException("Unsupported order type.");
        }
    }
}

