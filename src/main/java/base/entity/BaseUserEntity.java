package base.entity;

import entity.Credit;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
@Table(name = BaseUserEntity.NAME)
public class BaseUserEntity extends BaseEntity<Long>{
    public static final String NAME="base_users_entity";
    String firstname;
    String lastname;
    String emailAddress;
    String password;
    LocalDate createDate=LocalDate.now();
    LocalTime createTime=LocalTime.now();
    @OneToOne
    Credit credit;
}
