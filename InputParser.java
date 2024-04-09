//File Name: InputParser.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class whose methods are called for ensuring proper inputs
import java.util.HashMap;

public class InputParser {
    public InputParser() {
    }

    public static boolean queryInt(String input, int min, int max) {
        if (input == null) {
            System.out.println("Invalid input, please try again");
            return false;
        } else {
            try {
                int number = Integer.parseInt(input);
                if (number >= min && number <= max) {
                    return true;
                } else {
                    System.out.println("Number exceeded valid boundaries, please try again");
                    return false;
                }
            } catch (NumberFormatException var4) {

                return false;
            }
        }
    }

    public static boolean selectQuit(String input) {
        if (input == null) {
            return false;
        } else {
            return input.equals("q") || input.equals("Q");
        }
    }

    public static boolean isValidString(String input) {
        return input != null;
    }

    public static int queryBoolean(String input) {
        if (isValidString(input)) {
            String value = input.toLowerCase();
            if (value.equals("n")) {
                return 0;
            } else if (value.equals("y")) {
                return 1;
            } else {
                System.out.println("Invalid input, please try again");
                return 2;
            }
        } else {
            System.out.println("Invalid input, please try again");
            return 2;
        }
    }

    public static int slideInput(String input, HashMap<Integer, Boolean> validEntries) {
        if (!input.equals("Q") && !input.equals("q")) {
            if (input != null && queryInt(input, 1, Integer.MAX_VALUE)) {
                if (validEntries.get(Integer.parseInt(input)) == null) {
                    System.out.println("This tile does not exist in the set.");
                    return -1;
                } else if (!(Boolean)validEntries.get(Integer.parseInt(input))) {
                    System.out.println("This tile cannot be moved.");
                    return -1;
                } else {
                    return Integer.parseInt(input);
                }
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }
}
