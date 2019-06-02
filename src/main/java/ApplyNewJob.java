import bean.Job;
import bean.Member;
import service.ApplicationService;
import service.JobService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ApplyNewJob extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

        Member member = (Member) session.getAttribute("member");

        List <Job> notAppliedJobs = ApplicationService.getNotAppliedJobs(member.getId());

        RequestDispatcher rd = req.getRequestDispatcher("applynewjob.jsp");
        req.setAttribute("notAppliedJobs", notAppliedJobs);
        rd.forward(req, resp);


    }
}
