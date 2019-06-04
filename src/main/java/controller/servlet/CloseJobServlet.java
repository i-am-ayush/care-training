package controller.servlet;

import service.JobService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CloseJobServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id = Integer.parseInt(req.getParameter("id"));

        if (JobService.deleteJobById(id) == true) {

            RequestDispatcher rd = req.getRequestDispatcher("controller.servlet.AccountServlet");
            rd.forward(req, resp);

        } else {
            PrintWriter out = resp.getWriter();
            out.println("Error deleting job. Try again");
        }

    }
}
