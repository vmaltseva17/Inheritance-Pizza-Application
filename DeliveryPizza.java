class DeliveryPizza extends Pizza {
    // declares a new class named delivery pizza which extends the pizza class
    // this means delivery pizza inherits all the properties and methods of the pizza class
    private double deliveryFee;

    // declares a private instance variable of type double
    // stores the delivery fee for the pizza
    private String address;

    // declares a private instance variable address of type
    // holds the delivery address for the pizza

    public DeliveryPizza()
    // sets up constructor for delivery class that takes no arguments
     // intializes the delivery fee to 3 dollars
     // intializes address to an empty string
    {
        super();
        // calls the constructor to ensure that initialization defined in the superclass constructor

        this.deliveryFee = 3.0;
        this.address = "";
    }

    public DeliveryPizza(String[] toppings, String address, int numToppings)
            // declares another constructor method for the deliverypizza class which takes an array as arguments
    {
        super(toppings, numToppings);
        // ensures the superclass constructor is executed with these arguments

        if (super.toString().contains("Price: $"))
        // checks if the result of calling the toString() method on the superclass pizza contains the price string
        {
            double price = Double.parseDouble(super.toString().substring(super.toString().indexOf("$") + 1));
            // extracts the price of the pizza from the string representation returned by the superclass "toString" method
            // locates the position of $ and parses the substring after it as a double

            this.deliveryFee = (price > 18.0) ? 3.0 : 5.0;
            // sets the delivery fee depending on the price of the pizza (the more expensive pizza the less the delivery price)
        }
        this.address = address;
        // initializes the address instance variable with the provided class variable
    }

    public String toString() {
        return super.toString() + " This delivery is for: " + address + ". The fee will be $" + deliveryFee;
    }
}
    // returns a string representation of the delivery pizza object, including the string representation of the superclass pizza object
// it also prints out the delivery address and the fee for the delivery