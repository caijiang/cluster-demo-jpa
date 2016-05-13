package me.jiangcai.demo.ejb;

import me.jiangcai.demo.entity.Girl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

/**
 * @author CJ
 */
@Stateless(name = "GirlServiceEJB")
public class GirlServiceBean {

    @PersistenceContext
    private EntityManager entityManager;

    public GirlServiceBean() {
    }

    public void newGirl() {
        entityManager.getTransaction().begin();
        Girl girl = new Girl();
        girl.setName(UUID.randomUUID().toString());

        entityManager.persist(girl);
        entityManager.getTransaction().commit();
    }

    public void changeGirl(Long id) {
        entityManager.getTransaction().begin();
        entityManager.find(Girl.class, id).setName(UUID.randomUUID().toString());
        entityManager.getTransaction().commit();
    }


}
