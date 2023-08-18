package by.konanaw.demo.grokking_simplicity.megamart.iteration3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MegaMartMain {

    private static List<ShoppingCartItem> shoppingCart = new ArrayList<>();
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
            addItemToCart(new ShoppingCartItem(product.getName(), product.getPrice()));
        }
        System.out.println(shoppingCartTotal);
    }

    private static void addItemToCart(ShoppingCartItem cartItem) {
        shoppingCart = addItem(shoppingCart, cartItem);
        var total = calcTotal(shoppingCart);
        setCartTotalDom(total);
        updateShippingIcons(shoppingCart);
        updateTaxDom(total);
        shoppingCartTotal = total;
    }

    private static List<ShoppingCartItem> addItem(List<ShoppingCartItem> cart, ShoppingCartItem cartItem) {
        List<ShoppingCartItem> newCart = new ArrayList<>(cart); // clone, newCart - local variable
        newCart.add(cartItem);
        return newCart;
    }

    private static Double calcTotal(List<ShoppingCartItem> cart) {
        Double total = 0d;
        for (ShoppingCartItem item: cart) {
            total += item.getPrice();
        }
        return total;
    }

    private static void updateTaxDom(Double total) {
        setTaxDom(calcTax(total));
    }

    private static double calcTax(Double amount) {
        return amount * 0.10;
    }

    private static void setTaxDom(double v) {
        System.out.println("setTaxDom: " + v);
    }

    private static void updateShippingIcons(List<ShoppingCartItem> cart) {
        List<Button> buttons = getBuyButtonsDom();
        for (Button button : buttons) {
            var item = button.getItem();
            var expectedCart = addItem(cart, new ShoppingCartItem(item.getName(), item.getPrice()));
            if (getsFreeShipping(expectedCart))
                button.show_free_shipping_icon();
            else
                button.hide_free_shipping_icon();
        }
    }

    private static boolean getsFreeShipping(List<ShoppingCartItem> cart) {
        return calcTotal(cart) >= 20;
    }

    private static List<Button> getBuyButtonsDom() {
        return buttons;
    }

    private static void setCartTotalDom(Double total) {
        System.out.println("setCartTotalDom: " + total);
    }

}
