package ir.maktab56.maktabcms.domain;

import ir.maktab56.maktabcms.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = User.TABLE_NAME)
@Inheritance
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "user_table";

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USER_NAME = "user_name";
    public static final String PASSWORD = "password";
    public static final String USER_TYPE = "user_type";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String EMAIL = "email";
    public static final String BIRTH_DATE = "birth_date";

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = USER_NAME, unique = true)
    private String username;

    @Column(name = PASSWORD)
    private String password;

    @Column(name = USER_TYPE)
    private String userType;

    @Column(name = MOBILE_NUMBER)
    private String mobileNumber;

    @Column(name = EMAIL)
    private String email;

    @Column(name = BIRTH_DATE)
    private ZonedDateTime birthDate;

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
