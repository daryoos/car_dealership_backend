package cardealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserGetDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private Boolean isAdmin;
}
