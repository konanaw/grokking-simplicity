package by.konanaw.demo.grokking_simplicity.megamart.iteration1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MegaMartMain {

    private static List<ShoppingCart> shoppingCart = new ArrayList<>();
    private static Double shoppingCartTotal = 0d;
    private static List<Product> products = Arrays.asList(
            new Product("shoes", 6.3d),
            new Product("t-shirt", 2.1d)
    );

    public static void main(String[] args) {
        for (Product product : products) {
            addItemToCart(product.getName(), product.getPrice());
        }
        System.out.println(shoppingCartTotal);
    }

    private static void addItemToCart(String name, Double price) {
        shoppingCart.add(new ShoppingCart(name, price));
        calcCartTotal();
    }

    private static void calcCartTotal() {
        shoppingCartTotal = 0d;
        for (var i = 0; i < shoppingCart.size(); i++) {
            var item = shoppingCart.get(i);
            shoppingCartTotal += item.getPrice();
        }
        setCartTotalDom();
        updateTaxDom();
    }

    private static void updateTaxDom() {
        setTtaxDom(shoppingCartTotal * 0.10);
    }

    private static void setTtaxDom(double v) {
        System.out.println(v);
    }

    private static void setCartTotalDom() {
        System.out.println("setCartTotalDom");
    }

}
