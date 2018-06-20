package app;

import app.models.Cart;
import app.models.CartItem;
import app.models.Product;

/**
 * The Application program implements an application that
 * creates objects of type Product, fills them in CartItems by quantity and adds them to a cart,
 * witch then provides functionality and information about the cart and the items in it.
 */
public class Application {
    public static void main(String[] args) {
        //Creating products
        Product chocolate = new Product("Chocolate", 4.55);
        Product banana = new Product("Banana", 1.99);
        Product lemon = new Product("Lemon", 0.99);
        Product coffeeMachine = new Product("Coffee Machine", 199.97);

        //Creating cart items with products of quantity
        CartItem chocolates = new CartItem(chocolate, 4);
        CartItem bananas = new CartItem(banana, 2);
        CartItem lemons = new CartItem(lemon, 10);
        CartItem coffeeMachines = new CartItem(coffeeMachine, 1);

        //Creating an empty cart
        Cart cart = new Cart();

        //Adding cart items to cart
        cart.addCartItem(chocolates);
        cart.addCartItem(bananas);
        cart.addCartItem(lemons);
        cart.addCartItem(coffeeMachines);

        //First print: all items in cart
        System.out.println(cart);
        System.out.printf("Total VAT for this cart: %.2f%n", cart.calculateTotalVAT());
        System.out.printf("Total price for this car including VAT: %.2f%n", cart.calculateTotalPriceForCartItems());

        //Remove one item from cart
        cart.removeCartItem(coffeeMachines);

        //Second print: all items after removing one of them
        System.out.println(cart);
        System.out.printf("Total VAT for this cart: %.2f%n", cart.calculateTotalVAT());
        System.out.printf("Total price for this car including VAT: %.2f%n", cart.calculateTotalPriceForCartItems());

    }
}
