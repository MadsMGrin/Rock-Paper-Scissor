package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

//Java imports
import java.awt.event.HierarchyBoundsAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Example implementation of a player.
 *
 * @author smsj
 */
public class Player implements IPlayer {

    private String name;
    private PlayerType type;
    private int turnTracker;
    private ArrayList<Move> results10;


    /**
     * @param name
     */
    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
        results10 = new ArrayList<>();
    }


    @Override
    public String getPlayerName() {
        return name;
    }


    @Override
    public PlayerType getPlayerType() {
        return type;
    }


    /**
     * Decides the next move for the bot...
     *
     * @param state Contains the current game state including historic moves/results
     * @return Next move
     */
    @Override
    public Move doMove(IGameState state) {
        Random rand = new Random();
        int doMove = rand.nextInt(3);

        //Historic data to analyze and decide next move...
        ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();

        turnTracker++;

        recordMoveSet(results);

        if (state.getRoundNumber() <= 10) {
            return randomMove(doMove);
        }
        else if (results.get(state.getRoundNumber() - 2).getWinnerPlayer().getPlayerType() == PlayerType.AI) {
            return reverseMove(results.get(state.getRoundNumber() - 2).getLoserMove());
        }
        else {
            return Move.Rock;
        }
    }

    public void recordMoveSet(ArrayList<Result> results){
        if(turnTracker == 10){
            for (int i = 0; i <= turnTracker-2; i++) {
                results10.add(results.get(i).getWinnerMove());
            }
            System.out.println(results10);
            weightOption();
        }
    }

    private void weightOption(){
        Map<Move, Integer> moveCount = new HashMap<>();

        for (Move s: results10) {
            Integer c = moveCount.get(s);
            if (c == null){
                c = new Integer(0);
            }
            c++;
            moveCount.put(s,c);
        }

        Map.Entry<Move, Integer> highestOccurance = null;
        for (Map.Entry<Move, Integer> e: moveCount.entrySet()){
            if(highestOccurance == null || highestOccurance.getValue() < e.getValue())
                highestOccurance = e;
        }

        if (highestOccurance != null){
            System.out.println("Best winning move" + highestOccurance.getKey());

        }
    }

    private Move randomMove(int doMove){
        if (doMove == 0) {
            return Move.Rock;
        }
        if (doMove == 1) {
            return Move.Paper;
        }
        if (doMove == 2) {
            return Move.Scissor;
        }
        else
            return Move.Rock;
    }

    private Move reverseMove(Move move) {
        if (move == Move.Rock) {
            return Move.Paper;
        }
        if (move == Move.Paper) {
            return Move.Scissor;
        }
        if (move == Move.Scissor) {
            return Move.Rock;
        }
        else
            return Move.Rock;
    }
}
