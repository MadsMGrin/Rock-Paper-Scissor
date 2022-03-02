package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

//Java imports
import java.util.ArrayList;
import java.util.Random;

/**
 * Example implementation of a player.
 *
 * @author smsj
 */
public class Player implements IPlayer {

    private String name;
    private PlayerType type;

    /**
     * @param name
     */
    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
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
     * @param state Contains the current game state including historic moves/results
     * @return Next move
     */
    @Override
    public Move doMove(IGameState state) {
        Random rand = new Random();
        int doMove = rand.nextInt(3);

        //Historic data to analyze and decide next move...
        ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();

        if (state.getRoundNumber() <= 10) {
            if (doMove == 0) {
                return Move.Rock;
            }
            if (doMove == 1) {
                return Move.Paper;
            }
            if (doMove == 2) {
                return Move.Scissor;
            } else return Move.Rock;
        } else {
            if (results.get(state.getRoundNumber() - 2).getWinnerPlayer().getPlayerType() == PlayerType.AI) {
                if (results.get(state.getRoundNumber() - 2).getLoserMove() == Move.Rock) {
                    return Move.Paper;
                }
                if (results.get(state.getRoundNumber() - 2).getLoserMove() == Move.Paper) {
                    return Move.Scissor;
                }
                if (results.get(state.getRoundNumber() - 2).getLoserMove() == Move.Scissor) {
                    return Move.Rock;
                }
            }
        }
        return Move.Rock;
    }
}
