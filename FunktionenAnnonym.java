/**
 * Klasse FunktionenLambda
 * beinhaltet alle Funktion als Annonyme Klassen
 * f(x) = x^2
 * f(x) = x!
 * f(x) = x^(x+1)
 * f(x) = fib(x)
 * 
 * @author Samantha Maass & Hussein Abbas
 * @version 12.05.2019
 */
public class FunktionenAnnonym
{
    /**
     * Leerer Konstruktor
     */
    public void FunktionenAnnonym ()
    {
    }
    
    /**
     * berechnet f(x) = x^2
     */
    static MyFunction aQuadrieren = new MyFunction ()
    {
        @Override
        public int apply (int wert)
        {
            return wert * wert;
        }
    };        
    
    /**
     * berechnet f(x) = x!
     */
    static MyFunction aFakultaet = new MyFunction ()
    {
        @Override
        public int apply (int wert)
        {
            int zahl = 1;
        
            for (int i = 2; i <= wert; i++) 
                zahl = zahl * i;
        
            return zahl;
        } 
    };
    
    /**
     * berechnet f(x) = x^(x+1)
     */
    static MyFunction aQuadrierenPlusEins = new MyFunction ()
    {
         @Override
         public int apply(int wert)
         {
             for (int i = 1; i <= wert+1; i++)
                wert = wert + wert;
            
             return wert;     
         }
    };
    
     /**
     * berechnet f(x) = fib(x)
     */
    static MyFunction aFibonacci = new MyFunction()
    {
         @Override
         public int apply(int wert)
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
         }
    };
    
}
