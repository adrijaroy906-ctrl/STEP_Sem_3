import java.util.Arrays;

public class PrizeTable {
    public static void main(String[] args) {
        int[] a = {45, 98, 69, 75};
        int swaps = 0;

        for (int i = 0; i < a.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[max])
                    max = j;
            }

            if (max != i) {
                int temp = a[i];
                a[i] = a[max];
                a[max] = temp;
                swaps++;
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println("Swaps: " + swaps);
    }
}
