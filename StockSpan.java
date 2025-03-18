import java.util.Stack;

public class StockSpan {
    // Function to calculate stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            span[i] = (stack.isEmpty()) ? 0 : (i - stack.peek() - 1);
            // Push current index to stack
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {120, 60, 40, 75, 20, 95, 80};
        int[] span = calculateSpan(prices);

        // Print result
        System.out.print("Stock Span: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
