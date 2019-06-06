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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditSeekerProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterSeekerForm editSeekerForm= FormPopulator.populate(req,RegisterSeekerForm.class);
        Seeker seeker = new Seeker();
        Member member = new Member();
        HttpSession session = req.getSession();
        member = (Member) session.getAttribute("member");
        seeker.setType(Member.MemberType.SEEKER);
        seeker.setId(member.getId());
        seeker.setFirstName(editSeekerForm.getFirstname());
        seeker.setLastName(editSeekerForm.getLastname());
        seeker.setPhoneNumber(editSeekerForm.getPhone());
        seeker.setEmail(editSeekerForm.getEmail());
        seeker.setAddress(editSeekerForm.getAddress());
        seeker.setSpouseName(editSeekerForm.getSpousename());
        seeker.setNoOfChildren(editSeekerForm.getChildren());
        seeker.setPassword(editSeekerForm.getPassword());
        SeekerService.editProfile(seeker);
        RequestDispatcher rd = req.getRequestDispatcher("profileredirect");
        session.removeAttribute("member");
        session.setAttribute("member", seeker);
        rd.forward(req, resp);

    }
}
