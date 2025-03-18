import java.util.Stack;

public class SortStackRecursively {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop(); // Remove the top element
            sortStack(stack);       // Recursively sort the rest of the stack
            insertInSortedOrder(stack, temp); // Insert the popped element in the right place
        }
    }

    // Function to insert an element into a sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: If stack is empty or top of stack is <= element, push it
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Pop the top element and recurse
        int temp = stack.pop();
        insertInSortedOrder(stack, element);

        // Push back the removed element
        stack.push(temp);
    }

    // Driver function to test
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
