package controller.servlet;

import FormPopulator.FormPopulator;
import bean.Member;
import bean.Seeker;
import bean.Sitter;
import form.RegisterSitterForm;
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
        RegisterSitterForm registerSitterForm=FormPopulator.populate(req,RegisterSitterForm.class);
        Sitter sitter = new Sitter();
        HttpSession session = req.getSession();
        Member member = (Member) session.getAttribute("member");
        sitter.setType(Member.MemberType.SITTER);
        sitter.setId(member.getId());
        sitter.setFirstName(registerSitterForm.getFirstname());
        sitter.setLastName(registerSitterForm.getLastname());
        sitter.setPhoneNumber(registerSitterForm.getPhone());
        sitter.setEmail(registerSitterForm.getEmail());
        sitter.setAddress(registerSitterForm.getAddress());
        sitter.setYearsOfExp(registerSitterForm.getExperience());
        sitter.setExpectedPay(registerSitterForm.getExpectedpay());
        sitter.setPassword(registerSitterForm.getPassword());
        SitterService.editProfile(sitter);
        RequestDispatcher rd = req.getRequestDispatcher("profileredirect");
        session.removeAttribute("member");
        session.setAttribute("member", sitter);
        rd.forward(req, resp);
    }
}
