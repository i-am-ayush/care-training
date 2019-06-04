package controller.servlet;

import bean.Job;
import service.JobService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditJobDetailsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Job job = new Job();


        int jobId = Integer.parseInt(req.getParameter("jobId"));
        String title = req.getParameter("jobtitle");
        int postedBy = Integer.parseInt(req.getParameter("postedby"));
        String sStartDate = req.getParameter("startdate");
        Date startDate = null, endDate=null;
        try {
            startDate = new SimpleDateFormat("dd/MM/yyyy").parse(sStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String sEndDate = req.getParameter("enddate");
        try {
            endDate = new SimpleDateFormat("dd/MM/yyyy").parse(sEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Double payPerHour = Double.parseDouble(req.getParameter("payperhour"));

        job.setId(jobId);
        job.setTitle(title);
        job.setPostedBy(postedBy);
        job.setStartDateTime(startDate);
        job.setEndDateTime(endDate);
        job.setPayPerHour(payPerHour);


        if(JobService.editJobPost(job)==true){
            RequestDispatcher rd = req.getRequestDispatcher("controller.servlet.AccountServlet");
            rd.forward(req, resp);
        }
        else {
            PrintWriter out = resp.getWriter();
            out.println("Error while editing new job");
        }


    }
}
