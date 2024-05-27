package cardealership.mapper;

import cardealership.dto.BillAddDto;
import cardealership.dto.BillDto;
import cardealership.model.Bill;
import cardealership.model.VehicleSpecific;
import cardealership.service.VehicleSpecificService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BillMapper {
    private Bill bill;
    private BillDto billDto;
    private BillAddDto billAddDto;

    public BillDto toDto() {
        return toBillDto(bill);
    }

    public BillAddDto toAddDto() {
        return toBillAddDto(bill);
    }

    public Bill toEntity() {
        return toBillEntity(billDto);
    }

    public Bill addToEntity() {
        return addToBillEntity(billAddDto);
    }

    private BillDto toBillDto(Bill bill) {
        BillDto billDto = new BillDto();

        billDto.setId(bill.getId());
        billDto.setDate(bill.getDate());
        billDto.setPrice(bill.getPrice());
        billDto.setUserId(bill.getUserId());
        billDto.setVehicleSpecificId(bill.getVehicleSpecificId());
        billDto.setWarrantyId(bill.getWarrantyId());
        billDto.setCart(bill.getCart());

        return billDto;
    }

    private BillAddDto toBillAddDto(Bill bill) {
        BillAddDto billDto = new BillAddDto();

        billDto.setDate(bill.getDate());
        billDto.setUserId(bill.getUserId());
        billDto.setVehicleSpecificId(bill.getVehicleSpecificId());

        return billDto;
    }

    private Bill toBillEntity(BillDto billDto) {
        Bill bill = new Bill();

        bill.setId(billDto.getId());
        bill.setDate(billDto.getDate());
        bill.setPrice(billDto.getPrice());
        bill.setUserId(billDto.getUserId());
        bill.setVehicleSpecificId(billDto.getVehicleSpecificId());
        bill.setWarrantyId(billDto.getWarrantyId());
        bill.setCart(billDto.getCart());

        return bill;
    }

    private Bill addToBillEntity(BillAddDto billDto) {
        Bill bill = new Bill();

        bill.setDate(billDto.getDate());
        bill.setUserId(billDto.getUserId());
        bill.setVehicleSpecificId(billDto.getVehicleSpecificId());

        return bill;
    }
}
