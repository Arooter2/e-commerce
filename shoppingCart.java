import java.util.ArrayList;
import java.util.List;

public class shoppingCart {
    private List<product> cartItems;

    public shoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addProduct(product product) {
        for (product item : cartItems) {
            if (item.getName().equals(product.getName()))
            {
                item.setQuantity(item.getQuantity() + product.getQuantity());
                return;
            }
        }
        cartItems.add(product);
    }

    public void removeProduct(String productName) {
        cartItems.removeIf(item -> item.getName().equals(productName));
    }

    public double calculateTotal() {
        double total = 0;
        for (product item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void displayCartItems() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Cart Items:");
        for (product item : cartItems) {
            System.out.println(item.getName() + " - " + item.getQuantity() + " x $" + item.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

