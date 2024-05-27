package cardealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@NoArgsConstructor
@AllArgsConstructor
@Data
@With
public class UserLoggedDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private Boolean isAdmin;
}
