import java.util.*;

public class ZeroSumSubarrays {

    public static void findZeroSumSubarrays(int[] arr) {

        // Map to store sum and list of indices where the sum occurs
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Initialize with sum = 0 at index -1 to handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the sum exists in the map, we found zero-sum subarrays
            if (sumMap.containsKey(sum)) {
                for (int startIdx : sumMap.get(sum)) {
                    System.out.println("Zero-sum subarray: " + Arrays.toString(Arrays.copyOfRange(arr, startIdx + 1, i + 1)));
                }
            }

            // Store the sum in the map
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, -8, -3, 11, -2, 2, 4, -13, -12, 25};
        findZeroSumSubarrays(arr);
    }
}
