package entity;

import base.entity.BaseEntity;
import entity.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customersorder")
public class Order extends BaseEntity<Long> {

    @ManyToOne
    SubService subService;
    Double orderPrice;
    String OrderDescription;
    LocalDate startDay;
    LocalTime startTime;
    String address;
    OrderStatus orderStatus;
    @OneToMany(mappedBy = "order")
    Set<Offer> offers = new HashSet<>();
    @OneToOne
    CustomerOpinion customerOpinion;
}
