import java.util.Arrays;

public class HeightLineUp {
    public static void main(String[] args) {
        int[] a = {4, 2, 5, 1};
        int pass = 1;

        while (true) {
            boolean swapped = false;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(a));
            pass++;

            if (!swapped)
                break;
        }
    }
}
