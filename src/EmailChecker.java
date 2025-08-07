import java.util.regex.Pattern;

public class EmailChecker {


    //email validation using REGEX, local before @, domain after @

    //   private static final String localEmail_REGEX
    private static final String localEmail_REGEX = "[a-zA-Z0-9._-]+$";

    //    private static final Pattern local_Pattern
    private static final Pattern local_Pattern = Pattern.compile(localEmail_REGEX);

    //   private static final String domainEmail_REGEX
    private static final String domainEmail_REGEX = "^[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[a-z]{2,3}$";

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

        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        String localPart = parts[0];
        String domainPart = parts[1];
        return (validateLocalPart(localPart) && validateDomainPart(domainPart));
        }



    //check validity of email

//    private boolean validateLocalPart(String localPart) {
//        if (localPart == null || localPart.isBlank()) {
//            return false;
//        } else return local_Pattern.matcher(localPart).matches();
//    }
//
//    private boolean validateDomainPart(String domainPart) {
//        if (domainPart == null || domainPart.isBlank()) {
//            return false;
//        } else return local_Pattern.matcher(domainPart).matches();
//    }


}
