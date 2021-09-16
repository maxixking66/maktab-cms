package ir.maktab56.maktabcms.service;

import ir.maktab56.maktabcms.base.service.BaseEntityService;
import ir.maktab56.maktabcms.domain.Media;

public interface MediaService extends BaseEntityService<Media, Long> {

    void insert(Media media);
}
