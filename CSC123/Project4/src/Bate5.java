import java.io.Serializable;

public class Bate5 implements Serializable{

    private int seedCount;
    private boolean color;
    // Application Programming Interface
    // API
    // Anything that we can access it from outside of class
    // is considered a part of the API (Bate5 API)
    public boolean fresh;

    public void getColor(){

    }

    public int getSize(){
        return 20;
    }
    
}

/*
 * Bate5a1[ // Bate5a1 is the object name (Bate5 Bate5a1 = new Bate5(Red, 3, D);)
 * Color: Red,
 * Age: 3 minutes,
 * Taste: Delicious,
 * ]
 * 
 * Bate5a2{
 * Color: Green,
 * Age: 5 minutes,
 * Taste: Bad,
 * }
 * 
 * 
 */