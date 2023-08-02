package dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults( level = AccessLevel.PRIVATE)
@Getter
@Setter
public class SubServiceDTO {
    String name;
    Double price;
    String description;
}

