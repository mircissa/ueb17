import java.util.function.IntPredicate;
/**
 * Klasse Praedikat.
 * 
 * @author Samantha Maass & Hussein Abbas
 * @version 12.05.2019
 */
public class Praedikat
{
    /**
     * Leerer Konstruktor
     */
    public Praedikat()
    {
    }
    
    /**
     * berechnet f(x) = x*x
     * mit uberprüfung
     */
    public static MyFunctionErweiterung quadratLambda = i -> i * i;

    /**
     * berechnet f(x) = x!
     * mit uberprüfung
     */
    public static MyFunctionErweiterung fakultaetLambda = i -> 
    {
        int wert = 1;
        for(int j = 1; j <= i; j++){
            wert =wert * i;
        }
        return wert;
    };
    
    /**
     * oberprüft ob ein wert gerade ist
     * als Lambda ausdruck
     */
    public static IntPredicate even = (int i) -> { return i%2 == 0;};
    
    /**
     * uberprüft ob ein wert nicht gerade ist
     * als Annonyme Klasse
     */
    static IntPredicate odd = new IntPredicate()
    {
        @Override
        public boolean test(int wert)
        {
            return wert % 2 != 0;
        }
    };
}
