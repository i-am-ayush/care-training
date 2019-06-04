import bean.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class accountserve extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Member member = (Member) session.getAttribute("member");

        if(member==null){
            PrintWriter out = resp.getWriter();
            out.println("Please login first.");
        }
        else {
            if (member.getType() == Member.MemberType.SITTER) {
                RequestDispatcher rd = req.getRequestDispatcher("sitteraccount");
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("seekeraccount");
                rd.forward(req, resp);
            }
        }

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
