import java.util.Arrays;
import java.util.Random;


public class Lab3 {
    public static void main(String[] args){
       System.out.println("Comparing 10,000 random testInts from 1 to 1,000,000 5 times...");
       normalTimSortComparison();
       System.out.println(" ");
       System.out.println("Comparing 10,000 ordered testInts from 1 to 1,000,000 5 times...");
       increasingOrdinalTimSortComparison();
       System.out.println(" ");
       System.out.println("Comparing 10 sorted sequences of 1,000 ordered elements from 1 to 1,000,000 5 times...");
       tenSortedTimSortComparison();
       System.out.println(" ");
       System.out.println("Comparing 100 sorted sequences of 100 ordered elements from 1 to 1,000,000 5 times...");
       hundredSortedTimSortComparison();
    }

    public static boolean isSorted(TestInteger A[]){
        for(int i = 0; i <= A.length-2; i++){
            if(!(A[i].value <= A[i + 1].value)){
                return false;
            }
        }
        return true;
    }

    public static void normalTimSortComparison(){
        int length = 10000;
        int bound = 1000000;
        int repititions = 5;
        Random rand = new Random();
        for(int j = 1; j<=repititions; j++){
            TestInteger testArray[] = new TestInteger[length];
            for (int i = 0; i < testArray.length; i++) {
                testArray[i] = new TestInteger();
                testArray[i].value = rand.nextInt(bound);
            }
            TestInteger timTestArray[] = testArray.clone();
            long start = System.currentTimeMillis();
            SortingMethods.quicksort(testArray, 0, testArray.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Trial " + j + " quicksort result: " + (end-start) + "ms with " + testArray[0].getComparisons() + " comparisons");
            start = System.currentTimeMillis();
            Arrays.sort(timTestArray);
            end = System.currentTimeMillis();
            System.out.println("Trial " + j + " TimSort result: " + (end-start) + " ms with " + timTestArray[0].getComparisons() + " comparisons");
            System.out.println();
        }
    }

    public static void increasingOrdinalTimSortComparison(){
        int length = 10000;
        int bound = 1000000;
        int repititions = 5;
        Random rand = new Random();
        for(int j = 1; j<=repititions; j++){
            TestInteger testArray[] = new TestInteger[length];
            int seed = rand.nextInt(bound-10001);
            testArray[0] = new TestInteger();
            testArray[0].value = seed;
            for (int i = 1; i < testArray.length; i++) {
                testArray[i] = new TestInteger();
                testArray[i].value = testArray[i-1].value + 1;
            }
            TestInteger timTestArray[] = testArray.clone();
            long start = System.currentTimeMillis();
            SortingMethods.quicksort(testArray, 0, testArray.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Trial " + j + " quicksort result: " + (end-start) + "ms with " + testArray[0].getComparisons() + " comparisons");
            start = System.currentTimeMillis();
            Arrays.sort(timTestArray);
            end = System.currentTimeMillis();
            System.out.println("Trial " + j + "TimSort result: " + (end-start) + " ms with " + timTestArray[0].getComparisons() + " comparisons");
            System.out.println();
        }
    }

    public static void tenSortedTimSortComparison(){
        int length = 10000;
        int bound = 1000000;
        int repititions = 5;
        Random rand = new Random();
        for(int j = 1; j<=repititions; j++){
            TestInteger testArray[] = new TestInteger[length];
            int seed = rand.nextInt(bound-1001);
            for (int i = 0; i <= 9; i++) {
                seed = rand.nextInt(bound-1001);
                testArray[i * 1000] = new TestInteger();
                testArray[i * 1000].value = seed;
                for(int k = 1; k < 1000; k++){
                    testArray[i * 1000 + k] = new TestInteger();
                    testArray[i * 1000 + k].value = testArray[i * 1000 + k - 1].value + 1;
                }
            }
            TestInteger timTestArray[] = testArray.clone();
            long start = System.currentTimeMillis();
            SortingMethods.quicksort(testArray, 0, testArray.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Trial " + j + " quicksort result: " + (end-start) + "ms with " + testArray[0].getComparisons() + " comparisons");
            start = System.currentTimeMillis();
            Arrays.sort(timTestArray);
            end = System.currentTimeMillis();
            System.out.println("Trial " + j + " TimSort result: " + (end-start) + " ms with " + timTestArray[0].getComparisons() + " comparisons");
            System.out.println();
        }
    }

    public static void hundredSortedTimSortComparison(){
        int length = 10000;
        int bound = 1000000;
        int repititions = 5;
        Random rand = new Random();
        for(int j = 1; j<=repititions; j++){
            TestInteger testArray[] = new TestInteger[length];
            int seed = rand.nextInt(bound-1001);
            for (int i = 0; i <= 99; i++) {
                seed = rand.nextInt(bound-101);
                testArray[i * 100] = new TestInteger();
                testArray[i * 100].value = seed;
                for(int k = 1; k < 100; k++){
                    testArray[i * 100 + k] = new TestInteger();
                    testArray[i * 100 + k].value = testArray[i * 100 + k - 1].value + 1;
                }
            }
            TestInteger timTestArray[] = testArray.clone();
            long start = System.currentTimeMillis();
            SortingMethods.quicksort(testArray, 0, testArray.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Trial " + j + " quicksort result: " + (end-start) + "ms with " + testArray[0].getComparisons() + " comparisons");
            start = System.currentTimeMillis();
            Arrays.sort(timTestArray);
            end = System.currentTimeMillis();
            System.out.println("Trial " + j + " TimSort result: " + (end-start) + " ms with " + timTestArray[0].getComparisons() + " comparisons");
            System.out.println();
        }
    }
}
