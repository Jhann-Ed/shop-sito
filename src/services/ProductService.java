package services;

import order.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product("Laptop", "High-performance laptop", 1200.00, "Electronics"));
        products.add(new Product("Smartphone", "Innovative smartphone with the best camera", 800.00, "Electronics"));
        products.add(new Product("Headphones", "Wireless headphones with noise-cancelling", 150.00, "Electronics"));
        products.add(new Product("T-shirt", "Comfortable cotton t-shirt", 20.00, "Clothing"));
        products.add(new Product("Jeans", "Slim-fit jeans", 50.00, "Clothing"));
        products.add(new Product("Sneakers", "Running shoes", 80.00, "Clothing"));
        products.add(new Product("Backpack", "Waterproof backpack", 40.00, "Accessories"));
        products.add(new Product("Watch", "Luxury watch", 300.00, "Accessories"));
        products.add(new Product("Sunglasses", "Polarized sunglasses", 100.00, "Accessories"));

    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> filterByCategory(String category) {
        List<Product> filtered = products.stream()
                .filter(product -> {
                    return product.getCategory().equalsIgnoreCase(category);
                })
                .collect(Collectors.toList());

        System.out.println("Encontrados: " + filtered.size()); // Debugging
        return filtered;
    }


}

