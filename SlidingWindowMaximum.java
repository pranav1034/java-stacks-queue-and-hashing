import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Remove elements smaller than the current element (they are useless)
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // Add current element index
            deque.offerLast(i);
            // Store the maximum element for the window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 13, 9, 2, 3, 5, 8, 6};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
