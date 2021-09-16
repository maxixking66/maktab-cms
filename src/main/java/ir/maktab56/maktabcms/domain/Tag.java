package ir.maktab56.maktabcms.domain;

import ir.maktab56.maktabcms.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Tag.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends BaseEntity<Long> {

    public static final String TABLE_NAME = "tag";

    public static final String TITLE = "title";

    @Column(name = TITLE)
    private String title;

    @Override
    public String toString() {
        return "Tag{" +
                "title='" + title + '\'' +
                '}';
    }
}
