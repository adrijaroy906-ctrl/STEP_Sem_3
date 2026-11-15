import java.util.Scanner;

public class Rainfall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rain = new double[7];

        double total = 0, max = -1;
        int wettest = 0, dry = 0;

        for (int i = 0; i < 7; i++) {
            rain[i] = sc.nextDouble();
            total += rain[i];

            if (rain[i] > max) {
                max = rain[i];
                wettest = i;
            }

            if (rain[i] == 0)
                dry++;
        }

        System.out.print("Rainfall (mm): ");

        for (double x : rain)
            System.out.print(x + " ");

        System.out.printf("%nTotal Rainfall: %.2f mm%n", total);
        System.out.printf("Average Rainfall: %.2f mm%n", total / 7);
        System.out.printf("Wettest Day: Day %d (%.1f mm)%n",
                          wettest + 1, max);
        System.out.println("Total Dry Days: " + dry);

        sc.close();
    }
}
