import FormPopulator.FormPopulator;
import bean.Member;
import bean.Seeker;
import form.RegisterSeekerForm;
import service.SeekerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class registerseeker extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterSeekerForm registerSeekerForm=FormPopulator.populate(req,RegisterSeekerForm.class);
        Seeker seeker = new Seeker();
        String memberType = req.getParameter("membertype");
        if (memberType.equals("sitter")) {
            seeker.setType(Member.MemberType.SITTER);
        } else if (memberType.equals("seeker")) {
            seeker.setType(Member.MemberType.SEEKER);
        }
        seeker.setFirstName(registerSeekerForm.getFirstname());
        seeker.setLastName(registerSeekerForm.getLastname());
        seeker.setPhoneNumber(registerSeekerForm.getPhone());
        seeker.setEmail(registerSeekerForm.getEmail());
        seeker.setAddress(registerSeekerForm.getAddress());
        seeker.setSpouseName(registerSeekerForm.getSpousename());
        seeker.setNoOfChildren(registerSeekerForm.getChildren());
        seeker.setPassword(registerSeekerForm.getPassword());
        SeekerService.registerSeeker(seeker);
        PrintWriter out = resp.getWriter();
        out.println("Saved in Database");

    }
}
