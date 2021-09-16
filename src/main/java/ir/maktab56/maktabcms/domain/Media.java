package ir.maktab56.maktabcms.domain;

import ir.maktab56.maktabcms.base.domain.BaseEntity;
import ir.maktab56.maktabcms.domain.enumeration.MediaType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Media.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Media extends BaseEntity<Long> {

    public static final String TABLE_NAME = "media";

    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String CREATE_DATE = "create_date";
    public static final String LAST_UPDATE_DATE = "last_update_date";
    public static final String PUBLISH_DATE = "publish_date";
    public static final String MEDIA_TYPE = "media_type";
    public static final String MEDIA_TAGS = "media_tags";
    public static final String MEDIA_ID = "media_id";
    public static final String TAG_ID = "tag_id";
    public static final String ID = "id";
    public static final String MEDIA_CATEGORY_ID = "media_category_id";
    public static final String USER_ID = "user_id";

    @Column(name = TITLE)
    private String title;

    @Column(name = CONTENT)
    @Lob
    private String content;

    @Column(name = CREATE_DATE)
    private ZonedDateTime createDate;

    @Column(name = LAST_UPDATE_DATE)
    private ZonedDateTime lastUpdateDate;

    @Column(name = PUBLISH_DATE)
    private ZonedDateTime publishDate;

    @Column(name = MEDIA_TYPE)
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = MEDIA_CATEGORY_ID)
    private MediaCategory mediaCategory;

    @ManyToMany
    @JoinTable(name = MEDIA_TAGS, joinColumns = {@JoinColumn(name = MEDIA_ID, referencedColumnName = ID)},
            inverseJoinColumns = {@JoinColumn(name = TAG_ID, referencedColumnName = ID)})
    private Set<Tag> tagSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = USER_ID)
    private User user;
}
