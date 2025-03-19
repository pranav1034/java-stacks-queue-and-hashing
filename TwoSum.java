import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {5, 3, -18, -3, 11, -2, 2, -13, -12,};
        int target = 8;
        findTwoSum(arr, target);
    }
    public static void findTwoSum(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int num = target - arr[i];
            if(map.containsKey(num)){
                System.out.println("Pair found: "+num+" and "+arr[i]);
                System.out.println("The indices of the elements are: "+map.get(num)+" and "+i);
            }
            map.put(arr[i],i);
        }
    }
}
