package ir.maktab56.maktabcms.service.impl;

import ir.maktab56.maktabcms.domain.Media;
import ir.maktab56.maktabcms.domain.User;
import ir.maktab56.maktabcms.repository.MediaRepository;
import ir.maktab56.maktabcms.service.MediaService;
import ir.maktab56.maktabcms.util.SecurityContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MediaServiceImplTest {

    private final MediaService mediaService;

    MediaServiceImplTest() {

        MediaRepository repository = mock(MediaRepository.class);

        Media media = new Media();
        media.setId(1L);
        media.setTitle("test");

        when(repository.save(any(Media.class))).thenReturn(media);

        mediaService = new MediaServiceImpl(
                repository
        );

    }

    @Test
    void save() {
        assertThrows(RuntimeException.class, () -> mediaService.save(new Media()));
        SecurityContext.setCurrentUser(new User());
        Media media = mediaService.save(new Media());
        assertNotNull(media.getId());
        assertNotNull(media.getUser());
    }

}