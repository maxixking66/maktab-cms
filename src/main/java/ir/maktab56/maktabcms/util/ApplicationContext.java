package ir.maktab56.maktabcms.util;

import javax.persistence.EntityManager;

public class ApplicationContext {

    static {
        EntityManager entityManager = HibernateUtil.getEntityMangerFactory().createEntityManager();
    }

    private ApplicationContext() {
    }


}
