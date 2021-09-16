package ir.maktab56.maktabcms.service.base;

import ir.maktab56.maktabcms.base.service.BaseEntityService;
import ir.maktab56.maktabcms.domain.BaseCategory;

import java.util.List;

public interface BaseCategoryService<E extends BaseCategory<E>> extends BaseEntityService<E, Long> {

    List<E> findAllByTitleContaining(String title);

    List<E> findAllByParentId(Long parentId);
}
