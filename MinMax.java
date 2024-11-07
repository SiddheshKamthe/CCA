import java.util.*;

public class MinMax {
    public static int[] findMaxMin(int[] arr, int start, int end) {
        if (start == end) {
            return new int[]{arr[start], arr[start]};
        }

        if (end == start + 1) {
            if (arr[start] > arr[end]) {
                return new int[]{arr[start], arr[end]};
            } else {
                return new int[]{arr[end], arr[start]};
            }
        }

        int mid = (start + end) / 2;
        int[] leftResult = findMaxMin(arr, start, mid);     
        int[] rightResult = findMaxMin(arr, mid + 1, end); 

        int max = Math.max(leftResult[0], rightResult[0]);
        int min = Math.min(leftResult[1], rightResult[1]);

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Entered Array is : ");
        for(int i : arr)    {
            System.out.print(i+" ");
        }
        System.out.println();

        int[] result = findMaxMin(arr, 0, n - 1);

        System.out.println("Maximum element in the array: " + result[0]);
        System.out.println("Minimum element in the array: " + result[1]);
    }
}

