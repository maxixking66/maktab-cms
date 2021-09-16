package ir.maktab56.maktabcms.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory mainEntityMangerFactory;

    private static final EntityManagerFactory testEntityMangerFactory;

    static {
        mainEntityMangerFactory = Persistence.createEntityManagerFactory("Unit");
        testEntityMangerFactory = Persistence.createEntityManagerFactory("Test");
    }

    public static EntityManagerFactory getMainEntityMangerFactory() {
        return mainEntityMangerFactory;
    }

    public static EntityManagerFactory getTestEntityMangerFactory() {
        return testEntityMangerFactory;
    }
}
