package controller.servlet;

import FormPopulator.FormPopulator;
import bean.Member;
import bean.Sitter;
import dto.SitterProfileHome;
import service.SitterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SitterAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Member member = (Member) session.getAttribute("member");
        Sitter sitter = (Sitter) member;
        List<SitterProfileHome> list = SitterService.allAppliedJobBySitter(sitter.getId());

        RequestDispatcher rd = req.getRequestDispatcher("sitteraccount.jsp");
        req.setAttribute("appliedJobList",list);
        rd.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}