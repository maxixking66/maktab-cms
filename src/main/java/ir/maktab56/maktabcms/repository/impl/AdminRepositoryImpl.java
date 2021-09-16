package ir.maktab56.maktabcms.repository.impl;

import ir.maktab56.maktabcms.base.repository.BaseEntityRepositoryImpl;
import ir.maktab56.maktabcms.domain.Admin;
import ir.maktab56.maktabcms.repository.AdminRepository;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends BaseEntityRepositoryImpl<Admin, Long> implements AdminRepository {

    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
