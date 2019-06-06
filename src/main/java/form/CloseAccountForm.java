package form;

import java.util.HashMap;
import java.util.Map;

public class CloseAccountForm extends Form {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//    private Map<String, String> errorMessage;
//    public Map<String, String> vaidate() {
//        errorMessage = new HashMap<>();
//        validateId();
//        return errorMessage;
//
//
//    }
//    private void validateId(){
//        if(id>0 && id<1000)
//            errorMessage.put("id","id is not valid");
//    }
}
