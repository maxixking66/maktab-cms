package ir.maktab56.maktabcms.service.impl;

import ir.maktab56.maktabcms.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.maktabcms.domain.Media;
import ir.maktab56.maktabcms.repository.MediaRepository;
import ir.maktab56.maktabcms.service.MediaService;

public class MediaServiceImpl extends BaseEntityServiceImpl<Media, Long, MediaRepository> implements MediaService {

    public MediaServiceImpl(MediaRepository repository) {
        super(repository);
    }
}
