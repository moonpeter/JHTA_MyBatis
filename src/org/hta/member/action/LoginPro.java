package org.hta.member.action;

import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDao;
import org.hta.member.domain.Member;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginPro implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Member mem = new Member();
        mem.setId(id);
        mem.setPassword(password);

        MemberDao md = new MemberDao();
        int result = md.chk(mem);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if(result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);

            out.println("<script>");
            out.println("alert('환영합니다" + id +"');");
            out.println("location.href='main.net'");
            out.println("</script>");
            out.close();
        } else if (result == -1) {
            out.println("<script>");
            out.println("alert('비밀번호가 다릅니다.');");
            out.println("history.go(-1)");
            out.println("</script>");
            out.close();
        } else if (result == 0){
            out.println("<script>");
            out.println("alert('해당 ID가 없습니다. 다시 확인해주세요');");
            out.println("history.go(-1)");
            out.println("</script>");
            out.close();
        }
        return null;
    }
}