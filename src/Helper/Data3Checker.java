package Helper;

import java.util.regex.Pattern;

public class Data3Checker {


    //email validation using REGEX, local before @, domain after @

    //   private static final String localEmail_REGEX
    private static final String localEmail_REGEX = "^[a-zA-Z0-9_]([a-zA-Z0-9._-]*[a-zA-Z0-9_]|[a-zA-Z0-9._-])?$";

    //    private static final Pattern local_Pattern
    private static final Pattern local_Pattern = Pattern.compile(localEmail_REGEX);

    //   private static final String domainEmail_REGEX
    private static final String domainEmail_REGEX = "^[a-zA-Z0-9]([a-zA-Z0-9.-]*[a-zA-Z0-9])?\\.[a-z]{2,3}$";

    //    private static final Pattern domain_Pattern = Pattern.compile(domainEmail_REGEX);
    private static final Pattern domain_Pattern = Pattern.compile(domainEmail_REGEX);

    private static boolean validateLocalPart(String localPart) {
        if (localPart == null || localPart.isBlank()) {
            return false;
        } else return local_Pattern.matcher(localPart).matches();
    }

    private static boolean validateDomainPart(String domainPart) {
        if (domainPart == null || domainPart.isBlank()) {
            return false;
        } else return domain_Pattern.matcher(domainPart).matches();
    }

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

    private static final String data3String_REGEX = "^[a-zA-Z0-9_]+";

    private static final Pattern data3Pattern = Pattern.compile(data3String_REGEX);

    public static boolean isValidData3String(String data3String) {
        if (data3String == null || data3String.isBlank()) {
            return false;
        }  else return data3Pattern.matcher(data3String).matches();
    }
}
