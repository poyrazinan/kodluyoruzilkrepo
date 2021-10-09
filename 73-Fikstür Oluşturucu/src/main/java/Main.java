import java.util.*;

class Main {

    public static void main(String args[]) {

        List<String> teams = new ArrayList<>();

        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Boluspor");
        teams.add("Trabzonspor");

        System.out.println("Takımlar:");
        for (String team : teams)
            System.out.println("- " + team);

        if (teams.size()%2 != 0)
            teams.add("Bay");

        List<Game> games = new ArrayList<>();

        for (int i = 1; i <= teams.size(); i++) {
            for (int k = 1; k <= teams.size(); k++) {
                if (!teams.get(i-1).equals(teams.get(k-1)))
                    games.add(new Game(teams.get(i-1), teams.get(k-1)));
            }
        }

        int matches = teams.size()/2;
        int roundCount = games.size()/matches;

        LinkedHashMap<Integer, Rounds> rounds = new LinkedHashMap<>();
        for (int i = 1; i <= roundCount; i++) {
            Rounds round = new Rounds(matches, teams);
            for (int counter = 0; counter < matches; counter++) {
                List<Game> clonedGames = new ArrayList<>(games);
                for (Game game : clonedGames) {
                    if (round.addToRounds(game)) {
                        games.remove(game);
                        break;
                    }
                    else continue;
                }
            }
            rounds.put(i, round);
        }

        for (int key : rounds.keySet()) {
            System.out.println();
            System.out.println("Round " + key);
            rounds.get(key).printRound();
        }

    }

}
