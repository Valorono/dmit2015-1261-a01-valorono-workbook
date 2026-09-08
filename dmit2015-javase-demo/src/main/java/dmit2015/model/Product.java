package dmit2015.model;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Product name is required.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceWithTax() {
        return price * 1.05;
    }
}
