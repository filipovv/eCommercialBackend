package app.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Cart {
    private static final double VAT_COEFFICIENT = 0.20d;
    private static final double VAT_INCLUDED_COEFFICIENT = 1.20d;
    private static final double PRICE_UNDER_100_DELIVERY = 10;
    private static final double PRICE_BETWEEN_100_AND_200_DELIVERY = 5;

    private Set<CartItem> cartItems;
    private double deliveryFee;

    public Cart() {
        this.cartItems = new HashSet<>();
        this.setDeliveryFee();
    }

    public double calculateTotalVAT() {
        double sum = 0;
        for (CartItem cartItem : this.getCartItems()) {
            sum += cartItem.calculateProductPriceByQuantity() * VAT_COEFFICIENT;
        }
        return sum;
    }

    public double calculateTotalPriceForCartItems() {
        double sum = 0;
        for (CartItem cartItem : this.getCartItems()) {
            sum += cartItem.calculateProductPriceByQuantity() * VAT_INCLUDED_COEFFICIENT;
        }
        return sum;
    }

    public void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
        this.setDeliveryFee();
    }

    public void removeCartItem(CartItem cartItem) {
        this.cartItems.remove(cartItem);
        this.setDeliveryFee();
    }

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

    public Set<CartItem> getCartItems() {
        return Collections.unmodifiableSet(this.cartItems);
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee() {
        if (this.calculateTotalPriceForCartItems() < 100) {
            this.deliveryFee = PRICE_UNDER_100_DELIVERY;
        } else if (this.calculateTotalPriceForCartItems() > 100 && this.calculateTotalPriceForCartItems() < 200) {
            this.deliveryFee = PRICE_BETWEEN_100_AND_200_DELIVERY;
        } else {
            this.deliveryFee = 0;
        }
    }
}
