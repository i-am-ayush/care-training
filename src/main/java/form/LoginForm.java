package form;

import java.util.HashMap;
import java.util.Map;

public class LoginForm extends Form {
    private String email;
    private String pass;
    private Map<String, String> errorMessage;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Map<String, String> vaidate() {
        errorMessage = new HashMap<>();
        validateEmail();
        validatePassword();
        return errorMessage;


    }

    private void validateEmail() {
        if (email.isEmpty()) {
            errorMessage.put("emailId", "Can't be empty");
        } else if (!email.matches("^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+\\.)+[a-z]{2,5}$")) {
            errorMessage.put("emailId", "Format incorrect!");
        }
    }

    private void validatePassword() {
        if (pass.isEmpty()) {
            errorMessage.put("password", "Can't be empty");
        }
    }

}

