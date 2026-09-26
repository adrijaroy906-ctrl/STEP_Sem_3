import java.util.*;

class QuizScorecard {
    private int[] scores;

    QuizScorecard(int[] scores) {
        this.scores = scores;
    }

    int getTotalScore() {
        int total = 0;

        for (int score : scores)
            total += score;

        return total;
    }

    double getAverageScore() {
        return (double) getTotalScore() / scores.length;
    }

    int getHighestScore() {
        int highest = scores[0];

        for (int score : scores) {
            if (score > highest)
                highest = score;
        }

        return highest;
    }

    public static void main(String[] args) {
        int[] scores = {8, 7, 9, 6, 10};

        QuizScorecard quiz = new QuizScorecard(scores);

        System.out.println("Total Score: " + quiz.getTotalScore());
        System.out.println("Average Score: " + quiz.getAverageScore());
        System.out.println("Highest Score: " + quiz.getHighestScore());
    }
}
