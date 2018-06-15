package app.models;


/**
 * The Product class contains information and properties needed to
 * create a Product object. Via its public methods one can access
 * information about the product, such as label and price.
 */
public class Product {
    private String label;
    private double price;

    /**
     * Constructor for the product.
     *
     * @param label This is the label of the product.
     * @param price This is the price of the product.
     */
    public Product(String label, double price) {
        this.setLabel(label);
        this.setPrice(price);
    }

    /**
     * Method used to print detailed information about the product.
     *
     * @return String value, representing formatted text as information.
     */
    @Override
    public String toString() {
        return String.format("Product label: %s%nProduct price: %.2f%n",
                this.getLabel(), this.getPrice());
    }

    /**
     * Getter method for the product's label.
     *
     * @return String value, representing the label of the product.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Setter method for the product's label.
     *
     * @param label String value to be set as the label of the product.
     */
    private void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter method for the product's price.
     *
     * @return Double value, representing the price of the product.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Setter method for the product's price.
     *
     * @param price Double value to be set as the price of the product.
     */
    private void setPrice(double price) {
        this.price = price;
    }
}
