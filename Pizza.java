import java.util.Arrays;

class Pizza {
    // declares a class called pizza
    private String[] toppings;
    // defines variable toppings which is an array of strings to store the toppings of the pizza

    private double price;
    // defines variable of type double called price

    public Pizza() {
        // constructor for pizza class
        // initializes a pizza object with default values
        this.toppings = new String[15];
        // value one is an array of toppings with a length of ten but all elements are initialized to zero
        this.price = 14.0;
        // the default price is 14 dollars
    }

    public Pizza(String[] toppings, int numToppings) {
        this.toppings = Arrays.copyOf(toppings, numToppings);
        this.price = 14.0 + (2 * numToppings);
    }
    // another constructor for the pizza class which takes an array of toppings
    // and an integer representing the number of toppings as parameters
    // initializes a pizza object with the provided toppings and calculates the price
    // price is default price and 2 dollars per topping

    public String toString() {
        // method overrides the string method of the object class
        // constructs a string representation of the pizza object
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < toppings.length; i++) {
            if (toppings[i] != null) {
                description.append(toppings[i]);
                if (i < toppings.length - 1 && toppings[i + 1] != null)
                // ensures that the conditon continues to the second to last element of the toppings array
                    // if i reaches the last element, there won't be anymore toppings to follow, so
                    // no more commas need to be added
                    // then checks if the last element of the toppings array is not null
                    // overall this ensures that commas are added in the printed version of the toppings array
                {
                    description.append(", ");
                }
            }
        }
        return description.toString() + " pizza Price: $" + price;
    }
}
// iterates through the toppings array and appends each non-string object to a StringBuilder
// appends price to description and returns the resulting string