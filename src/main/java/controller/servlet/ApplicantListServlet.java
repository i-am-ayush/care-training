package controller.servlet;

import bean.Application;
import bean.Job;
import service.ApplicationService;
import service.JobService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ApplicantListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int jobId = Integer.parseInt(req.getParameter("id"));

        Job job = JobService.getJobById(jobId);

        String title = job.getTitle();

        List<Application> applications = ApplicationService.getAllApplicationByJobId(jobId);

        req.setAttribute("title", title);
        req.setAttribute("applications", applications);

        RequestDispatcher rd = req.getRequestDispatcher("applicantlist.jsp");
        rd.forward(req,resp);

    }
}
