package controller.servlet;

import bean.Job;
import bean.Member;
import bean.Seeker;
import service.SeekerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SeekerAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Member member = (Member) session.getAttribute("member");
        Seeker seeker = (Seeker) member;
        List<Job> jobsPosted = SeekerService.allJobPostedBySeeker(seeker.getId());
        req.setAttribute("jobposted", jobsPosted);
        RequestDispatcher rd = req.getRequestDispatcher("seekeraccount.jsp");
        rd.include(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}