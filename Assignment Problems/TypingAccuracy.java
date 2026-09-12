import java.util.*;

class TypingAccuracy {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i))
                matched++;
            else if (firstMismatch == -1)
                firstMismatch = i;
        }

        double accuracy = (matched / (double) original.length()) * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%%n",
                matched, original.length(), accuracy);

        if (firstMismatch == -1 && original.length() == typed.length())
            System.out.println("No Mismatches");
        else if (firstMismatch != -1)
            System.out.println("First Mismatch at position "
                    + (firstMismatch + 1));
        else
            System.out.println("Length mismatch");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Original: ");
        String original = sc.nextLine();

        System.out.print("Typed: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);
    }
}
