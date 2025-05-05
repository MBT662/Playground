import java.util.Scanner;
   
public class TestXWing {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of wings:");
        int numOfWings = scanner.nextInt();
        System.out.println("Enter the number of droids:");
        int numOfDroids = scanner.nextInt();
        XWing xwing = new XWing(numOfWings, numOfDroids);
        System.out.println("X-Wing created with " + xwing.getNumOfWings() + " wings and " + xwing.getNumOfDroids() + " droids.");
    }    
}
class WrongNumberOfWings extends Exception{
   
    public WrongNumberOfWings(int numOfWings) {
        super("X-Wing is not a valid X-Wing. It has " + numOfWings + " wings.");
    }

}
class WrongNumberOfDroids extends Exception {
    
    public WrongNumberOfDroids(int numOfDroids) {
        super("X-Wing is not a valid X-Wing. It has " + numOfDroids + " droids.");

    }
    
}
class XWing {

    private int numOfWings;
    private int numOfDroids;
    private Object test = // Reference, this reference is of type "Object" and called "test" (reference is called test)
            new String(); // Object of type "String", this is an instantiation. This is refernced by "test"
    new String(); //polymorphism

    

    public XWing(int numOfWings, int numOfDroids) {
        String test2 = (String) test; // Polymorphism, downcasting
        Object objj = (Object) test2; // Polymorphism, upcasting


        try {
            if (numOfDroids != 6) {
                throw new WrongNumberOfDroids(numOfDroids);
            }
            this.numOfDroids = numOfDroids;




            
        } catch (WrongNumberOfDroids e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("X-Wing created with " + numOfWings + " wings and " + numOfDroids + " droids.");
        }

        try { 
            if (numOfWings != 6) {
                throw new WrongNumberOfWings(numOfWings);
            }
            this.numOfWings = numOfWings;
        } catch (WrongNumberOfWings e) {
            System.out.println(e.getMessage());

        }
    }

  
    public int getNumOfWings() {
        return numOfWings;
    }
    
    public void setNumOfWings(int numOfWings) {
        this.numOfWings = numOfWings;
    }
    // Getter for numOfDroids
    public int getNumOfDroids() {
        return numOfDroids;
    }
 
    public void setNumOfDroids(int numOfDroids) {
        this.numOfDroids = numOfDroids;
    }
}

