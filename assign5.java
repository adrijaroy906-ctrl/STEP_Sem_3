import java.util.*;

class Player implements Comparable<Player> {

    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    Player(String name, int matchesPlayed,
           double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(
            int matchesPlayed,
            boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    /*
       Fantasy points used for ranking.
       A simple composite score based on the information provided in the question.
    */
    double fantasyPoints() {
        return battingAverage + matchesPlayed;
    }

    public int compareTo(Player other) {
        return Double.compare(
                other.fantasyPoints(),
                this.fantasyPoints());
    }

    static String draftAndRank(Player[] players) {

        ArrayList<Player> list = new ArrayList<>();

        for (Player p : players) {

            if (isDraftable(p.matchesPlayed) ||
                isDraftable(p.matchesPlayed, p.injured)) {

                list.add(p);
            }
        }

        Player[] draftable =
                list.toArray(new Player[0]);

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftable.length; i++) {

            result.append(i + 1)
                  .append(". ")
                  .append(draftable[i].name);

            if (i < draftable.length - 1)
                result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(
                Player.draftAndRank(players));
    }
}
