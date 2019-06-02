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

public class PostNewJob extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        Job job = new Job();
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

        job.setTitle(title);
        job.setPostedBy(postedBy);
        job.setStartDateTime(startDate);
        job.setEndDateTime(endDate);
        job.setPayPerHour(payPerHour);

        if(JobService.save(job)==true){
            RequestDispatcher rd = req.getRequestDispatcher("accountserve");
            rd.forward(req, resp);
        }
        else {
            PrintWriter out = resp.getWriter();
            out.println("Error while posting new job");
        }

    }
}
