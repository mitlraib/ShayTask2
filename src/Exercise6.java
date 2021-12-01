public class Exercise6 {
    public static void main(String[] args) {

        int[] array1 = {12, 33, 66, 9, 11, 99};
        int[] array2 = {32, 34, 10, 88,11};

        int[] intersectionArray = intersection(array1,array2);

        for (int i = 0; i < intersectionArray.length; i++) {
            System.out.print(intersectionArray[i] + " ");
        }
        System.out.println();
        System.out.println(isStrangersArrays(array1,array2));
    }

    public static int[] intersection(int[] array1, int[] array2) {

        int[] intersectionArray;

        if (array1.length < array2.length) {
            intersectionArray = new int[array1.length];
        }
        else {
            intersectionArray = new int[array2.length];
        }

        int index = 0;
        boolean isThere;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {

                    // now checking if its already in the new array
                    isThere = false;
                    for (int k = 0; k < intersectionArray.length; k++) {
                        if (array1[i] == intersectionArray[k]) {
                            isThere = true;
                        }
                    }
                    if (!isThere) {
                        intersectionArray[index] = array1[i];
                        index++;
                    }
                }
            }
        }

        int[] finalArray = new int[index];

        for (int i = 0; i < finalArray.length; i++) {
            finalArray[i] = intersectionArray[i];
        }

        return finalArray;

    }

    public static boolean isStrangersArrays(int[] array1, int[] array2) {

        int[] array = intersection(array1, array2);

        return array.length == 0;
    }
}
