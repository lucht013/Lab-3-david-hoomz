import java.util.Random;

public class testing {

    public static void main(String[] args){

        Random rand = new Random();
        TestInteger testArray[] = new TestInteger[25];

        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = new TestInteger();
            testArray[i].value = rand.nextInt(100);
        }

        for(int i = 0; i < testArray.length; i++){
            testArray[i] = new TestInteger();
            testArray[i].value = rand.nextInt(10);
        }

        System.out.print("Unsorted: [");
        for(int i = 0; i < testArray.length; i++){
            if (i < testArray.length-1){
                System.out.print(testArray[i].value + ", ");
            }else{
                System.out.print(testArray[i].value);
            }

        }
        System.out.print("]");
        System.out.println();

        SortingMethods.randomizedQuicksort(testArray, 0, testArray.length - 1);

        System.out.print("Unsorted: [");
        for(int i = 0; i < testArray.length; i++){
            if (i < testArray.length-1){
                System.out.print(testArray[i].value + ", ");
            }else{
                System.out.print(testArray[i].value);
            }

        }
        System.out.print("]");
        System.out.println();
    }
}
