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

}
