package by.konanaw.demo.grokking_simplicity.megamart.iteration3;

public class ShoppingCartItem {
    private final String name;
    private final Double price;

    public ShoppingCartItem(String name, Double price) {
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
