import com.sun.jdi.Value;

import java.util.Arrays;
import java.util.Random;

public class SortingMethods {

    public static void quicksort(TestInteger A[], int p, int r){
        if(p < r){
            int q = partition(A, p, r);
            quicksort(A, p, q-1);
            quicksort(A,q + 1, r);
        }
    }

    private static int partition(TestInteger A[], int p, int r){
        TestInteger x = A[r];
        int i = p - 1;
        TestInteger swap = new TestInteger();
        for(int j = p; j < r; j++){
            int comparison = A[j].compareTo(x);
            if(comparison == -1 || comparison == 0){
                i++;
                swap = A[i];
                A[i] = A[j];
                A[j] = swap;
            }
        }
        swap = A[i + 1];
        A[i + 1] = A[r];
        A[r] = swap;
        return i + 1;
    }


    public static void randomizedQuicksort(TestInteger A[], int p, int r){
        if(p < r){
            int q = randomizedPartition(A, p, r);
            randomizedQuicksort(A, p, q-1);
            randomizedQuicksort(A,q + 1, r);
        }
    }

    private static int randomizedPartition(TestInteger A[], int p, int r){
        Random rand = new Random();
        int i = rand.nextInt((r - p) + 1) + p;
        TestInteger swap = new TestInteger();
        TestInteger swap2 = new TestInteger();
        swap = A[i];
        swap2 = A[r];
        A[r] = swap;
        A[i] = swap2;
        return partition(A, p, r);
    }

    private static int medianOfThreePivot(TestInteger A[], int p, int r){
        int indices[] = new int[3];
        int values[] = new int[3];
        TestInteger swap = new TestInteger();
        TestInteger swap2 = new TestInteger();

        Random rand = new Random();

        int i1 = rand.nextInt((r - p) + 1) + p;
        int i2 = rand.nextInt((r - p) + 1) + p;
        int i3 = rand.nextInt((r - p) + 1) + p;

        indices[0] = i1;
        indices[1] = i2;
        indices[2] = i3;

        values[0] = A[i1].value;
        values[1] = A[i2].value;
        values[2] = A[i3].value;

        //Arrays.sort(indices);
        Arrays.sort(values);

        int median = values[1];
        int i = 0;

        for (int j = 0; j < 3; j++){
            if (A[indices[j]].value == median){
                i = indices[j];
            }
        }
        //System.out.println(Arrays.toString(storage));


        swap = A[i];
        swap2 = A[r];
        A[r] = swap;
        A[i] = swap2;
        return partition(A, p, r);
    }

    public static void MOTPQuicksort(TestInteger A[], int p, int r){
        if(p < r){
            int q = medianOfThreePivot(A, p, r);
            MOTPQuicksort(A, p, q-1);
            MOTPQuicksort(A,q + 1, r);
        }
    }

    //source for `insertionSort` and `insertionSortQuickSort` goes to https://www.techiedelight.com/hybrid-quicksort/
    public static void insertionSort(TestInteger arr[], int low, int n) {
        // Start from second element (element at index 0
        // is already sorted)
        for (int i = low + 1; i <= n; i++)
        {
            TestInteger value = arr[i];
            int j = i;

            // Find the index j within the sorted subset arr[0..i-1]
            // where element arr[i] belongs
            while (j > low && arr[j - 1].compareTo(value) == 1)
            {
                arr[j] = arr[j - 1];
                j--;
            }
            // Note that subarray arr[j..i-1] is shifted to
            // the right by one position i.e. arr[j+1..i]

            arr[j] = value;
        }
    }

    public static void insertionSortQuickSort(TestInteger[] A, int low, int high) {
        while (low < high)
        {
            // do insertion sort if 10 or smaller
            if (high - low < 10)
            {
                insertionSort(A, low, high);
                break;
            }
            else
            {
                int pivot = partition(A, low, high);

                // tail call optimizations - recur on smaller sub-array
                if (pivot - low < high - pivot) {
                    insertionSortQuickSort(A, low, pivot - 1);
                    low = pivot + 1;
                } else {
                    insertionSortQuickSort(A, pivot + 1, high);
                    high = pivot - 1;
                }
            }
        }
    }
}