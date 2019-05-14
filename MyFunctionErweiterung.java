import java.util.function.IntPredicate;
/**
 * Erweitert das Interface MyFunction um 2 Methoden
 * 
 * @author Samantha Maass & Hussein Abbas
 * @version 12.05.2019
 **/
 
public interface MyFunctionErweiterung extends MyFunction
{
    /**
     * ueberprueft ob der uebergebende wert dem predicate entspricht
     * 
     * @param predicate
     * @return wert wenn ja; 0 wenn nein
     */
    default public MyFunctionErweiterung conditionInput (IntPredicate predicate)
    {
      return (int wert) ->
      {
          if(predicate.test(wert))
          {
              return apply(wert);
          }
          else
          {
              return 0;
          }
      };
    }
    
    /**
     * ueberprueft ob der berechnete wert dem predicate entspricht
     * 
     * @param predicate
     * @return wert wenn ja; 0 wenn nein
     */
    default public MyFunctionErweiterung conditionOutput (IntPredicate predicate)
    {
      return (int wert) ->
      {
          if(predicate.test(apply(wert)))
          {
              return apply(wert);
          }
          else
          {
              return 0;
          }
      };
    }
}
