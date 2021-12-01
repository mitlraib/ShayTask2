public class Exercise5 {

    public static void main(String[] args) {


        int[] array = {1,3,6,11,10,9,11,4,2,0};

        System.out.println(isUpDownArray(array));
    }


    public static int isUpDownArray(int[] array) {
        int increasing = 0;

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] < array[i+1]) {
                increasing = i + 1;
            }
            else {
                break;
            }
        }

        if (increasing == 0 || increasing == array.length-1) {
            return -1;
        }


        for (int i = increasing + 1; i < array.length-1; i++) {
            if (array[i] < array[i+1]) {
                return -1;
            }
        }

        return increasing;
    }

}
