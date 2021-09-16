package ir.maktab56.maktabcms.util;

import ir.maktab56.maktabcms.repository.MediaCategoryRepository;
import ir.maktab56.maktabcms.repository.MediaRepository;
import ir.maktab56.maktabcms.repository.UserRepository;
import ir.maktab56.maktabcms.repository.WriterRepository;
import ir.maktab56.maktabcms.repository.impl.MediaCategoryRepositoryImpl;
import ir.maktab56.maktabcms.repository.impl.MediaRepositoryImpl;
import ir.maktab56.maktabcms.repository.impl.UserRepositoryImpl;
import ir.maktab56.maktabcms.repository.impl.WriterRepositoryImpl;
import ir.maktab56.maktabcms.service.*;
import ir.maktab56.maktabcms.service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final MediaCategoryRepository mediaCategoryRepository;
    private static final MediaCategoryService mediaCategoryService;
    private static final UserRepository userRepository;
    private static final UserService userService;
    private static final AuthenticationProvider authenticationProvider;
    private static final MediaRepository mediaRepository;
    private static final MediaService mediaService;
    private static final WriterRepository writerRepository;
    private static final WriterService writerService;

    static {
        EntityManager entityManager = HibernateUtil.getMainEntityMangerFactory().createEntityManager();
        mediaCategoryRepository = new MediaCategoryRepositoryImpl(entityManager);
        mediaCategoryService = new MediaCategoryServiceImpl(mediaCategoryRepository);
        userRepository = new UserRepositoryImpl(entityManager);
        userService = new UserServiceImpl(userRepository);
        authenticationProvider = new AuthenticationProviderImpl(userService);
        mediaRepository = new MediaRepositoryImpl(entityManager);
        mediaService = new MediaServiceImpl(mediaRepository);
        writerRepository = new WriterRepositoryImpl(entityManager);
        writerService = new WriterServiceImpl(writerRepository);
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

    public static MediaRepository getMediaRepository() {
        return mediaRepository;
    }

    public static MediaService getMediaService() {
        return mediaService;
    }

    public static WriterRepository getWriterRepository() {
        return writerRepository;
    }

    public static WriterService getWriterService() {
        return writerService;
    }
}
