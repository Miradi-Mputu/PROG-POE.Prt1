import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        String firstName;
        String lastName;
        String username;
        String password;
        String cellPhoneNumber;

        // Input for first name
        firstName = JOptionPane.showInputDialog("Enter your first name:");

        // Input for last name
        lastName = JOptionPane.showInputDialog("Enter your last name:");

        // Username input loop
        boolean isUsernameValid;
        do {
            username = JOptionPane.showInputDialog("Enter a username (at least 5 characters and contains an underscore):");
            isUsernameValid = isValidUsername(username);
            if (!isUsernameValid) {
                JOptionPane.showMessageDialog(null, "Invalid username. Please try again.");
            }
        } while (!isUsernameValid);
        JOptionPane.showMessageDialog(null, "Username successfully captured: " + username);

        // Password input loop
        boolean isPasswordValid;
        do {
            password = JOptionPane.showInputDialog("Enter your password (8+ characters, capital letter, number, special character):");
            isPasswordValid = isValidPassword(password);
            if (!isPasswordValid) {
                JOptionPane.showMessageDialog(null, "Invalid password. Please try again.");
            }
        } while (!isPasswordValid);
        JOptionPane.showMessageDialog(null, "Password successfully captured.");

        // Cellphone input loop
        boolean isCellValid;
        do {
            cellPhoneNumber = JOptionPane.showInputDialog("Enter your cellphone number (must start with +27 and be 10 characters long):");
            isCellValid = isValidCellphone(cellPhoneNumber);
            if (!isCellValid) {
                JOptionPane.showMessageDialog(null, "Invalid cellphone number. Please try again.");
            }
        } while (!isCellValid);
        JOptionPane.showMessageDialog(null, "Cellphone number successfully added: " + cellPhoneNumber);
    }

    public static boolean isValidUsername(String username) {
        return username != null && username.length() <= 5 && username.contains("_");
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Iterate through each character of the password
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else {
                // Use a regular expression to check for special characters (anything not alphanumeric)
                Pattern specialPattern = Pattern.compile("[^a-zA-Z0-9]");
                Matcher specialMatcher = specialPattern.matcher(String.valueOf(c));
                if (specialMatcher.find()) {
                    hasSpecial = true;
                }
            }
        }
        // Return true only if all the required character types are present
        return hasUpper && hasLower && hasDigit && hasSpecial;

    }

    public static boolean isValidCellphone (String cellphoneNumber) {
        // Check if the string is not null or empty, matches the pattern of digits and/or '+', and has at least 8 characters
        return cellphoneNumber != null && cellphoneNumber.matches("^[0-9+]+$") && cellphoneNumber.length() >= 8;
    }

}