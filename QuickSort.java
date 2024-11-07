//Lab 1 : QuickSort Algorithm 
//Siddhesh Kamthe (RBT22IT123)

import java.util.*;

public class QuickSort{
    public static void main(String[] args){
        System.out.println("QuickSort algorithm in Java");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size : ");  //Input array size 
        int n = sc.nextInt();

        int[] arr = new int[n];
        //Input all array elements
        for(int i = 0; i < n; i++)  {
            System.out.println("Enter element " +(i+1) +" : ");
            arr[i] = sc.nextInt();
        }

        //Display array 
        System.out.println("Array Before sorting : ");
        for(int i : arr)    {
            System.out.print(i+" ");
        }
        System.out.println();
        //Calling QuickSort function
        QuSort(arr,0,n-1);

        
        System.out.println("Array After Sorting : ");
        //Display array 
        for(int i : arr)    {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void QuSort(int[] arr, int low, int high) {
        if( high > low) {
            int pivotInd = Partition(arr, low, high);
            //Recursively calling Partition function
            QuSort(arr,low,pivotInd-1);
            QuSort(arr,pivotInd+1, high);
        }
    }

    public static int Partition(int[] arr, int low, int high)   {
        int pivot = arr[high];
        int i = low-1;

        for(int j = low; j < high; j++) {
            if( arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i; //Pivot element index
    }
}