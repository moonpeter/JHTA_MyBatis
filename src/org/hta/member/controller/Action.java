package org.hta.member.controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public interface Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
