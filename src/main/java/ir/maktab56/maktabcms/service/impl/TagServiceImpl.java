package ir.maktab56.maktabcms.service.impl;

import ir.maktab56.maktabcms.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.maktabcms.domain.Tag;
import ir.maktab56.maktabcms.repository.TagRepository;
import ir.maktab56.maktabcms.service.TagService;

public class TagServiceImpl extends BaseEntityServiceImpl<Tag, Long, TagRepository> implements TagService {

    public TagServiceImpl(TagRepository repository) {
        super(repository);
    }
}
