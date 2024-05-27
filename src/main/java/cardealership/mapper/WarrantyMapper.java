package cardealership.mapper;

import cardealership.dto.WarrantyDto;
import cardealership.model.Warranty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class WarrantyMapper {
    private Warranty warranty;
    private WarrantyDto warrantyDto;

    public WarrantyDto toDto() {
        return toWarrantyDto(warranty);
    }

    public Warranty toEntity() {
        return toWarrantyEntity(warrantyDto);
    }

    private WarrantyDto toWarrantyDto(Warranty warranty) {
        WarrantyDto warrantyDto = new WarrantyDto();

        warrantyDto.setPrice(warranty.getPrice());
        warrantyDto.setYears(warranty.getYears());
        warrantyDto.setEndDate(warranty.getEndDate());

        return warrantyDto;
    }

    private Warranty toWarrantyEntity(WarrantyDto warrantyDto) {
        Warranty warranty = new Warranty();

        warranty.setPrice(warrantyDto.getPrice());
        warranty.setYears(warrantyDto.getYears());
        warranty.setEndDate(warrantyDto.getEndDate());

        return warranty;
    }
}
