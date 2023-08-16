package by.konanaw.demo.grokking_simplicity.megamart.iteration2;

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
    private static List<Button> buttons = Arrays.asList(
            new Button(1, new Product("ball", 10d)),
            new Button(2, new Product("hat", 15.3d))
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
        for (ShoppingCart item: shoppingCart) {
            shoppingCartTotal += item.getPrice();
        }
        setCartTotalDom();
        updateShippingIcons();
        updateTaxDom();
    }

    private static void updateTaxDom() {
        setTaxDom(shoppingCartTotal * 0.10);
    }

    private static void setTaxDom(double v) {
        System.out.println("setTaxDom: " + v);
    }

    private static void updateShippingIcons() {
        List<Button> buttons = getBuyButtonsDom();
        for (Button button : buttons) {
            var item = button.getItem();
            if (item.getPrice() + shoppingCartTotal >= 20)
                button.show_free_shipping_icon();
            else
                button.hide_free_shipping_icon();
        }
    }

    private static List<Button> getBuyButtonsDom() {
        return buttons;
    }

    private static void setCartTotalDom() {
        System.out.println("setCartTotalDom: " + shoppingCartTotal);
    }

}
