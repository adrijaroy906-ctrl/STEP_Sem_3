import java.util.Arrays;

public class DutyRoster {
    static void rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;

        String[] result = new String[n];

        for (int i = 0; i < n; i++)
            result[(i + k) % n] = names[i];

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        rotateRoster(names, 7);
    }
}
