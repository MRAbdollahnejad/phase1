package entity;

import base.entity.BaseUserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseUserEntity {
    @OneToMany
    @JoinColumn
    Set<Order> orderSet =new HashSet<>();
}
