import bean.Job;
import service.JobService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditJobDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Job job = (Job) session.getAttribute("Job");
        String title = req.getParameter("jobtitle");
        String sStartDate = req.getParameter("startdate");
        String sEndDate = req.getParameter("enddate");
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            Date date = simpleDateFormat.parse(sStartDate);
            job.setStartDateTime(date);
            Date date2 = simpleDateFormat.parse(sEndDate);
            job.setEndDateTime(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        try {
//            startDate = new SimpleDateFormat("yyyy/MM/dd").parse(sStartDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            endDate = new SimpleDateFormat("yyyy/MM/dd").parse(sEndDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Double payPerHour = Double.parseDouble(req.getParameter("payperhour"));
        job.setTitle(title);
        job.setPayPerHour(payPerHour);
        if (JobService.editJobPost(job) == true) {
            RequestDispatcher rd = req.getRequestDispatcher("accountserve");
            rd.forward(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            out.println("Error while editing new job");
        }


    }
}
