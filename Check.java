
/**
 * Klasse Check mit einer check Methode um eingaben zu prüfen
 * 
 * @author Samantha Maass & Huseein Abbas 
 * @version 14.04.2019 
 */
public class Check
{
    /**
     * leerer Konstruktor für Objekte der Klasse Check
     */
    public Check()
    {
    }
    
    /**
     * Check Methode
     * @param bediengung 
     * @return fehlermeldung wenn die bedingung nicht erfüllt ist
     */
    public static void check (boolean bedingung, String msg)
    {
       if (!bedingung)
       throw new IllegalArgumentException(msg);
    }
}
