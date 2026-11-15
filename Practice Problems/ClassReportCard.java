import java.util.Scanner;

class Student {
    private String name;
    private int a, b, c;

    Student(String name) {
        this.name = name;
    }

    boolean setMarks(int x, int y, int z) {
        if (x < 0 || x > 100 || y < 0 || y > 100 ||
            z < 0 || z > 100)
            return false;

        a = x;
        b = y;
        c = z;
        return true;
    }

    int total() {
        return a + b + c;
    }

    double average() {
        return total() / 3.0;
    }

    char grade() {
        double avg = average();

        if (avg >= 80) return 'A';
        if (avg >= 70) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }

    public String toString() {
        return name + " total=" + total() +
               " avg=" + String.format("%.2f", average()) +
               " grade=" + grade();
    }
}

public class ClassReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] s = new Student[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student temp = new Student(name);

            if (temp.setMarks(a, b, c))
                s[count++] = temp;
            else
                System.out.println(name + " skipped: marks must be 0 to 100");
        }

        int passes = 0;

        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < count - 1 - i; j++) {
                if (s[j].total() < s[j + 1].total()) {
                    Student temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                    swapped = true;
                }
            }

            passes++;
            if (!swapped)
                break;
        }

        for (int i = 0; i < count; i++)
            System.out.println((i + 1) + ". " + s[i]);

        System.out.println("Sorted in " + passes + " passes");
        sc.close();
    }
}
