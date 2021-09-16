package ir.maktab56.maktabcms.service.impl;

import ir.maktab56.maktabcms.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.maktabcms.domain.Admin;
import ir.maktab56.maktabcms.repository.AdminRepository;
import ir.maktab56.maktabcms.service.AdminService;

public class AdminServiceImpl extends BaseEntityServiceImpl<Admin, Long, AdminRepository> implements AdminService {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }
}
