package ir.maktab56.maktabcms.repository.impl;

import ir.maktab56.maktabcms.base.repository.BaseEntityRepositoryImpl;
import ir.maktab56.maktabcms.domain.User;
import ir.maktab56.maktabcms.repository.UserRepository;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User, Long> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery(
                "from User u where u.username = :username", User.class
        ).setParameter("username", username).getSingleResult();
    }
}
