package app.models;

/**
 * The CartItem class contains information and properties needed to
 * create a CartItem object. Via its public methods one can access
 * information about cart item, such as the product it contains and it's quantity.
 */
public class CartItem {
    private Product product;
    private int quantity;

    /**
     * Constructor for the cart item.
     *
     * @param product  Object of type Product as the product of the cart item.
     * @param quantity This is the quantity of the product in the cart item.
     */
    public CartItem(Product product, int quantity) {
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    /**
     * Method used to calculate the total price for the cart item based on it's quantity.
     *
     * @return Double value, representing the summed up price of the cart item.
     */
    public double calculateProductPriceByQuantity() {
        return this.getProduct().getPrice() * this.getQuantity();
    }

    /**
     * Method used to print detailed information about the cart item.
     *
     * @return String value, representing the formatted information.
     */
    @Override
    public String toString() {
        return String.format("Product: %n%s%nQuantity: %s%n",
                this.getProduct().toString(), this.getQuantity());
    }

    /**
     * Getter method for the product of the cart item.
     *
     * @return Object of type Product, representing the product in the cart item.
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Setter method for the cart item's product.
     *
     * @param product Object of type Product to be set as the product of the cart item.
     */
    private void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Getter method for the cart item's quantity of the product.
     *
     * @return Integer value, representing the product's quantity in the cart item.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Setter method for the product's quantity of the cart item.
     *
     * @param quantity Integer value to be set as the quantity of the product.
     */
    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
