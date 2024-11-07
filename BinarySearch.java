//Content Beyond Syllabus
//Siddhesh Kamthe (RBT22IT123)
import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input ArrayList elements from the user
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            arrayList.add(element);
        }

        // Step 2: Sort the ArrayList (Binary search requires sorted elements)
        Collections.sort(arrayList);
        System.out.println("Sorted ArrayList: " + arrayList);

        // Step 3: Input the key to search
        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();

        // Step 4: Perform custom binary search
        int index = binarySearch(arrayList, key);

        // Step 5: Display result
        if (index == -1) {
            System.out.println("Element not found in the ArrayList.");
        } else {
            System.out.println("Element found at index " + index);
        }
        sc.close();
    }

    // binary search implementation
    public static int binarySearch(ArrayList<Integer> arrayList, int key) {
        int low = 0;
        int high = arrayList.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arrayList.get(mid) == key) {
                return mid;  // Element found
            }

            if (arrayList.get(mid) < key) {
                low = mid + 1;  // Search in the right half
            } else {
                high = mid - 1;  // Search in the left half
            }
        }

        return -1;  // Element not found
    }
}
