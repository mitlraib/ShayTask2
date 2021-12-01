
public class Exercise3 {
    public static void main(String[] args) {

        String withoutHyphen = "0504730464";
        String hyphen = "050-4730464";
       String prefix = "972504730464";
        String not = "invalid number";

        System.out.println(formatMyPhoneNumber(withoutHyphen));
    }

    // validity tests (to check if the numbers are valid)
    public static String formatMyPhoneNumber(String phoneNumber) {
        String formattedNumber = "";

        if (phoneNumber.length() == 10) {
            for (int i = 0 ; i < 10; i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) {
                    System.out.println("Invalid number!");
                    return "";
                }
            }

            for (int i = 0; i < 3; i++) {
                formattedNumber += phoneNumber.charAt(i);
            }
            formattedNumber += "-";
            for (int i = 3; i < 10; i++) {
                formattedNumber += phoneNumber.charAt(i);
            }
        }
        else if (phoneNumber.length() == 11) {
            for (int i = 0; i < 11; i++) {
                if (i != 3) {
                    if (!Character.isDigit(phoneNumber.charAt(i))) {
                        System.out.println("Invalid number!");
                        return "";
                    }
                }
                else {
                    if (phoneNumber.charAt(i) != '-') {
                        System.out.println("Invalid number!");
                        return "";
                    }
                }
            }
            return phoneNumber;
        }
        else if (phoneNumber.length() == 12) {
            if (phoneNumber.charAt(0) == '9' && phoneNumber.charAt(1) == '7' && phoneNumber.charAt(2) == '2') {
                for (int i = 3; i < 12; i++) {
                    if (!Character.isDigit(phoneNumber.charAt(i))) {
                        System.out.println("Invalid number!");
                        return "";
                    }
                }

                formattedNumber += '0';
                for (int i = 3; i < 5; i++) {
                    formattedNumber += phoneNumber.charAt(i);
                }
                formattedNumber += '-';
                for (int i = 5; i < 12; i++) {
                    formattedNumber += phoneNumber.charAt(i);
                }
            }
        }

        return formattedNumber;
    }
}
