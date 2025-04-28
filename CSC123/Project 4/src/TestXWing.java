import java.util.Scanner;   
public class TestXWing {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of wings:");
        int numOfWings = scanner.nextInt();
        System.out.println("Enter the number of droids:");
        int numOfDroids = scanner.nextInt();
        XWing xwing = new XWing(numOfWings, numOfDroids);
        
    }    
}
