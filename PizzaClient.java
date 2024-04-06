
import java.util.Scanner;

public class PizzaClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] toppings = new String[10];
        int numToppings = 0;
        // line creates an array named toppings capable of holding 10 strings, which will store the toppings for the pizza
        // initializes an integer variable numToppings to 0, which will keep track of the number of toppings entered by the user

        System.out.println("Enter topping or Q to quit >> ");
        String topping = scanner.nextLine();


        while (!topping.equalsIgnoreCase("q") && numToppings < 10) {
            // starts a while loop that continues as long as the user input is not "Q" and the number of toppings is less 10
            toppings[numToppings++] = topping;
            // assigns the current topping to the toppings array at index "numToppings" and then increment "numToppings"
            System.out.println("Enter topping or q to quit >> ");
            topping = scanner.nextLine();
        }

        System.out.println("Is this for delivery? Y or N >> ");
        String deliveryChoice = scanner.nextLine();
        // stores user input in string delivery choice

        if (deliveryChoice.equalsIgnoreCase("Y")) {
            System.out.println("Enter delivery address >> ");
            String address = scanner.nextLine();
            // stores user input in address string
            DeliveryPizza pizza = new DeliveryPizza(toppings, address, numToppings);
            // creates a new delivery pizza object with the details provided by the client
            System.out.println(pizza.toString());
            // prints string representaton of the pizza obejct
        } else {
            Pizza pizza = new Pizza(toppings, numToppings);
            System.out.println(pizza.toString());
        }

        scanner.close();
    }
}