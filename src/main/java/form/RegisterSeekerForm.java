package form;

public class RegisterSeekerForm extends RegisterMemberForm {

    private String spouseName;
    private int noOfChildren;
    //    private Member membertype;
//    public enum Member{SEEKER,SITTER;
//        public static Member stringToEnum(String s) {
//            if (s.equals("SITTER"))
//                return SITTER;
//            return SEEKER;
//        }}
 //   private Map<String, String> errorMessage;


    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

//    public Map<String, String> vaidate() {
//        errorMessage = new HashMap<>();
//        validateFirstName();
//        validateLastName();
//        validateAddress();
//        validateEmail();
//        validatePhoneNo();
//        return errorMessage;
//
//
//    }
//
//    private void validateNoOfChildren() {
//        if (String.valueOf(noOfChildren).isEmpty()) {
//            errorMessage.put("No of Children", "Can't be empty!");
//        } else if (!String.valueOf(noOfChildren).matches("^0$|^[1-9][0-9]*$")) {
//            errorMessage.put("No of Children", "No zeros before any number allowed!");
//        }
//    }
//
//    private void validateSpouseName() {
//        if (spouseName.isEmpty()) {
//            errorMessage.put("spouseName", "Can't be empty!");
//        } else if (!spouseName.matches("[A-za-z]+")) {
//            errorMessage.put("spouseName", "Only characters allowed!");
//        }
//    }
//
//    private void validateFirstName() {
//        if (firstName.isEmpty()) {
//            errorMessage.put("firstName", "firstName can't be empty!");
//        } else if (!firstName.matches("[A-za-z]+"))
//            errorMessage.put("firstName", "firstName should consist of only alphabets");
//    }
//
//    private void validateLastName() {
//        if (email.isEmpty()) {
//            errorMessage.put("emailId", "Email id can't be empty!");
//        } else if (!lastname.matches("[A-za-z]+"))
//            errorMessage.put("lasttname", "lastname should consist of only alphabets");
//    }
//
//
//    private void validatePhoneNo() {
//        if (String.valueOf(phone).isEmpty()) {
//            errorMessage.put("phoneNo", "Phone number can't be empty!");
//        } else if (!String.valueOf(phone).matches("^[0-9]{10}$")) {
//            errorMessage.put("phoneNo", "Phone number should be of 10 digits only.");
//        }
//    }
//
//    private void validateEmail() {
//        if (email.isEmpty()) {
//            errorMessage.put("emailId", "Email id can't be empty!");
//        } else if (!email.matches("^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+.)+[a-z]{2,5}$")) {
//            errorMessage.put("emailId", "Incorrect email format");
//        } else if (MemberService.getMemberIdByEmail(email) > 0) {
//            errorMessage.put("emailId", "Account already exist with given emailId");
//        }
//    }
//
//    private void validateAddress() {
//        if (address.isEmpty()) {
//            errorMessage.put("address", "Address can't be empty!");
//        }
//    }

}
