package by.konanaw.demo.grokking_simplicity.megamart.iteration3;

public class Button {
    private final int id;
    private final Product item;

    public Button(int id, Product item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public Product getItem() {
        return item;
    }

    public void show_free_shipping_icon() {
        System.out.println("show_free_shipping_icon  " + this);
    }

    public void hide_free_shipping_icon() {
        System.out.println("hide_free_shipping_icon  " + this);
    }

    @Override
    public String toString() {
        return "Button{" +
                "id=" + id +
                ", item=" + item +
                '}';
    }
}
