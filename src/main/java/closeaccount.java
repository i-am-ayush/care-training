import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class closeaccount extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int memberid = Integer.parseInt(req.getParameter("id"));

        PrintWriter out = resp.getWriter();

        if(MemberService.deleteMemberById(memberid)==true){
            out.println("Account successfully closed");
        }
        else {
            out.println("Error occured while closing the account\n Try again");
        }

    }
}
