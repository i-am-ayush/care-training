import bean.Application;
import bean.Job;
import dto.ApplicantDto;
import service.ApplicationService;
import service.JobService;
import service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicantList extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int jobId = Integer.parseInt(req.getParameter("id"));
        Job job = JobService.getJobById(jobId);
        String title = job.getTitle();
        req.setAttribute("title", title);
        List<ApplicantDto> applicantDtoList = new ArrayList<>();
        List<Application> applications = ApplicationService.getAllApplicationByJobId(jobId);
        for (int i = 0; i < applications.size(); i++) {
            ApplicantDto applicantDto = new ApplicantDto();
            applicantDto.setName(MemberService.getMemberById(applications.get(i).getMemberId()).getFirstName()+MemberService.getMemberById(applications.get(i).getMemberId()).getLastName());
            applicantDto.setStatus(String.valueOf(applications.get(i).getStatus()));
            applicantDto.setExpectedPay(applications.get(i).getExpectedPay());
            applicantDtoList.add(applicantDto);
        }
        req.setAttribute("applicantList",applicantDtoList);
        RequestDispatcher rd = req.getRequestDispatcher("applicantlist.jsp");
        rd.forward(req, resp);

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
