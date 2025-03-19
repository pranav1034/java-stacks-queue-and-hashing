import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        // HashMap to store the length of the sequence for a number
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;

        for (int num : nums) {
            // Only process if 'num' is not already in the map (avoid duplicates)
            if (!map.containsKey(num)) {
                // Get the length of consecutive numbers to the left and right of num
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                // Total sequence length including num
                int sum = left + right + 1;
                map.put(num, sum);

                // Update the longest sequence found so far
                longest = Math.max(longest, sum);
                map.put(num - left, sum);
                map.put(num + right,sum);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {10, 6, -1, 4, 5, 200, 1, 3, 2, 9, 0};
        int longest = longestConsecutive(nums);
        System.out.println("Longest consecutive sequence length: " + longest);
    }
}
