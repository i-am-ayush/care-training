import FormPopulator.FormPopulator;
import bean.Application;
import bean.Member;
import form.ApplyJobForm;
import service.ApplicationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ApplyJob extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplyJobForm applyJobForm=FormPopulator.populate(req,ApplyJobForm.class);
        Application application = new Application();
        HttpSession session = req.getSession();
        application.setJobId(applyJobForm.getJobId());
        application.setExpectedPay(applyJobForm.getExpectedPay());
        Member member = (Member) session.getAttribute("member");
        int memberId = member.getId();
        application.setMemberId(memberId);
        if(ApplicationService.apply(application)){
            RequestDispatcher rd = req.getRequestDispatcher("accountserve");
            rd.forward(req, resp);
        }
        else {
            PrintWriter out = resp.getWriter();
            out.println("Error in apply application");
        }

    }
}
