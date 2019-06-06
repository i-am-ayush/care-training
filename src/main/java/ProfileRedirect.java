import bean.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProfileRedirect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Member member = (Member) session.getAttribute("member");

        System.out.println(member.getType());

        if(member.getType().equals(Member.MemberType.SEEKER)){
            RequestDispatcher rd = req.getRequestDispatcher("seekerprofile");
            rd.forward(req, resp);
        }
        else if(member.getType().equals(Member.MemberType.SITTER)){
            RequestDispatcher rd = req.getRequestDispatcher("sitterprofile.jsp");
            rd.forward(req, resp);
        }

    }
}
