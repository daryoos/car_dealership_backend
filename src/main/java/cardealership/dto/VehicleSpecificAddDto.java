package cardealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleSpecificAddDto {
    private Long vehicleId;
    private Integer year;
    private String color;
    private Long engineId;
    private String trim;
    private Float price;
    private Boolean sold;
}