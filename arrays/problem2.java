package arrays.KK.arrays;

public class problem2 {
    /*
        2- Find the greatest element and print its index too.
              {2, 96, 69, 77, 145, 20} = Max element = 145 found at 4 index
     */

    public static int findGreatest(int[] array) {

        int maxIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if(array[i] > array[maxIndex]){
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void main(String []args){
        int[] array = {2, 96, 69, 77, 145, 20};
        int index = findGreatest(array);
        System.out.println("max element "+ array[index] + " found at index " + index);

    }

}
