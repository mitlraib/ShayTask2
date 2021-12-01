public class Exercise1 {

    public static void main(String[] args) {

        System.out.println(ifInclude("I eat apple", "apple"));
    }
    public static boolean ifInclude(String str1, String str2) {

        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        String substring;

        for (int i = 0; i < str1.length()-str2.length(); i++) {
            substring = "";
            for (int j = 0; j < str2.length(); j++) {
                substring += str1.charAt(i+j);
            }

            if (substring.equals(str2)) {
                return true;
            }
        }

        return false;

    }

}