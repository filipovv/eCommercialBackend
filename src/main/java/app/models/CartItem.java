package app.models;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    public double calculateProductPriceByQuantity() {
        return this.getProduct().getPrice()*this.getQuantity();
    }

    @Override
    public String toString() {
        return String.format("Product: %n%s%nQuantity: %s%n",
                this.getProduct().toString(), this.getQuantity());
    }

    private Product getProduct() {
        return this.product;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    private int getQuantity() {
        return this.quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
