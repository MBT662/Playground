public interface WeshElmakan {
    public final String location = "Irvine";
    public final double area = 200;
    
    // Signature of the methods
    // input -> output
    // () -> ()
    public void openShop();
    public void closeShop();
    public void hireEmployee();

    // (int, int) -> (int)
    public int sellItem(int itemId, int quantity);

    // (String, int) -> (String)
    public String getOwnerName(String branch, int year);
}
