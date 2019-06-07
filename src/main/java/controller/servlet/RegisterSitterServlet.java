package controller.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import FormPopulator.FormPopulator;
import bean.Member;
import bean.Sitter;
import form.RegisterSitterForm;
import service.SitterService;

public class RegisterSitterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterSitterForm registerSitterForm= FormPopulator.populateFrom(req,RegisterSitterForm.class);
        Sitter sitter = new Sitter();
        String memberType = req.getParameter("membertype");
        if(memberType.equals("sitter")){
            sitter.setType(Member.MemberType.SITTER);
        }
        else if(memberType.equals("seeker")){
            sitter.setType(Member.MemberType.SEEKER);
        }
        sitter.setFirstName(registerSitterForm.getFirstName());
        sitter.setLastName(registerSitterForm.getLastName());
        sitter.setPhoneNumber(registerSitterForm.getPhone());
        sitter.setEmail(registerSitterForm.getEmail());
        sitter.setAddress(registerSitterForm.getAddress());
        sitter.setYearsOfExp(registerSitterForm.getExperience());
        sitter.setExpectedPay(registerSitterForm.getExpectedPay());
        sitter.setPassword(registerSitterForm.getPassword());
        SitterService.registerSitter(sitter);
        PrintWriter out = resp.getWriter();
        out.println("Saved in Database");
        req.setAttribute("success","Successfully Registered!!!!Please login to continue");
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }
}
