import java.util.LinkedList;
import java.util.List;

/**
 * Class containing the 1st strategy.
 * @author	Kaiqiang
 */
public class Strategy1 extends Strategy
   {
  /**
   * Encoding for strategy1.
   */

  // 0 = defect, 1 = cooperate
  List<Integer> history;
  int sum;

   public Strategy1()
      {
      name = "Voting 32 history";
      opponentLastMove = 1;
      history = new LinkedList<Integer>();
      sum = 0;
      }  /* StrategyTitForTat */

   public int nextMove()
      {
          sum += opponentLastMove;
          history.add(opponentLastMove);
          if (history.size() > 32){
              sum -= history.get(0);
              history.remove(0);
          }
          if (sum * 2 > history.size())
              return 1;
          else {
              return 0;
          }

      }  /* nextMove */

   }  /* class Strategy1 */

