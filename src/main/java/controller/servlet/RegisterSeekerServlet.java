package controller.servlet;

import FormPopulator.FormPopulator;
import bean.Member;
import bean.Seeker;
import form.RegisterSeekerForm;
import service.SeekerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterSeekerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterSeekerForm registerSeekerForm=FormPopulator.populateFrom(req,RegisterSeekerForm.class);
        Seeker seeker = new Seeker();
        String memberType = req.getParameter("membertype");
        if (memberType.equals("sitter")) {
            seeker.setType(Member.MemberType.SITTER);
        } else if (memberType.equals("seeker")) {
            seeker.setType(Member.MemberType.SEEKER);
        }
        seeker.setFirstName(registerSeekerForm.getFirstName());
        seeker.setLastName(registerSeekerForm.getLastName());
        seeker.setPhoneNumber(registerSeekerForm.getPhone());
        seeker.setEmail(registerSeekerForm.getEmail());
        seeker.setAddress(registerSeekerForm.getAddress());
        seeker.setSpouseName(registerSeekerForm.getSpouseName());
        seeker.setNoOfChildren(registerSeekerForm.getNoOfChildren());
        seeker.setPassword(registerSeekerForm.getPassword());
        SeekerService.registerSeeker(seeker);
        req.setAttribute("success","Successfully Registered!!!!Please login to continue");
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);

    }
}
