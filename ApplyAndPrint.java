
/**
 * Klasse ApplyAndPrint.
 * 
 * @author Samantha Maass & Hussein Abbas
 * @version 12.05.2019
 */
public class ApplyAndPrint
{   
     /**
     * Leerer Konstruktor
     */    
    public void ApplyAndPrint ()
    {
    }
    
    /**
     * berechnet die werte von i bis j mit der angegebenen funktion und
     * gibt jedes Ergebnies aus
     * 
     * @param Funktion, untere Grenze, obere Grenze
     */
    public static void applyAndPrint(MyFunction function, int i, int j)
    {
        for (int k = i; k <= j; k++)
            System.out.println ( k + " : " + function.apply(k));   
    }
}
