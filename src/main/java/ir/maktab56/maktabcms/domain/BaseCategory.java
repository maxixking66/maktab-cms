package ir.maktab56.maktabcms.domain;

import ir.maktab56.maktabcms.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
@Setter
@Getter
public class BaseCategory<E extends BaseCategory<E>> extends BaseEntity<Long> {

    public static final String PARENT_ID = "parent_id";

    public static final String TITLE = "title";

    @Column(name = TITLE)
    private String title;

    @ManyToOne
    @JoinColumn(name = PARENT_ID)
    private E parent;

    @OneToMany
    @JoinColumn(name = PARENT_ID)
    private Set<E> childrenCategories = new HashSet<>();

    @Override
    public String toString() {
        return "BaseCategory{" +
                "title='" + title + '\'' +
                '}';
    }
}
