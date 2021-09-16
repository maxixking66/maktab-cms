package ir.maktab56.maktabcms.repository.impl;

import ir.maktab56.maktabcms.base.repository.BaseEntityRepositoryImpl;
import ir.maktab56.maktabcms.domain.Tag;
import ir.maktab56.maktabcms.repository.TagRepository;

import javax.persistence.EntityManager;

public class TagRepositoryImpl extends BaseEntityRepositoryImpl<Tag, Long> implements TagRepository {

    public TagRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Tag> getEntityClass() {
        return Tag.class;
    }
}
