package entity;

import base.entity.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Service extends BaseEntity<Long> {

    String databaseName;

    String name;



    @OneToMany(mappedBy = "service")
    @ToString.Exclude
    Set<SubService> subService =new HashSet<>();

}
