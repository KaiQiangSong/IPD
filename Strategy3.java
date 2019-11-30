import java.util.ArrayList;
import java.util.List;

/**
 * Class containing the 1st strategy.
 * @author	Kaiqiang
 */
public class Strategy3 extends Strategy
{
  /**
   * Encoding for strategy 3.
   */

  // 0 = defect, 1 = cooperate
  List<Integer> history;

   public Strategy3()
      {
      name = "Voting multiple length of history";
      opponentLastMove = 1;
      history = new ArrayList<Integer>();
      }  /* StrategyTitForTat */

   public int sum(List<Integer> list){
       int sum = 0;
       for (int i : list)
            sum += i;
       return sum;
   }

   public int nextMove()
   {
       history.add(opponentLastMove);
       int result = 1;
       for (int i = 0; i < 16; i++){
           int l = 1 << i;
           double p = Math.pow(0.5, i);
           if (history.size() >= l){
               int cnt =  sum(history.subList(history.size() - l, history.size()));
               if ((cnt * 2 > l) && (Math.random() >= 1 - p ))
                   return 0;
           }
       }
       return 1;
   }  /* nextMove */

}  /* class Strategy2 */

