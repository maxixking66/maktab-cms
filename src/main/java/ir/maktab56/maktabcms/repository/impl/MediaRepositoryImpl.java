package ir.maktab56.maktabcms.repository.impl;

import ir.maktab56.maktabcms.base.repository.BaseEntityRepositoryImpl;
import ir.maktab56.maktabcms.domain.Media;
import ir.maktab56.maktabcms.repository.MediaRepository;

import javax.persistence.EntityManager;

public class MediaRepositoryImpl extends BaseEntityRepositoryImpl<Media, Long> implements MediaRepository {

    public MediaRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Media> getEntityClass() {
        return Media.class;
    }
}
