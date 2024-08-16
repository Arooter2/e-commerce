import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        shoppingCart cart = new shoppingCart();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter product quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    product product = new product(name, price, quantity);
                    cart.addProduct(product);
                    System.out.println("Product added to cart.");
                    break;

                case "2":
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    cart.removeProduct(removeName);
                    System.out.println("Product removed from cart.");
                    break;

                case "3":
                    cart.displayCartItems();
                    break;

                case "4":
                    System.out.println("Total amount: $" + cart.calculateTotal());
                    System.out.println("Thank you for shopping!");
                    return;

                case "5":

                    System.out.print("Exiting");
                    for (int i=0;i<5;i++)
                    {
                        System.out.print(".");
                        Thread.sleep(400);
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("5"));

        scanner.close();
    }
}

