package controller.servlet;

import bean.Member;
import bean.Seeker;
import service.SeekerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditSeekerProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Seeker seeker = new Seeker();
        Member member = new Member();

        HttpSession session = req.getSession();
        member = (Member) session.getAttribute("member");

        seeker.setType(Member.MemberType.SEEKER);
        seeker.setId(member.getId());
        seeker.setFirstName(req.getParameter("firstname"));
        seeker.setLastName(req.getParameter("lastname"));
        seeker.setPhoneNumber(Integer.parseInt(req.getParameter("phone")));
        seeker.setEmail(req.getParameter("email"));
        seeker.setAddress(req.getParameter("address"));
        seeker.setSpouseName(req.getParameter("spousename"));
        seeker.setNoOfChildren(Integer.parseInt(req.getParameter("children")));
        seeker.setPassword(req.getParameter("password"));
        SeekerService.editProfile(seeker);

        RequestDispatcher rd = req.getRequestDispatcher("profileredirect");

        session.removeAttribute("member");
        session.setAttribute("member", seeker);

        rd.forward(req, resp);

    }
}
