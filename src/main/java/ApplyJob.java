import bean.Application;
import bean.Member;
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

        Application application = new Application();
        HttpSession session = req.getSession();
        int jobId = Integer.parseInt(req.getParameter("jobId"));
        double expectedPay = Double.parseDouble(req.getParameter("expectedPay"));
        Member member = (Member) session.getAttribute("member");
        int memberId = member.getId();

        application.setJobId(jobId);
        application.setMemberId(memberId);
        application.setExpectedPay(expectedPay);


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
