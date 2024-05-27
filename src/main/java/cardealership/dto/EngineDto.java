package cardealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EngineDto {
    private Long id;
    private Float capacity;
    private String combustion;
    private Integer horsePower;
    private Float price;
}
