package ir.maktab56.maktabcms.service.impl;

import ir.maktab56.maktabcms.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.maktabcms.domain.Media;
import ir.maktab56.maktabcms.domain.User;
import ir.maktab56.maktabcms.repository.MediaRepository;
import ir.maktab56.maktabcms.service.MediaService;
import ir.maktab56.maktabcms.util.SecurityContext;

public class MediaServiceImpl extends BaseEntityServiceImpl<Media, Long, MediaRepository> implements MediaService {

    public MediaServiceImpl(MediaRepository repository) {
        super(repository);
    }

    @Override
    public Media save(Media media) {
        User currentUser = SecurityContext.getCurrentUser();
        if (currentUser == null) {
            throw new RuntimeException("access denied!!!");
        }
        if (media.getId() == null) {
            repository.getEntityManager().getTransaction().begin();
            media = repository.save(media);
            media.setUser(currentUser);
            repository.getEntityManager().getTransaction().commit();
            return media;
        } else {
            return super.save(media);
        }
    }

    @Override
    public void insert(Media media) {
        repository.getEntityManager().getTransaction().begin();
        repository.save(media);
        repository.getEntityManager().getTransaction().commit();
    }
}
