package org.hta.member.action;

import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginForm implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("jsp/loginForm.jsp");
        return forward;
    }
}
