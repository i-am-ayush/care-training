package controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import FormPopulator.FormPopulator;
import bean.Member;
import bean.Seeker;
import bean.Sitter;
import dao.SeekerDao;
import dao.SitterDao;
import form.RegisterSitterForm;
import service.SitterService;

public class RegisterSitterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterSitterForm registerSitterForm= FormPopulator.populate(req,RegisterSitterForm.class);
        Sitter sitter = new Sitter();
        String memberType = req.getParameter("membertype");
        if(memberType.equals("sitter")){
            sitter.setType(Member.MemberType.SITTER);
        }
        else if(memberType.equals("seeker")){
            sitter.setType(Member.MemberType.SEEKER);
        }
        sitter.setFirstName(registerSitterForm.getFirstname());
        sitter.setLastName(registerSitterForm.getLastname());
        sitter.setPhoneNumber(registerSitterForm.getPhone());
        sitter.setEmail(registerSitterForm.getEmail());
        sitter.setAddress(registerSitterForm.getAddress());
        sitter.setYearsOfExp(registerSitterForm.getExperience());
        sitter.setExpectedPay(registerSitterForm.getExpectedpay());
        sitter.setPassword(registerSitterForm.getPassword());
        SitterService.registerSitter(sitter);
        PrintWriter out = resp.getWriter();
        out.println("Saved in Database");

    }
}
