
import order.*;
import services.CustomerNotificationService;
import services.ProductService;
import shoppingcart.ShoppingCart;
import java.util.List;
import java.util.Scanner;

public class Main {

    private ProductService productService;
    private ShoppingCart shoppingCart;
    private Scanner scanner;

    public Main() {
        this.productService = new ProductService();
        this.shoppingCart = ShoppingCart.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver todos los productos");
            System.out.println("2. Filtrar productos por categoría");
            System.out.println("3. Ver carrito de compras");
            System.out.println("4. Realizar pedido");
            System.out.println("5. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    displayProducts(productService.getAllProducts());
                    break;
                case 2:
                    filterProductsByCategory();
                    break;
                case 3:
                    displayShoppingCart();
                    break;
                case 4:
                    realizarPedido();
                    break;
                case 5:
                    System.out.println("Gracias por visitar la tienda.");
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    private void realizarPedido() {
        if (shoppingCart.getProducts().isEmpty()) {
            System.out.println("El carrito de compras está vacío. Agrega productos antes de realizar un pedido.");
            return;
        }

        System.out.println("Ingrese su nombre:");
        String buyerName = scanner.nextLine();
        System.out.println("Ingrese su dirección de envío:");
        String shippingAddress = scanner.nextLine();

        Details orderDetails = new Details(shoppingCart.getProducts(), shippingAddress, buyerName);

        System.out.println("Seleccione el tipo de envío: 1 para Estándar, 2 para Exprés");
        int shippingType = scanner.nextInt();
        Order order;

        switch (shippingType) {
            case 1:
                order = new StandardOrder(orderDetails);
                break;
            case 2:
                order = new ExpressOrder(orderDetails);
                break;
            default:
                System.out.println("Tipo de envío no válido.");
                return;
        }

        CustomerNotificationService notificationService = new CustomerNotificationService();
        order.addObserver(notificationService);

        order.processOrder();
        shoppingCart.clearCart();
    }
    private void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%d. %s - $%.2f - %s\n", i + 1, product.getName(), product.getPrice(), product.getDescription());
        }
        System.out.println("Seleccione un producto para agregar al carrito (0 para volver):");
        int productChoice = scanner.nextInt();
        if (productChoice > 0 && productChoice <= products.size()) {
            shoppingCart.addProduct(products.get(productChoice - 1));
            System.out.println("Producto agregado al carrito.");
        }
    }

    private void filterProductsByCategory() {
        System.out.print("Ingrese la categoría para filtrar: ");
        String category = scanner.nextLine().trim();
        System.out.println("Filtrando por: " + category); // Debugging
        List<Product> filteredProducts = productService.filterByCategory(category);
        displayProducts(filteredProducts);
    }


    private void displayShoppingCart() {
        List<Product> cartProducts = shoppingCart.getProducts();
        if (cartProducts.isEmpty()) {
            System.out.println("El carrito de compras está vacío.");
            return;
        }
        cartProducts.forEach(product -> System.out.printf("%s - $%.2f\n", product.getName(), product.getPrice()));
        System.out.println("Total: $" + shoppingCart.calculateTotal());
    }

    public static void main(String[] args) {
        new Main().displayMenu();
    }
}
