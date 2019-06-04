import FormPopulator.FormPopulator;
import bean.Job;
import form.UpdatejobForm;
import service.JobService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class EditJobDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UpdatejobForm updatejobForm = FormPopulator.populate(req, UpdatejobForm.class);
        Job job = (Job) session.getAttribute("Job");
        job.setEndDateTime(updatejobForm.getEndDateTime());
        job.setStartDateTime(updatejobForm.getStartDateTime());
        job.setTitle(updatejobForm.getTitle());
        job.setPayPerHour(updatejobForm.getPayPerHour());

        if (JobService.editJobPost(job) == true) {
            RequestDispatcher rd = req.getRequestDispatcher("accountserve");
            rd.forward(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            out.println("Error while editing new job");
        }

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
