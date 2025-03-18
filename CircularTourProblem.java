import java.util.*;

class PetrolPump {
    int petrol, distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourProblem {

    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0, deficit = 0, surplus = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < pumps.length; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;
            queue.offer(i);

            // If surplus is negative, we can't continue, reset
            if (surplus < 0) {
                start = i + 1; // Move to the next pump
                deficit += surplus; // Store the deficit
                surplus = 0; // Reset surplus
                queue.clear(); // Restart the queue
            }
        }

        // If total surplus + deficit is non-negative, a solution exists
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        int startIndex = findStartingPoint(pumps);
        System.out.println((startIndex != -1) ? "Start at pump: " + startIndex : "No solution exists");
    }
}
