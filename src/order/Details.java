package order;
import java.util.List;
public class Details {
    private List<Product> products;
    private String shippingAddress;
    private String buyerName;

    // Constructor, getters y setters
    public Details(List<Product> products, String shippingAddress, String buyerName) {
        this.products = products;
        this.shippingAddress = shippingAddress;
        this.buyerName = buyerName;
    }

    // Getters y posiblemente setters si necesitas modificar los valores después de la construcción
    public List<Product> getProducts() {
        return products;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getBuyerName() {
        return buyerName;
    }
}


