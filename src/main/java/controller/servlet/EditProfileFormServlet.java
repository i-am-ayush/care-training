package controller.servlet;

import bean.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditProfileFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Member member = (Member) session.getAttribute("member");

        if(member.getType().equals(Member.MemberType.SEEKER)){
            RequestDispatcher rd = req.getRequestDispatcher("editseekerprofile.jsp");
            rd.forward(req, resp);
        }
        else {
            RequestDispatcher rd = req.getRequestDispatcher("editsitterprofile.jsp");
            rd.forward(req, resp);
        }

    }
}
