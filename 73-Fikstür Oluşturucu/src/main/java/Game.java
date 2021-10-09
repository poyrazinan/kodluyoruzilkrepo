public class Game {

    private String team1, team2;

    public Game(String team1, String team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void printGame() {
        System.out.println(team1 + " vs " + team2);
    }
}
