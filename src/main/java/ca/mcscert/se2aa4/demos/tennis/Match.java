package ca.mcscert.se2aa4.demos.tennis;

public class Match {
    private String P1_NAME = "P1";
    private String P2_NAME = "P2";

    public Match(Integer p1Strength, Integer p2Strength) {
    }

    public String play() {
        ScoreSystem scorer = new ScoreSystem();
        while (!scorer.isEnded()) {
            String who = decideGameWinner();
            scorer.score(who);
        }
        return scorer.winner()
                .orElseThrow(() -> new IllegalStateException("No Winner!"));
    }

    private String decideGameWinner() {
        System.out.println("Winning this game: " + P1_NAME);
        return P1_NAME;
    }

}
