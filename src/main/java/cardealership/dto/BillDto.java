package cardealership.dto;

import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillDto {
    private Long id;
    private Float price;
    private Date date;
    private Long userId;
    private Long vehicleSpecificId;
    private Long warrantyId;
    private Boolean cart;
}
