import bean.Member;
import bean.Seeker;
import bean.Sitter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditProfileForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Member member = (Member) session.getAttribute("member");

        if(member.getType().equals(Member.MemberType.SEEKER)){
            Seeker seeker=(Seeker)member;
            RequestDispatcher rd = req.getRequestDispatcher("editseekerprofile.jsp");
            req.setAttribute("Seeker",seeker);
            rd.forward(req, resp);
        }
        else {
            Sitter sitter=(Sitter)member;
            RequestDispatcher rd = req.getRequestDispatcher("editsitterprofile.jsp");
            req.setAttribute("Sitter",sitter);
            rd.forward(req, resp);
        }

    }
}
