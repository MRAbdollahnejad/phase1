package dto;

import entity.enums.SpecialistStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults( level = AccessLevel.PRIVATE)
@Getter
@Setter
public class SpecialistDTO extends UserDTO implements Serializable {
    SpecialistStatus status=SpecialistStatus.AwaitingConfirmation;
    Integer score = 0;
    String imagePath;


}
