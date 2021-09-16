package ir.maktab56.maktabcms.util;

import ir.maktab56.maktabcms.repository.MediaCategoryRepository;
import ir.maktab56.maktabcms.repository.impl.MediaCategoryRepositoryImpl;
import ir.maktab56.maktabcms.service.MediaCategoryService;
import ir.maktab56.maktabcms.service.impl.MediaCategoryServiceImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final MediaCategoryRepository mediaCategoryRepository;
    private static final MediaCategoryService mediaCategoryService;

    static {
        EntityManager entityManager = HibernateUtil.getTestEntityMangerFactory().createEntityManager();
        mediaCategoryRepository = new MediaCategoryRepositoryImpl(entityManager);
        mediaCategoryService = new MediaCategoryServiceImpl(mediaCategoryRepository);
    }

    private ApplicationContext() {
    }

    public static MediaCategoryRepository getMediaCategoryRepository() {
        return mediaCategoryRepository;
    }

    public static MediaCategoryService getMediaCategoryService() {
        return mediaCategoryService;
    }
}
