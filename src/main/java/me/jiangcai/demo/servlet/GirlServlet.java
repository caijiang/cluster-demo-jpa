package me.jiangcai.demo.servlet;

import me.jiangcai.demo.ejb.GirlServiceBean;
import org.springframework.util.NumberUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * GET /test/1 获取实体1的属性
 *
 * @author CJ
 */
@WebServlet(name = "GirlServlet", urlPatterns = {"/girl","/girl/*"})
public class GirlServlet extends HttpServlet {

    @EJB
    private GirlServiceBean girlServiceBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        girlServiceBean.newGirl();

        // 跳回主页
        int index = request.getRequestURI().lastIndexOf('/');

        response.sendRedirect(request.getRequestURI().substring(0,index));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int index = req.getRequestURI().lastIndexOf('/');
        Long id = NumberUtils.parseNumber(req.getRequestURI().substring(index+1),Long.class);
        girlServiceBean.changeGirl(id);

        resp.sendError(202);
    }
}
