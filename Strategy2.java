import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * Class containing the 1st strategy.
 * @author	Kaiqiang
 */
public class Strategy2 extends Strategy
{
  /**
   * Encoding for strategy 2.
   */

  // 0 = defect, 1 = cooperate
  List<Integer> history;

   public Strategy2()
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
       float v_0 = 0;
       float v_1 = 0;
       for (int i = 0; i < 16; i++){
           int l = 1 << i;
           if (history.size() >= l){
               int cnt =  sum(history.subList(history.size() - l, history.size()));
               if (cnt * 2 > l)
                   v_0 += 1;
               else
                   v_1 += 1;
           }
       }
       if (v_0 > v_1)
           return 0;
       else
           return 1;
   }  /* nextMove */

}  /* class Strategy2 */

