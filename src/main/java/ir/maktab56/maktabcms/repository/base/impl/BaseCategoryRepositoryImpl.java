package ir.maktab56.maktabcms.repository.base.impl;

import ir.maktab56.maktabcms.base.repository.BaseEntityRepositoryImpl;
import ir.maktab56.maktabcms.domain.BaseCategory;
import ir.maktab56.maktabcms.repository.base.BaseCategoryRepository;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseCategoryRepositoryImpl<E extends BaseCategory<E>> extends BaseEntityRepositoryImpl<E, Long>
        implements BaseCategoryRepository<E> {

    public BaseCategoryRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<E> findAllByTitleContaining(String title) {
        return findAllByTitleContainingFirstApproach(title);
    }

    @Override
    public List<E> findAllByParent_Id(Long parentId) {
        return entityManager.createQuery(
                "from " + getEntityClass().getSimpleName() + " c where c.parent.id = :parentId",
                getEntityClass()
        ).setParameter("parentId", parentId).getResultList();
    }

    //    <------------------------ private methods --------------------------->

    private List<E> findAllByTitleContainingFirstApproach(String title) {
        return entityManager.createQuery(
                "from " + getEntityClass().getSimpleName() + " c where c.title like '%" + title + "%'",
                getEntityClass()
        ).getResultList();
    }

    private List<E> findAllByTitleContainingSecondApproach(String title) {
        return entityManager.createQuery(
                "from " + getEntityClass().getSimpleName() + " c where c.title like concat('%', :title, '%')",
                getEntityClass()
        ).setParameter("title", title).getResultList();
    }
}
