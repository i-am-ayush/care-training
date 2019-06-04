import bean.Job;
import service.JobService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class EditJobDetailsFormServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        Job job= JobService.getJobById(id);
        req.setAttribute("updateJob",job);
        HttpSession session=req.getSession();
        session.setAttribute("Job",job);
        RequestDispatcher rd = req.getRequestDispatcher("editjobdetails.jsp");
        rd.forward(req, resp);
        }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    }
