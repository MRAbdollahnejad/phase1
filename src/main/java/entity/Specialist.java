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
    @Lob
    byte[] image;
    Integer score = 0;


}
























