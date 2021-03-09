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

public class Check implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDAO doa = new EmpDAO();

        String deptnos[] = request.getParameterValues("deptno");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("deptnos", deptnos);

        List<Emp> list = doa.getCheck(map);

        ActionForward forward = new ActionForward();
        request.setAttribute("list", list);
        forward.setPath("_1.where/list.jsp");
        forward.setRedirect(false);
        return forward;
    }
}
