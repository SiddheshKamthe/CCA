import java.util.*;

public class SortMerge {
    public static void conquer(int[] arr,int st,int mid, int en)    {
        int[] merged = new int[en -st +1];

        int idx1 = st;
        int idx2 = mid+1;
        int x = 0;

        while(idx1 <= mid && idx2 <= en) {
            if(arr[idx1] <= arr[idx2])   {
                merged[x++] = arr[idx1++];
            }
            else {
                merged[x++] = arr[idx2++];
            }
        }

        while(idx1 <= mid)  {
            merged[x++] = arr[idx1++];
        }

        while(idx2 <= en)   {
            merged[x++] = arr[idx2++];
        }

        for(int i=0, j = st; i < merged.length; i++, j++)   {
            arr[j] = merged[i];
        }

    }
    public static void divide(int[] arr, int st, int en)  {
        if(st >= en)    {
            return;
        }
        int mid = st + (en-st)/2;
        divide(arr, st, mid);
        divide(arr,mid+1, en);

        conquer(arr, st, mid, en);

    }
    public static void main(String[] args) {
        System.out.println("MergeSort algorithm in Java");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size : ");   
        int n = sc.nextInt();

        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)  {
            System.out.println("Enter element " +(i+1) +" : ");
            arr[i] = sc.nextInt();
        }


        System.out.print("\nBefore Sorting : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        divide(arr, 0,n-1);

        System.out.print("\nAfter  Sorting : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
