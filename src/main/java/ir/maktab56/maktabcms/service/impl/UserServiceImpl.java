package ir.maktab56.maktabcms.service.impl;

import ir.maktab56.maktabcms.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.maktabcms.domain.User;
import ir.maktab56.maktabcms.repository.UserRepository;
import ir.maktab56.maktabcms.service.UserService;

public class UserServiceImpl extends BaseEntityServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
