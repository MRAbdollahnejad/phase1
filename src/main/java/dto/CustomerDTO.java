package dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults( level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CustomerDTO {
    String firstname;
    String lastname;
    String emailAddress;
    String password;
}
