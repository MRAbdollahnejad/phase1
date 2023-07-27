package entity;

import base.entity.BaseUserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Manager extends BaseUserEntity {

}
