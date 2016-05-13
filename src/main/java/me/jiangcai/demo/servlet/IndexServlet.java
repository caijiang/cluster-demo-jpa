package me.jiangcai.demo.servlet;

import me.jiangcai.demo.entity.Girl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJ
 */
@WebServlet(name = "IndexServlet",urlPatterns = {"","/"})
public class IndexServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(IndexServlet.class);

    @PersistenceContext
    private EntityManager entityManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("IndexServlet Processing");
        CriteriaQuery<Girl> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Girl.class);
        criteriaQuery.from(Girl.class);

        TypedQuery<Girl> girlQuery = entityManager.createQuery(criteriaQuery);
        request.setAttribute("girls",girlQuery.getResultList());

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
