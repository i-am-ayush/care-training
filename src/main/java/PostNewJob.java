import FormPopulator.FormPopulator;
import bean.Job;
import bean.Seeker;
import form.PostNewJobForm;
import service.JobService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class PostNewJob extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Seeker seeker = (Seeker) session.getAttribute("member");
       PostNewJobForm postNewJobForm=FormPopulator.populate(req, PostNewJobForm.class);
        Job job = new Job();
        job.setTitle(postNewJobForm.getTitle());
        job.setPostedBy(seeker.getId());
        job.setStartDateTime(postNewJobForm.getStartDate());
        job.setEndDateTime(postNewJobForm.getEndDate());
        job.setPayPerHour(postNewJobForm.getPayPerHour());
        if (JobService.save(job) == true) {
            RequestDispatcher rd = req.getRequestDispatcher("accountserve");
            rd.forward(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            out.println("Error while posting new job");
        }

    }
}
