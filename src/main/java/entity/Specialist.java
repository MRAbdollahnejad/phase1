package entity;

import base.entity.BaseUserEntity;
import entity.enums.SpecialistStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Specialist extends BaseUserEntity {
    SpecialistStatus status;
    Byte[] image;
    Integer score = 0;

//    @JoinTable(name = "specialist-subService",
//            joinColumns = @JoinColumn(name="specialistId"),
//            inverseJoinColumns = @JoinColumn(name = "subServiceId"))
    @ManyToMany
    Set<SubService> subServices=new HashSet<>();
}
























