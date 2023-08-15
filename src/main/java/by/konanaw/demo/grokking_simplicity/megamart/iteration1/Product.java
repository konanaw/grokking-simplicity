package by.konanaw.demo.grokking_simplicity.megamart.iteration1;

public class Product {
    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
