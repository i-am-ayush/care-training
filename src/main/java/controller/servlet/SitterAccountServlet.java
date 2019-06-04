package controller.servlet;

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

public class SitterAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Member member = (Member) session.getAttribute("member");
        Sitter sitter = (Sitter) member;
        List<SitterProfileHome> list = SitterService.allAppliedJobBySitter(sitter.getMemberId());

//        for (Map<String, Object> appliedjobs : list) {
//            String title = "", payperhour = "", expectedpay = "", status = "", disabled = "";
//            int appid = 0;
//            for (Map.Entry<String, Object> applicationdetails : appliedjobs.entrySet()) {
//                System.out.println(applicationdetails.getKey());
//                System.out.println(applicationdetails.getValue());
//                req.setAttribute(applicationdetails.getKey(), applicationdetails.getValue());
//            }
//        }
        for(int i=0;i<list.size();i++) {

            System.out.println(list.get(i).getTitle());
            System.out.println(list.get(i).getStatus());
            System.out.println(list.get(i).getApplicationId());
        }
        RequestDispatcher rd = req.getRequestDispatcher("sitteraccount.jsp");
        req.setAttribute("appliedJobList",list);
        rd.forward(req, resp);
    }
}
