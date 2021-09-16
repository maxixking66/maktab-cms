package ir.maktab56.maktabcms.repository.impl;

import ir.maktab56.maktabcms.base.repository.BaseEntityRepositoryImpl;
import ir.maktab56.maktabcms.domain.Writer;
import ir.maktab56.maktabcms.repository.WriterRepository;

import javax.persistence.EntityManager;

public class WriterRepositoryImpl extends BaseEntityRepositoryImpl<Writer, Long> implements WriterRepository {

    public WriterRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Writer> getEntityClass() {
        return Writer.class;
    }
}
