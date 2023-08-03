package entity;

import base.entity.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SubService extends BaseEntity<Long> {
    String name;
    Double price;
    String description;
    @ManyToOne
    Service service;
    @ManyToMany
    @ToString.Exclude
    Set<Specialist> specialistSet=new HashSet<>();
}
