import bean.Member;
import service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Search extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");

        List<Member> activeMembers = MemberService.search(email);

        RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
        req.setAttribute("activeMembers", activeMembers);
        rd.forward(req, resp);

    }
}
