public class Exercise4 {


    public static int[] getUniqueArray(int[] array) {
        int count = 0;
        boolean hasZero = false;

        //  if 0 is in array
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                hasZero = true;
            }
        }

        // turn duplicated numbers to 0
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    array[i] = 0;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                count++;
            }
        }

        if (hasZero) {
            count++;
        }

        int[] newArray = new int[count];

        int j = 0;

        // j index won't overflow the newArray because of unique numbers counter.
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                newArray[j] = array[i];
                j++;
            }
        }

        return newArray;
    }
    public static void main(String[] args) {

        int[] array = {1,2,1,3,4,4, 9, 1, 5};

        int[] myArray = getUniqueArray(array);
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
    }
}
