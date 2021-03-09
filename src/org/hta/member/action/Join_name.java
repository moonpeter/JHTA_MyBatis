package org.hta.member.action;

import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.EmpDAO;
import org.hta.member.domain.Join;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Join_name implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDAO dao = new EmpDAO();

        List<Join> list = dao.getJoin(request.getParameter("name"));
        ActionForward forward = new ActionForward();
        request.setAttribute("list", list);
        forward.setPath("jsp/joinlist.jsp");
        forward.setRedirect(false);

        return forward;
    }
}
