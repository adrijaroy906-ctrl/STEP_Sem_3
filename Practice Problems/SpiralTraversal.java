import java.util.ArrayList;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int top = 0, bottom = 2, left = 0, right = 2;
        ArrayList<Integer> list = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                list.add(a[top][i]);
            top++;

            for (int i = top; i <= bottom; i++)
                list.add(a[i][right]);
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    list.add(a[bottom][i]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    list.add(a[i][left]);
                left++;
            }
        }

        System.out.println(list);
    }
}
