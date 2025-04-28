public class WrongNumberOfDroids extends Exception {
    // Constructor
    public WrongNumberOfDroids(int numOfDroids) {
        super("X-Wing is not a valid X-Wing. It has " + numOfDroids + " droids.");
        // super();
        // super("Bala7");
        // super("Bate5 and number" + 5);
        // super("Bate5 azra2 " + 5 + " and number" + 5)
    }
    
}
