package ir.maktab56.maktabcms.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = MediaCategory.TABLE_NAME)
@Setter
@Getter
/*@NoArgsConstructor
@AllArgsConstructor*/
public class MediaCategory extends BaseCategory<MediaCategory> {

    public static final String TABLE_NAME = "media_category";
}
