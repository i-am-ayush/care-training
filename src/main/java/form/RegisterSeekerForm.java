package form;

import bean.Member;
import service.MemberService;

import java.util.HashMap;
import java.util.Map;

public class RegisterSeekerForm extends Form {
    private String firstname;
    private String lastname;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpousename() {
        return spousename;
    }

    public void setSpousename(String spousename) {
        this.spousename = spousename;
    }

    public int getChildren() {
        return children;
    }

//    public Member getMembertype() {
//        return membertype;
//    }
//
//    public void setMembertype(Member membertype) {
//        this.membertype = membertype;
//    }

    public void setChildren(int children) {
        this.children = children;
    }

    //public enum Status {ACTIVE, INACTIVE}
    //private Status status;
    private int phone;
    private String email;
    private String address;
    private String password;
    private String spousename;
    private int children;
    //    private Member membertype;
//    public enum Member{SEEKER,SITTER;
//        public static Member stringToEnum(String s) {
//            if (s.equals("SITTER"))
//                return SITTER;
//            return SEEKER;
//        }}
    private Map<String, String> errorMessage;

    public Map<String, String> vaidate() {
        errorMessage = new HashMap<>();
        validateFirstName();
        validateLastName();
        validateAddress();
        validateEmail();
        validatePhoneNo();
        return errorMessage;


    }
    private void validateNoOfChildren() {
        if (String.valueOf(children).isEmpty()) {
            errorMessage.put("No of Children", "Can't be empty!");
        } else if (!String.valueOf(children).matches("^0$|^[1-9][0-9]*$")) {
            errorMessage.put("No of Children", "No zeros before any number allowed!");
        }
    }

    private void validateSpouseName() {
        if (spousename.isEmpty()) {
            errorMessage.put("spousename", "Can't be empty!");
        } else if (!spousename.matches("[A-za-z]+")) {
            errorMessage.put("spousename", "Only characters allowed!");
        }
    }

    private void validateFirstName() {
        if (firstname.isEmpty()) {
            errorMessage.put("firstname", "firstname can't be empty!");
        } else if (!firstname.matches("[A-za-z]+"))
            errorMessage.put("firstname", "firstname should consist of only alphabets");
    }

    private void validateLastName() {
        if (email.isEmpty()) {
            errorMessage.put("emailId", "Email id can't be empty!");
        } else if (!lastname.matches("[A-za-z]+"))
            errorMessage.put("lasttname", "lastname should consist of only alphabets");
    }


    private void validatePhoneNo() {
        if (String.valueOf(phone).isEmpty()) {
            errorMessage.put("phoneNo", "Phone number can't be empty!");
        } else if (!String.valueOf(phone).matches("^[0-9]{10}$")) {
            errorMessage.put("phoneNo", "Phone number should be of 10 digits only.");
        }
    }

    private void validateEmail() {
        if (email.isEmpty()) {
            errorMessage.put("emailId", "Email id can't be empty!");
        } else if (!email.matches("^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+.)+[a-z]{2,5}$")) {
            errorMessage.put("emailId", "Incorrect email format");
        } else if (MemberService.getMemberIdByEmail(email) > 0) {
            errorMessage.put("emailId", "Account already exist with given emailId");
        }
    }

    private void validateAddress() {
        if (address.isEmpty()) {
            errorMessage.put("address", "Address can't be empty!");
        }
    }

}
