import FormPopulator.FormPopulator;
import form.DeleteSitterApplicationForm;
import service.ApplicationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class deletesitterapplication extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DeleteSitterApplicationForm deleteSitterApplicationForm= FormPopulator.populate(req,DeleteSitterApplicationForm.class);

        int applicationId = deleteSitterApplicationForm.getId();

        if(ApplicationService.deleteApplicationById(applicationId)==true){
            RequestDispatcher rd = req.getRequestDispatcher("accountserve");
            rd.forward(req, resp);
        }
        else {
            PrintWriter out = resp.getWriter();
            out.println("Error deleting application: "+applicationId);
        }

    }
}
