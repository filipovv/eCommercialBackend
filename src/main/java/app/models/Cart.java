package app.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The Cart class contains information and properties needed to
 * create a Cart object. Via its public methods one can access
 * information about the cart, add or remove items from it and
 * calculate total price or VAT.
 */
public class Cart {
    private static final double VAT_COEFFICIENT = 0.20d;
    private static final double VAT_INCLUDED_COEFFICIENT = 1.20d;
    private static final double PRICE_UNDER_100_DELIVERY = 10;
    private static final double PRICE_BETWEEN_100_AND_200_DELIVERY = 5;

    private Set<CartItem> cartItems;
    private double deliveryFee;

    /**
     * Constructor for the cart.
     */
    public Cart() {
        this.cartItems = new HashSet<>();
        this.calculateDeliveryFee();
    }

    /**
     * Method used to calculate the delivery fee by the total price of the items in the cart.
     */
    private void calculateDeliveryFee() {
        if (this.calculateTotalPriceForCartItems() < 100) {
            this.deliveryFee = PRICE_UNDER_100_DELIVERY;
        } else if (this.calculateTotalPriceForCartItems() > 100 && this.calculateTotalPriceForCartItems() < 200) {
            this.deliveryFee = PRICE_BETWEEN_100_AND_200_DELIVERY;
        } else {
            this.deliveryFee = 0;
        }
    }

    /**
     * Method used to calculate the summed VAT for all cart items in the cart.
     *
     * @return Double value, representing the total VAT.
     */
    public double calculateTotalVAT() {
        double sum = 0;
        for (CartItem cartItem : this.getCartItems()) {
            sum += cartItem.calculateProductPriceByQuantity() * VAT_COEFFICIENT;
        }
        return sum;
    }

    /**
     * Method used to calculate the total price of the cart items in the cart, VAT included.
     *
     * @return Double value, representing the total price, including VAT.
     */
    public double calculateTotalPriceForCartItems() {
        double sum = 0;
        for (CartItem cartItem : this.getCartItems()) {
            sum += cartItem.calculateProductPriceByQuantity() * VAT_INCLUDED_COEFFICIENT;
        }
        return sum;
    }

    /**
     * Method used to add items in the cart.
     *
     * @param cartItem Object of type CartItem to be added in the cart.
     */
    public void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
        this.calculateDeliveryFee();
    }

    /**
     * Method used to remove items from the cart.
     *
     * @param cartItem Object of type CartItem to be removed from the cart.
     */
    public void removeCartItem(CartItem cartItem) {
        this.cartItems.remove(cartItem);
        this.calculateDeliveryFee();
    }

    /**
     * Method used to display detailed information about the cart.
     *
     * @return String value, representing formatted information.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart items:").append(System.lineSeparator());
        for (CartItem cartItem : cartItems) {
            sb.append(cartItem.toString()).append(System.lineSeparator());
        }
        sb.append(String.format("Delivery fee: %s", this.getDeliveryFee())).append(System.lineSeparator());
        return sb.toString();
    }

    /**
     * Getter method for the cart items collection.
     *
     * @return Unmodifiable collection of type Set, representing the cart items.
     */
    public Set<CartItem> getCartItems() {
        return Collections.unmodifiableSet(this.cartItems);
    }

    /**
     * Getter method for the delivery fee, calculated for the whole cart.
     *
     * @return Double value, representing the delivery costs.
     */
    public double getDeliveryFee() {
        return this.deliveryFee;
    }

}
