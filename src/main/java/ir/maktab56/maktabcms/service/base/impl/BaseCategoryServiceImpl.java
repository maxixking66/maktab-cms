package ir.maktab56.maktabcms.service.base.impl;

import ir.maktab56.maktabcms.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.maktabcms.domain.BaseCategory;
import ir.maktab56.maktabcms.repository.base.BaseCategoryRepository;
import ir.maktab56.maktabcms.service.base.BaseCategoryService;

import java.util.List;

public class BaseCategoryServiceImpl<E extends BaseCategory<E>, R extends BaseCategoryRepository<E>>
        extends BaseEntityServiceImpl<E, Long, R>
        implements BaseCategoryService<E> {

    public BaseCategoryServiceImpl(R repository) {
        super(repository);
    }

    @Override
    public List<E> findAllByTitleContaining(String title) {
        return null;
    }

    @Override
    public List<E> findAllByParentId(Long parentId) {
        return null;
    }
}
