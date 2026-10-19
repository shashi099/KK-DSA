package arrays.KK.arrays;

public class problem3 {
    /*

    3- Find the second greatest element
      {2, 96, 69, 77, 145, 20} = Second greatest element = 96

     */

    public static int findSecondGreatest(int[] array){

        int greatest = array[0];
        int second = array[1];

        for (int i = 0; i < array.length; i++) {
            if(array[i] > greatest){
                second = greatest;
                greatest = array[i];
            }else if(array[i] > second){
                second = array[i];
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] array = {201, 961, 69, 77, 145, 200};

        int ans = findSecondGreatest(array);
        System.out.println("Second Greatest " + ans);
    }

}
