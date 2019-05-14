
/**
 * Klasse Fakultaet.
 * beinhaltet zwei weitere arten die Fakultaet zu berechnen
 * 
 * @author Samantha Maass & Hussein Abbas
 * @version 12.05.2019
 */
public class Fakultaet
{
     /**
     * Leerer Konstruktor
     */    
    public void Fakultaet ()
    {
    }
    
    /**
     * Berechnet f(x) = x! 
     * als Top Level Klasse implementiert
     */
    public static void fakultaetTopLevel (int unteregrenze, int oberegrenze)
    {
        int zahl = 0;
        int wert = 0;
        
        for (int j = unteregrenze; j <= oberegrenze; j++)
        {
            wert = j;
            for (int i = 1 ; i <= j; i++) 
                wert = wert * i;
            System.out.println (wert);    
        }
    }
    
    /**
     * Berechnet f(x) = x! 
     * als static Nested Klasse implementiert
     */    
    public static class NestedClass
    {
        public static void fakultaetNestedClass (int unteregrenze, int oberegrenze)
        {
            int zahl = 0;
            int wert = 0;
        
            for (int j = unteregrenze; j <= oberegrenze; j++)
            {
                wert = j;
                for (int i = 1 ; i <= j; i++) 
                    wert = wert * i;
                    System.out.println (wert);  
            } 
        }
    }
}
    
