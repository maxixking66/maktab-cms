package ir.maktab56.maktabcms;

import com.github.javafaker.Faker;
import ir.maktab56.maktabcms.domain.*;
import ir.maktab56.maktabcms.domain.enumeration.MediaType;
import ir.maktab56.maktabcms.domain.enumeration.UserType;
import ir.maktab56.maktabcms.service.MediaCategoryService;
import ir.maktab56.maktabcms.service.MediaService;
import ir.maktab56.maktabcms.service.WriterService;
import ir.maktab56.maktabcms.util.ApplicationContext;
import ir.maktab56.maktabcms.util.HibernateUtil;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class MaktabCmsApplication {
    public static void main(String[] args) {
        initUser();
        initMediaCategory();
        initMedia();

       /* List<Media> mediaList = ApplicationContext.getMediaService().findAll();
        mediaList.forEach(media -> {

                    System.out.println(media);
                    System.out.println();
                }
        );*/

        EntityManager entityManager = HibernateUtil.getMainEntityMangerFactory().createEntityManager();
        TypedQuery<Long> query = entityManager.createQuery("select id from Media", Long.class);

        /*EntityGraph<Media> entityGraph = entityManager.createEntityGraph(Media.class);
        entityGraph.addAttributeNodes("user", "mediaCategory", "tagSet");
        query.setHint("javax.persistence.fetchgraph", entityGraph);*/
        query.setMaxResults(5)
                .setFirstResult(0);

        List<Long> resultList = query.getResultList();

        TypedQuery<Media> typedQuery = entityManager.createQuery("from Media m where m.id in :ids", Media.class)
                .setParameter("ids", resultList);

        EntityGraph<Media> entityGraph = entityManager.createEntityGraph(Media.class);
        entityGraph.addAttributeNodes("user", "mediaCategory", "tagSet");
        typedQuery.setHint("javax.persistence.fetchgraph", entityGraph);


        List<Media> mediaList = typedQuery.getResultList();
        System.out.println();
        mediaList.forEach(media -> {
                    System.out.println(media);
                    System.out.println();
                }
        );

    }

    private static void initUser() {
        WriterService writerService = ApplicationContext.getWriterService();
        if (writerService.countAll() == 0) {
            writerService.save(
                    Writer.builder()
                            .firstName("amir mohsen")
                            .lastName("rajabi")
                            .username("rajabi")
                            .userType(UserType.WRITER.name())
                            .password("123456")
                            .build()
            );
        }
    }

    private static void initMediaCategory() {
        MediaCategoryService mediaCategoryService = ApplicationContext.getMediaCategoryService();
        if (mediaCategoryService.countAll() == 0) {
            MediaCategory category = new MediaCategory();
            category.setTitle("sport");
            mediaCategoryService.save(category);

            MediaCategory child = new MediaCategory();
            child.setTitle("football");
            child.setParent(category);
            mediaCategoryService.save(child);

        }
    }

    private static void initMedia() {
        MediaService mediaService = ApplicationContext.getMediaService();
        if (mediaService.countAll() == 0) {
            MediaCategory mediaCategory = ApplicationContext.getMediaCategoryService().findAllByTitleContaining("foo").get(0);
            User user = ApplicationContext.getUserService().getUserByUsername("mohsen");
            Faker faker = new Faker();
            IntStream.range(0, 10)
                    .forEach(i -> {
                        Media media = new Media();
                        media.setTitle(
                                faker.book().title()
                        );
                        media.setContent(
                                faker.lorem().characters(120)
                        );
                        media.setMediaCategory(mediaCategory);
                        media.setCreateDate(ZonedDateTime.now());
                        media.setLastUpdateDate(ZonedDateTime.now());
                        media.setMediaType(MediaType.ARTICLE);
                        media.setUser(user);
                        media.setTagSet(
                                new HashSet<>(
                                        Arrays.asList(
                                                new Tag(
                                                        faker.book().genre()
                                                ),
                                                new Tag(
                                                        faker.book().genre()
                                                ),
                                                new Tag(
                                                        faker.book().genre()
                                                )
                                        )
                                )
                        );
                        mediaService.insert(media);
                    });
        }
    }
}
