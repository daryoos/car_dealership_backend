package cardealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WarrantyDto {
    private Float price;
    private Integer years;
    private Date endDate;
}
