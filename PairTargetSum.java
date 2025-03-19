import java.util.*;

public class PairTargetSum {
    public static boolean hasPairWithSum(int[] arr, int target) {

        // HashMap to store visited numbers (key) and their indices (value)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = target - arr[i];

            // Check if the num is already in the map
            if (map.containsKey(num)) {
                System.out.println("Pair found: " + num + " and " + arr[i]);
                System.out.println("Indices of pair found:"+map.get(num)+" and "+i);
                return true;
            }
            // Otherwise, add the current number to the map
            map.put(arr[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 15, 18, -10, -8};
        int target = 13;
        int target2 = 8;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair with given sum exists.");
        } else {
            System.out.println("No pair with given sum exists.");
        }

        if (hasPairWithSum(arr, target2)) {
            System.out.println("Pair with given sum exists.");
        } else {
            System.out.println("No pair with given sum exists.");
        }
    }
}
