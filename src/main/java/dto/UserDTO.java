package dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults( level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserDTO implements Serializable {
    String firstname;
    String lastname;
    String emailAddress;
    String password;
}
