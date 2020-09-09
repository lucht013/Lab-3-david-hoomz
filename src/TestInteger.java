public class TestInteger implements Comparable<TestInteger> {
    int value = 0;
    static long counter = 0;
    public static void main(String args[]){
        TestInteger n = new TestInteger();
    }

    @Override
    public int compareTo(TestInteger o) {
        counter++;
        if(value > o.value) {
            return 1;
        }else if(value < o.value){
            return -1;
        }else if(value == o.value){
            return 0;
        }
        return -999;

    }

    public long getComparisons(){
        return counter;
    }
}
