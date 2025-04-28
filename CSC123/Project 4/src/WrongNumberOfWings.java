// Super class is Exception
// Subclass is WrongNumberOfWings
public class WrongNumberOfWings extends Exception{
    // Constructor
    public WrongNumberOfWings(int numOfWings) {
        super("X-Wing is not a valid X-Wing. It has " + numOfWings + " wings.");
    }

}