//Lab Assignment : 3
//Siddhesh Kamthe (RBT22IT123)
import java.util.*;

public class MinMax {
    // Helper function to find the maximum and minimum in the array using divide and conquer
    public static int[] findMaxMin(int[] arr, int start, int end) {
        if (start == end) {
            // If there's only one element
            return new int[]{arr[start], arr[start]};
        }

        if (end == start + 1) {
            // If there are two elements
            if (arr[start] > arr[end]) {
                return new int[]{arr[start], arr[end]};
            } else {
                return new int[]{arr[end], arr[start]};
            }
        }

        // Divide the array into two halves
        int mid = (start + end) / 2;
        int[] leftResult = findMaxMin(arr, start, mid);     // Recur for left half
        int[] rightResult = findMaxMin(arr, mid + 1, end);  // Recur for right half

        // Merge the results
        int max = Math.max(leftResult[0], rightResult[0]);
        int min = Math.min(leftResult[1], rightResult[1]);

        // Return the final max and min for this part of the array
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        //display input array
        System.out.println("Entered Array is : ");
        for(int i : arr)    {
            System.out.print(i+" ");
        }
        System.out.println();

        // Call the divide and conquer function
        int[] result = findMaxMin(arr, 0, n - 1);

        // Output the maximum and minimum values
        System.out.println("Maximum element in the array: " + result[0]);
        System.out.println("Minimum element in the array: " + result[1]);
    }
}

