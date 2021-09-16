package ir.maktab56.maktabcms.repository.base;

import ir.maktab56.maktabcms.base.repository.BaseEntityRepository;
import ir.maktab56.maktabcms.domain.BaseCategory;

import java.util.List;

public interface BaseCategoryRepository<E extends BaseCategory<E>> extends BaseEntityRepository<E, Long> {

    List<E> findAllByTitleContaining(String title);

    List<E> findAllByParent_Id(Long parentId);
}
