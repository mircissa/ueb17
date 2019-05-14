import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klasse FunktionDialog.
 * 
 * @author Samantha Maass & Hussein Abbas
 * @version 12.05.2019
 */
public class FunktionDialog
{
    private Scanner input = new Scanner(System.in);
    
    //Klassenkonstanten
    private static final int QUADRAT            = 1;
    private static final int FAKULTAET          = 2;
    private static final int QUADRIERENPLUSEINS = 3;
    private static final int FIBONACCI          = 4;
    private static final int GERADEQUADRAT      = 5;
    private static final int GERADEFAKULTAET    = 6;
    private static final int ENDE               = 0;
    
    private int wert;
    private int funktion;
    private int obereGrenze = 0;
    private int untereGrenze= 0;

    /**
     * Leerer Konstruktor
     */
    public FunktionDialog()
    {   
    }
    
    //Main Methode
    public static void main(String[] args) {
        new FunktionDialog().start();
    }
    
    /**
     * start menue
     */
    public void start()
    {
        funktion =  -1;
        while (funktion != ENDE) {
            try {
                funktion = functionWaehlen();
                Check.check(funktion < 7 && funktion >= 0, "ungültige Funktion");
                
                if (funktion != ENDE)
                    menue();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("falsche eingabe!");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
                input.nextLine();
            }
        }
    }
    
    /**
     * Menue -> Funktion Waehlen
     * f(x) = x^2
     * f(x) = x!
     * f(x) = x^(x+1)
     * f(x) = fib(x) 
     * 
     * @return Funktion als ganzzahliger wert (0-6)
     */
    private int functionWaehlen ()
    {
        System.out.println ("----------------------------------------" +
                            QUADRAT            + " f(x) = x^2 \n"      +
                            FAKULTAET          + " f(x) = x! \n"       +
                            QUADRIERENPLUSEINS + " f(x) = x^(x+2) \n"  +
                            FIBONACCI          + " f(x) = fib(x) \n"   +
                            GERADEQUADRAT      + " berechnet für gerade zahlen die Quadratzahl \n"  +
                            GERADEFAKULTAET    + " überprüft das ergebniss ob es gerade ist \n"     + 
                            ENDE               + " ende");
        return input.nextInt();
    }
    
    /**
     * setzt Obere & untere Grenze
     * -> 5 führt Quadrieren der geraden Zahlen aus
     * -> 6 gibt alle geraden ergebnisse der fakultaet berechnung zurück
     * -> rest springt in artWaehlen()
     */
    private void menue()
    {
        obereGrenze = obereGrenze();
        untereGrenze = untereGrenze();
        Check.check(obereGrenze > untereGrenze , "Untere Grenze muss kleiner als Obere Grenze sein!");
                
        if (funktion == 5) 
        {
            ApplyAndPrint.applyAndPrint(Praedikat.quadratLambda.conditionInput(Praedikat.even), untereGrenze, obereGrenze);                                           
        }
        else if (funktion == 6)
        {
            ApplyAndPrint.applyAndPrint(Praedikat.fakultaetLambda.conditionOutput(Praedikat.even), untereGrenze, obereGrenze);
        }
        else
        {
            artWaehlen();
        }
    }
    
    /**
     * Methode um Obere Grenze zu lesen
     */
    private int obereGrenze ()
    {
        System.out.println ("Obere Grenze angeben: ");
        return input.nextInt();
     }
    
    /**
     * Methode um untere Grenze zu lesen
     */     
    private int untereGrenze()
    {
        System.out.println ("untere Grenze angeben: ");
        return input.nextInt();
    }
    
    /**
     * menue um art zu waehlen
     * -> lambda oder Annonym
     * -> für fakultaet noch Nested Class & Top Level
     */
    private void artWaehlen ()
    {
        if (funktion != 2)
        {
            System.out.println ("art wählen: 1 -> Annonym; 2 -> Lambda");
            switch (input.nextInt())
            {
                case 1:
                    functionausfuehrenAnnonym();
                    break;
                case 2:
                    functionausfuehrenLambda();
                    break;
                default:
                    System.out.println("ungültige eingabe");
                    break;
            }
        }
        else if (funktion == 2)
        {   
            System.out.println ("art wählen : 1 -> Annonym; 2 -> Lambda; 3 -> Top Level; 4 -> Static Nested");
            switch (input.nextInt())
            {
                case 1:
                    functionausfuehrenAnnonym();
                    break;
                case 2:
                    functionausfuehrenLambda();
                    break;
                case 3:
                    Fakultaet.fakultaetTopLevel(untereGrenze, obereGrenze);
                    break;
                case 4:
                    Fakultaet.NestedClass.fakultaetNestedClass(untereGrenze, obereGrenze);
                    break;
                default:
                    System.out.println("ungültige eingabe");
                    break;
            }
        } 
        else
            System.out.println("ungültig");
        
    }
    
    /**
     * Wenn art Annonym gewahlt fuehrt er die passende funktion aus
     */
    private void functionausfuehrenAnnonym()
    {   
        switch (funktion) 
        {
            case 1:
                ApplyAndPrint.applyAndPrint(FunktionenAnnonym.aQuadrieren, untereGrenze, obereGrenze);
                break;
            case 2:
                ApplyAndPrint.applyAndPrint(FunktionenAnnonym.aFakultaet, untereGrenze, obereGrenze);
                break;
            case 3:
                ApplyAndPrint.applyAndPrint(FunktionenAnnonym.aQuadrierenPlusEins, untereGrenze, obereGrenze);
                break;
            case 4:
                ApplyAndPrint.applyAndPrint(FunktionenAnnonym.aFibonacci, untereGrenze, obereGrenze);
                break;    
            default:
                System.out.println ("ungültige Funktion");
                break;
        }    
    }  
    
    /**
     * wenn art Lambda gewahlt fuehrt er die passende funktion aus
     */
     private void functionausfuehrenLambda()
    {   
        switch (funktion) 
        {
            case 1:
                ApplyAndPrint.applyAndPrint(FunktionenLambda.lQuadrieren, untereGrenze, obereGrenze);
                break;
            case 2:
                ApplyAndPrint.applyAndPrint(FunktionenLambda.lFakultaet, untereGrenze, obereGrenze);
                break;
            case 3:
                ApplyAndPrint.applyAndPrint(FunktionenLambda.lQuadrierenPlusEins, untereGrenze, obereGrenze);
                break;
            case 4:
                ApplyAndPrint.applyAndPrint(FunktionenLambda.lFibonacci, untereGrenze, obereGrenze);
                break;
            default:
                System.out.println ("ungültige Funktion");
                break;
        }    
    }  
}
