package app.models;

public class Product {
    private String label;
    private double price;

    public Product(String label, double price) {
        this.setLabel(label);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        return String.format("Product label: %s%nProduct price: %.2f%n",
                this.getLabel(), this.getPrice());
    }

    public String getLabel() {
        return label;
    }

    private void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
}
