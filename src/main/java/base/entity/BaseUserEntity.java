package base.entity;

import entity.Credit;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalTime;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseUserEntity extends BaseEntity<Long>{
    String firstname;
    String lastname;
    String emailAddress;
    String password;
    LocalDate localDate=LocalDate.now();
    LocalTime localTime=LocalTime.now();
    @OneToOne
    Credit credit;
}
