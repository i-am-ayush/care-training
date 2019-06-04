package controller.servlet;

import bean.Member;
import bean.Seeker;
import bean.Sitter;
import service.SeekerService;
import service.SitterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditSitterProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Sitter sitter = new Sitter();

        HttpSession session = req.getSession();

        Member member = (Member) session.getAttribute("member");

        sitter.setType(Member.MemberType.SITTER);
        sitter.setId(member.getId());
        sitter.setFirstName(req.getParameter("firstname"));
        sitter.setLastName(req.getParameter("lastname"));
        sitter.setPhoneNumber(Integer.parseInt(req.getParameter("phone")));
        sitter.setEmail(req.getParameter("email"));
        sitter.setAddress(req.getParameter("address"));
        sitter.setYearsOfExp(Integer.parseInt(req.getParameter("experience")));
        sitter.setExpectedPay(Double.parseDouble(req.getParameter("expectedpay")));
        sitter.setPassword(req.getParameter("password"));

        SitterService.editProfile(sitter);

        RequestDispatcher rd = req.getRequestDispatcher("profileredirect");

        session.removeAttribute("member");
        session.setAttribute("member", sitter);

        rd.forward(req, resp);

    }
}
