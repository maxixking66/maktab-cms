package ir.maktab56.maktabcms.repository.impl;

import ir.maktab56.maktabcms.domain.MediaCategory;
import ir.maktab56.maktabcms.repository.MediaCategoryRepository;
import ir.maktab56.maktabcms.repository.base.impl.BaseCategoryRepositoryImpl;

import javax.persistence.EntityManager;

public class MediaCategoryRepositoryImpl extends BaseCategoryRepositoryImpl<MediaCategory>
        implements MediaCategoryRepository {

    public MediaCategoryRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<MediaCategory> getEntityClass() {
        return MediaCategory.class;
    }

}
