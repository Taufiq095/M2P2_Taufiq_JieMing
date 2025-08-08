package Helper;

import java.util.regex.Pattern;

public class Data3Checker {


    /**
     * Regular expression for validating the local part of an email address.
     * The local part is the portion before the '@' symbol.
     * It allows alphanumeric characters, underscores, periods, and hyphens.
     * Note that for the printable characters, they must not be present as either
     * the first or last character and also do not appear consecutively.
     * The underscore character is the exception to this rule.
     */
    private static final String localEmail_REGEX = "^[a-zA-Z0-9_]([a-zA-Z0-9._-]*[a-zA-Z0-9_]|[a-zA-Z0-9._-])?$";

    /**
     * REGEX pattern for the local part of an email address,
     */
    private static final Pattern local_Pattern = Pattern.compile(localEmail_REGEX);

    /**
     * Regular expression for validating the domain part of an email address.
     * The domain part is the portion after the '@' symbol.
     * It allows alphanumeric characters, underscores, periods, and hyphens.
     * Note that for the printable characters, they must not be present as either
     * the first or last character and also do not appear consecutively.
     * The underscore character is the exception to this rule.
     * the “ .xxx ” part of the domain is allowed to have a range of minimum 2
     * to a maximum of 3 characters. In addition, only lowercase Latin letters
     * a to z are allowed.
     */
    private static final String domainEmail_REGEX = "^[a-zA-Z0-9]([a-zA-Z0-9.-]*[a-zA-Z0-9])?\\.[a-z]{2,3}$";

    /**
     * REGEX pattern for the domain part of an email address,
     */
    private static final Pattern domain_Pattern = Pattern.compile(domainEmail_REGEX);

    /**
     * Validates the local part of an email address against the defined regular expression.
     *
     * @param localPart The string representing the local part of an email address.
     * @return true if the local part is valid and matches the pattern.
     * Otherwise, false.
     */
    private static boolean validateLocalPart(String localPart) {
        if (localPart == null || localPart.isBlank()) {
            return false;
        } else return local_Pattern.matcher(localPart).matches();
    }

    /**
     * Validates the local part of an email address against the defined regular expression.
     *
     *@param domainPart The string representing the local part of an email address.
     *@return true if the local part is valid and matches the pattern.
     *Otherwise, false.
     */
    private static boolean validateDomainPart(String domainPart) {
        if (domainPart == null || domainPart.isBlank()) {
            return false;
        } else return domain_Pattern.matcher(domainPart).matches();
    }

    /**
     * Checks if a given string is a valid email address.
     *
     * @param email The string to be validated as an email address.
     * @return {@code true} if the string is a valid email address; {@code false} otherwise.
     */
    public static boolean isValidEmail(String email) {
        boolean result = false;
        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        String localPart = parts[0];
        String domainPart = parts[1];
        result = validateLocalPart(localPart) && validateDomainPart(domainPart);
        return result;
        }

    /**
     * Regular expression for validating a "data3" string format.
     */
    private static final String data3String_REGEX = "^[a-zA-Z0-9_]+";

    private static final Pattern data3Pattern = Pattern.compile(data3String_REGEX);

    /**
     * Checks if a given string conforms to the "data3" string format.
     * @param data3String The string to be validated as a "data3" string.
     * @return true if valid, false if not.
     */
    public static boolean isValidData3String(String data3String) {
        if (data3String == null || data3String.isBlank()) {
            return false;
        }  else return data3Pattern.matcher(data3String).matches();
    }
}
