package app;

import app.models.Cart;
import app.models.CartItem;
import app.models.Product;

public class Application {
    public static void main(String[] args) {
        Product chocolate = new Product("Chocolate", 4.55);
        Product banana = new Product("Banana", 1.99);
        Product lemon = new Product("Lemon", 0.99);
        Product coffeeMachine = new Product("Coffee Machine", 199.97);

        CartItem cartItem1 = new CartItem(chocolate, 4);
        CartItem cartItem2 = new CartItem(banana, 2);
        CartItem cartItem3 = new CartItem(lemon, 10);
        CartItem cartItem4 = new CartItem(coffeeMachine, 1);
        Cart cart = new Cart();
        cart.addCartItem(cartItem1);
        cart.addCartItem(cartItem2);
        cart.addCartItem(cartItem3);
        cart.addCartItem(cartItem4);

        System.out.println(cart);
        System.out.printf("Total VAT for this cart: %.2f%n", cart.calculateTotalVAT());
        System.out.printf("Total price for this car including VAT: %.2f%n", cart.calculateTotalPriceForCartItems());

        cart.removeCartItem(cartItem4);

        System.out.println(cart);
        System.out.printf("Total VAT for this cart: %.2f%n", cart.calculateTotalVAT());
        System.out.printf("Total price for this car including VAT: %.2f%n", cart.calculateTotalPriceForCartItems());

    }
}
