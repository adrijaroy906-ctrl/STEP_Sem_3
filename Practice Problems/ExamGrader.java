import java.util.*;

abstract class Question {
    String correct, answer;
    double points;

    Question(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return correct.equals(answer) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return correct.equals(answer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        int matches = 0;

        for (String word : correct.split(",")) {
            if (answer.toLowerCase().contains(word.trim().toLowerCase()))
                matches++;
        }

        if (matches >= 2)
            return points * 0.75;
        else if (matches == 1)
            return points * 0.50;
        else
            return 0;
    }
}

class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            java.util.regex.Matcher m =
                java.util.regex.Pattern.compile("\"([^\"]*)\"").matcher(line);

            String type = line.split(" ")[0];
            ArrayList<String> fields = new ArrayList<>();

            while (m.find())
                fields.add(m.group(1));

            double points = Double.parseDouble(
                line.substring(line.lastIndexOf('"') + 1).trim());

            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(fields.get(1), fields.get(2), points);
            else if (type.equals("TF"))
                q = new TF(fields.get(1), fields.get(2), points);
            else
                q = new Essay(fields.get(1), fields.get(2), points);

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
