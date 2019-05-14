/**
 * Klasse FunktionenLambda
 * beinhaltet alle Funktion als Lambda ausdrücke
 * f(x) = x^2
 * f(x) = x!
 * f(x) = x^(x+1)
 * f(x) = fib(x)
 * 
 * @author Samantha Maass & Hussein Abbas
 * @version 12.05.2019
 */
public class FunktionenLambda
{   
     /**
     * Leerer Konstruktor
     */
    public void FunktionenLambda ()
    {
    }
    
    /**
     * berechnet f(x) = x^2
     */
    public static MyFunction lQuadrieren = wert ->
    {
        return wert * wert;
    };
    
    /**
     * berechnet f(x) = x!
     */
    public static MyFunction lFakultaet = wert ->
    {
        int zahl = 1;
        
        for (int i = 2; i <= wert; i++) 
            zahl = zahl * i;
        
        return zahl;
    };

    /**
     * berechnet f(x) = x^(x+1)
     */
    public static MyFunction lQuadrierenPlusEins = wert ->
    {
        for (int i = 1; i <= wert+1; i++)
            wert = wert + wert;
            
        return wert;    
    };
    
    /**
     * berechnet f(x) = fib(x)
     */
    public static MyFunction lFibonacci = wert ->
    {   
        int fib1 = 0; 
        int fib2 = 1; 
        int fib3 = 0;
        
        for (int i = 3; i <= wert; i++)
        {   
            fib1 = fib2 + fib3;
            fib2 = fib1;
            fib3 = fib2;
        }
        
        return fib1;
    };
}
