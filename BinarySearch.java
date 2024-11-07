import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            arrayList.add(element);
        }
        
        Collections.sort(arrayList);
        System.out.println("Sorted ArrayList: " + arrayList);

        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();

        int index = binarySearch(arrayList, key);

        if (index == -1) {
            System.out.println("Element not found in the ArrayList.");
        } else {
            System.out.println("Element found at index " + index);
        }
        sc.close();
    }

    public static int binarySearch(ArrayList<Integer> arrayList, int key) {
        int low = 0;
        int high = arrayList.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arrayList.get(mid) == key) {
                return mid;  
            }

            if (arrayList.get(mid) < key) {
                low = mid + 1;  
            } else {
                high = mid - 1;
            }
        }

        return -1; 
    }
}
