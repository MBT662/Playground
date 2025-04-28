public class XWing {
    // These are global class variables/attributes
    private int numOfWings;
    private int numOfDroids;
    
    // These are class methods
    // Constructor
    public XWing(int numOfWings, int numOfDroids) {
        try {
            if (numOfDroids != 6) {
                throw new WrongNumberOfDroids(numOfDroids);
            }
            this.numOfDroids = numOfDroids;
        } catch (WrongNumberOfDroids e) {
            System.out.println("I'm Different Batee5, " + e.getMessage());
        }

        try { 
            if (numOfWings != 6) {
                throw new WrongNumberOfWings(numOfWings);
            }
            this.numOfWings = numOfWings;
        } catch (WrongNumberOfWings e) {
            System.out.println("I'm Special Batee5, " + e.getMessage());

        }
    }

    // Getter for numOfWings
    public int getNumOfWings() {
        return numOfWings;
    }
    // Setter for numOfWings
    public void setNumOfWings(int numOfWings) {
        this.numOfWings = numOfWings;
    }
    // Getter for numOfDroids
    public int getNumOfDroids() {
        return numOfDroids;
    }
    // Setter for numOfDroids
    public void setNumOfDroids(int numOfDroids) {
        this.numOfDroids = numOfDroids;
    }
}
