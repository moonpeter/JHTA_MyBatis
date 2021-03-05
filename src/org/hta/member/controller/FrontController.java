package org.hta.member.controller;

import org.hta.member.action.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.net")
public class FrontController extends javax.servlet.http.HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String RequestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = RequestURI.substring(contextPath.length());
        ActionForward forward = null;
        Action action = null;

        switch (command) {
            case "/main.net":
                action = new MainAction();
                break;
            case "/loginForm.net":
                action = new LoginForm();
                break;
            case "/loginPro.net":
                action = new LoginPro();
                break;
            case "/joinForm.net":
                action = new JoinForm();
                break;
            case "/joinPro.net":
                action = new JoinAction();
                break;
            case "/logout.net":
                action = new Logout();
                break;
            case "/list.net":
                action = new ListAction();
                break;
            case "/delete.net":
                action = new DeleteAction();
                break;
            case "/updateForm.net":
                action = new UpdateForm();
                break;
            case "/updatePro.net":
                action = new UpdatePro();
                break;

        }
        forward = action.execute(request, response);

        if (forward != null) {
            if (forward.isRedirect()){
                response.sendRedirect(forward.getPath());
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        doProcess(request, response);
    }
}
