public class ExceptionTest {
   public static void main(String[] args) {
      int number;
      String str;
      try {
         str = "xyz";
         number = Integer.parseInt(str);
         // Yetremy: throw new
         // Yet2efesh: "catch () {}"
         // This line will not be executed
         System.out.println("A");
      } catch (NumberFormatException e) {
         System.out.println("B");
      } catch (IllegalArgumentException e) {
         System.out.println("C");
      }
      System.out.println("D");
   }
}