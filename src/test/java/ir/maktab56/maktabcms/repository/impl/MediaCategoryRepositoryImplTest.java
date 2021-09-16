package ir.maktab56.maktabcms.repository.impl;

import ir.maktab56.maktabcms.domain.MediaCategory;
import ir.maktab56.maktabcms.repository.MediaCategoryRepository;
import ir.maktab56.maktabcms.util.ApplicationContext;
import ir.maktab56.maktabcms.util.HibernateUtil;
import org.junit.jupiter.api.BeforeAll;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class MediaCategoryRepositoryImplTest {

    private final MediaCategoryRepository mediaCategoryRepository;

    public MediaCategoryRepositoryImplTest() {
        mediaCategoryRepository = ApplicationContext.getMediaCategoryRepository();
    }

    @BeforeAll
    static void insertFakeData() {
        EntityManager entityManager =
                HibernateUtil.getTestEntityMangerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        MediaCategory parent = new MediaCategory();
        parent.setTitle(
                "ورزشی"
        );
        entityManager.persist(
                parent
        );

        MediaCategory child = new MediaCategory();
        child.setParent(parent);
        child.setTitle("فوتبال");
        entityManager.persist(
                child
        );
        entityManager.getTransaction().commit();
    }

    @org.junit.jupiter.api.Test
    void findAllByTitleContaining() {

        assertEquals(0,
                mediaCategoryRepository.findAllByTitleContaining("سیا").size());

        assertEquals(1,
                mediaCategoryRepository.findAllByTitleContaining("ز").size());
        assertEquals(1,
                mediaCategoryRepository.findAllByTitleContaining("شی").size());
    }

    @org.junit.jupiter.api.Test
    void findAllByParent_Id() {
        assertEquals(
                0,
                mediaCategoryRepository.findAllByParent_Id(2L).size()
        );

        assertEquals("فوتبال",
                mediaCategoryRepository.findAllByParent_Id(1L).get(0).getTitle());
    }

    @org.junit.jupiter.api.Test
    void save() {
        MediaCategory mediaCategory = new MediaCategory();
        assertNull(mediaCategory.getId());
        mediaCategoryRepository.save(mediaCategory);
        assertNotNull(mediaCategory.getId());

    }

    @org.junit.jupiter.api.Test
    void findById() {
        assertNotNull(
                mediaCategoryRepository.findById(1L)
        );
    }

    @org.junit.jupiter.api.Test
    void findAll() {
        assertEquals(
                2,
                mediaCategoryRepository.findAll().size()
        );
    }

    @org.junit.jupiter.api.Test
    void existsById() {
        assertTrue(
                mediaCategoryRepository.existsById(1L)
        );
    }

    @org.junit.jupiter.api.Test
    void countAll() {
        assertEquals(
                2,
                mediaCategoryRepository.countAll()
        );
    }
}