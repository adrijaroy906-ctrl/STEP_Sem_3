import java.util.Arrays;

public class DiceSort {
    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 4, 4};
        int[] count = new int[7];

        for (int num : rolls)
            count[num]++;

        System.out.print("Counts: ");

        for (int i = 1; i <= 6; i++)
            System.out.print(i + ":" + count[i] + " ");

        int[] result = new int[rolls.length];
        int k = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++)
                result[k++] = i;
        }

        System.out.println("\nSorted: " + Arrays.toString(result));
    }
}
