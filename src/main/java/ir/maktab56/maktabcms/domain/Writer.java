package ir.maktab56.maktabcms.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.ZonedDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Writer extends User {

    @Builder
    public Writer(String firstName, String lastName, String username, String password,
                  String userType, String mobileNumber, String email, ZonedDateTime birthDate) {
        super(firstName, lastName, username, password, userType, mobileNumber, email, birthDate);
    }
}
