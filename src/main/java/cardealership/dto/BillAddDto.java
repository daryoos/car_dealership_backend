package cardealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillAddDto {
    private Date date;
    private Long userId;
    private Long vehicleSpecificId;
}
