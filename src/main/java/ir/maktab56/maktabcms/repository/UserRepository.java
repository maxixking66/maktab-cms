package ir.maktab56.maktabcms.repository;

import ir.maktab56.maktabcms.base.repository.BaseEntityRepository;
import ir.maktab56.maktabcms.domain.User;

public interface UserRepository extends BaseEntityRepository<User, Long> {

    User getUserByUsername(String username);
}
