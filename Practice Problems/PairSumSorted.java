public class PairSumSorted {
    static void pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                System.out.println("(" + nums[left] + ", " + nums[right] + ")");
                return;
            } else if (sum < target)
                left++;
            else
                right--;
        }

        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        pairSumSorted(new int[]{-4, -1, 0, 3, 5, 9}, 4);
        pairSumSorted(new int[]{1, 2, 3}, 10);
    }
}
