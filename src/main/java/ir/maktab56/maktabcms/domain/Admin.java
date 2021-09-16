package ir.maktab56.maktabcms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User {

    public static final String IS_SUPER_ADMIN = "IS_SUPER_ADMIN";

    @Column(name = IS_SUPER_ADMIN)
    private Boolean isSuperAdmin;
}
