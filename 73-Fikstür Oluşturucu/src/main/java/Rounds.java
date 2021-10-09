import java.util.ArrayList;
import java.util.List;

public class Rounds {

    private List<Game> rounds = new ArrayList<>();
    private int size;

    private List<String> teams = new ArrayList<>();

    public Rounds(int size, List<String> teams) {
        this.size = size;
        this.teams.addAll(teams);
    }

    public List<Game> getRounds() {
        return rounds;
    }

    public boolean addToRounds(Game game) {
        if (!teams.contains(game.getTeam1())
                || !teams.contains(game.getTeam2()))
            return false;
        teams.remove(game.getTeam1());
        teams.remove(game.getTeam2());
        rounds.add(game);

        return true;
    }

    public void printRound() {
        for (Game game : rounds)
            game.printGame();
    }
}
