package controller.servlet;

import FormPopulator.FormPopulator;
import bean.Member;
import bean.Seeker;
import bean.Sitter;
import dao.MemberDao;
import dao.SeekerDao;
import dao.SitterDao;
import form.LoginForm;
import service.MemberService;
import service.SeekerService;
import service.SitterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginForm loginForm=FormPopulator.populate(req,LoginForm.class);
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        Member member = new Member();
        Sitter sitter = new Sitter();
        Seeker seeker = new Seeker();

        boolean authenticate = MemberService.authenticate(email, password);

        if (authenticate == true) {
            int memberid = MemberService.getMemberIdByEmail(email);
            member = MemberService.getMemberById(memberid);

            if (member.getType().equals(Member.MemberType.SEEKER) && member.getStatus().equals(Member.Status.ACTIVE)) {
                seeker = SeekerService.getSeekerById(memberid);
                HttpSession session = req.getSession();
                session.setAttribute("member", seeker);
                RequestDispatcher rd = req.getRequestDispatcher("accountserve");
                rd.forward(req, resp);

            } else if (member.getType().equals(Member.MemberType.SITTER) && member.getStatus().equals(Member.Status.ACTIVE)) {
                sitter = SitterService.getSitterById(memberid);
                HttpSession session = req.getSession();
                session.setAttribute("member", sitter);
                RequestDispatcher rd = req.getRequestDispatcher("accountserve");
                rd.forward(req, resp);
            } else {
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<h3>Account is closed by user.</h3><br>Contact support to reopen.");
            }

        } else if (authenticate == false) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h4>Invalid username or password</h4><br><a href=\"login.jsp\">Try Again</a>");
        }

    }
}
