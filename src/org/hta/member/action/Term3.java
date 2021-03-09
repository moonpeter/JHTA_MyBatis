package org.hta.member.action;

import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.EmpDAO;
import org.hta.member.domain.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Term3 implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDAO dao = new EmpDAO();
        Map<String, String> m = new HashMap<>();
        m.put("start", request.getParameter("startday"));
        m.put("end", request.getParameter("endday"));

        List<Emp> list= dao.getTermList2(m);
        ActionForward forward = new ActionForward();
        request.setAttribute("list", list);
        request.setAttribute("start", m.get("start"));
        request.setAttribute("end", m.get("end"));
        forward.setPath("_1.where/list.jsp");
        forward.setRedirect(false);
        return forward;
    }
}
