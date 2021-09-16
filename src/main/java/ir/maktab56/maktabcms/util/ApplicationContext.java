package ir.maktab56.maktabcms.util;

import ir.maktab56.maktabcms.repository.MediaCategoryRepository;
import ir.maktab56.maktabcms.repository.UserRepository;
import ir.maktab56.maktabcms.repository.impl.MediaCategoryRepositoryImpl;
import ir.maktab56.maktabcms.repository.impl.UserRepositoryImpl;
import ir.maktab56.maktabcms.service.AuthenticationProvider;
import ir.maktab56.maktabcms.service.MediaCategoryService;
import ir.maktab56.maktabcms.service.UserService;
import ir.maktab56.maktabcms.service.impl.AuthenticationProviderImpl;
import ir.maktab56.maktabcms.service.impl.MediaCategoryServiceImpl;
import ir.maktab56.maktabcms.service.impl.UserServiceImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final MediaCategoryRepository mediaCategoryRepository;
    private static final MediaCategoryService mediaCategoryService;
    private static final UserRepository userRepository;
    private static final UserService userService;
    private static final AuthenticationProvider authenticationProvider;

    static {
        EntityManager entityManager = HibernateUtil.getTestEntityMangerFactory().createEntityManager();
        mediaCategoryRepository = new MediaCategoryRepositoryImpl(entityManager);
        mediaCategoryService = new MediaCategoryServiceImpl(mediaCategoryRepository);
        userRepository = new UserRepositoryImpl(entityManager);
        userService = new UserServiceImpl(userRepository);
        authenticationProvider = new AuthenticationProviderImpl(userService);
    }

    private ApplicationContext() {
    }

    public static MediaCategoryRepository getMediaCategoryRepository() {
        return mediaCategoryRepository;
    }

    public static MediaCategoryService getMediaCategoryService() {
        return mediaCategoryService;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static AuthenticationProvider getAuthenticationProvider() {
        return authenticationProvider;
    }
}
