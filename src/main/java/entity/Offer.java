package entity;

import base.entity.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Offer extends BaseEntity<Long> {
    @ManyToOne
    Order order;
    @ManyToOne
    Specialist specialist;
    LocalDate localDate=LocalDate.now();
    LocalTime localTime=LocalTime.now();
    Double OfferPrice;
    LocalDate startDayOffer;
    LocalTime startTimeOffer;
    Duration duration;

}
