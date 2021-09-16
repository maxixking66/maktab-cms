package ir.maktab56.maktabcms.service.impl;

import ir.maktab56.maktabcms.domain.MediaCategory;
import ir.maktab56.maktabcms.repository.MediaCategoryRepository;
import ir.maktab56.maktabcms.service.MediaCategoryService;
import ir.maktab56.maktabcms.service.base.impl.BaseCategoryServiceImpl;

public class MediaCategoryServiceImpl extends BaseCategoryServiceImpl<MediaCategory, MediaCategoryRepository>
        implements MediaCategoryService {

    public MediaCategoryServiceImpl(MediaCategoryRepository repository) {
        super(repository);
    }
}
