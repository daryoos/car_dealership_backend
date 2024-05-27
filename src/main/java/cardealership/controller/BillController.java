package cardealership.controller;

import cardealership.dto.BillAddDto;
import cardealership.dto.BillDto;
import cardealership.mapper.BillMapper;
import cardealership.mapper.VehicleSpecificMapper;
import cardealership.model.Bill;
import cardealership.model.Engine;
import cardealership.model.User;
import cardealership.model.VehicleSpecific;
import cardealership.repository.BillRepository;
import cardealership.repository.VehicleSpecificRepository;
import cardealership.service.BillService;
import cardealership.service.EngineService;
import cardealership.service.UserService;
import cardealership.service.VehicleSpecificService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class BillController implements BillControllerResource{

    private final BillRepository billRepository;
    private final BillService billService;
    private final BillMapper billMapper;
    private final VehicleSpecificService vehicleSpecificService;
    private final EngineService engineService;
    private final UserService userService;
    private final VehicleSpecificRepository vehicleSpecificRepository;
    private final VehicleSpecificMapper vehicleSpecificMapper;

    @Override
    public ResponseEntity<Bill> getById(Long id) {
        Bill bill = billService.getById(id);

        return ResponseEntity.ok().body(bill);
    }

    @Override
    public ResponseEntity<String> add(BillAddDto billDto) {
        List<Bill> bills = billService.getByUserId(billDto.getUserId());
        for (Bill bill : bills) {
            if (bill.getCart()) {
                return ResponseEntity.ok().body("User already has a cart");
            }
        }

        Bill bill = billMapper.withBillAddDto(billDto).addToEntity();
        VehicleSpecific vehicleSpecific = vehicleSpecificService.getById(billDto.getVehicleSpecificId());
        Engine engine = engineService.getById(vehicleSpecific.getEngineId());
        bill.setPrice(vehicleSpecific.getPrice() + engine.getPrice());
        bill.setCart(true);

        try {
            billService.add(bill);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Created Successfully");
    }

    @Override
    public ResponseEntity<String> update(BillDto billDto, Long id) {
        try {
            billService.update(billDto, id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not found");
        }
        return ResponseEntity.ok().body("Updated Successfully");
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            billService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Deleted");
    }

    @Override
    public ResponseEntity<List<Bill>> getAll() {
        List<Bill> bills = billService.getAll();
        return ResponseEntity.ok().body(bills);
    }

    @Override
    public ResponseEntity<List<Bill>> getByUserId(Long id) {
        List<Bill> bills = billService.getByUserId(id);

        return ResponseEntity.ok().body(bills);
    }

    @Override
    public ResponseEntity<Bill> getCart(Long id) {
        Bill bill = billService.getCart(id);

        return ResponseEntity.ok().body(bill);
    }

    // IMPLEMENT MAIL
    @Override
    public ResponseEntity<String> placeOrder(BillDto billDto) {
        User user = userService.getById(billDto.getUserId());
        VehicleSpecific vehicleSpecific = vehicleSpecificService.getById(billDto.getVehicleSpecificId());

        vehicleSpecific.setSold(true);

        try {
            vehicleSpecificService.update(vehicleSpecificMapper.withVehicleSpecific(vehicleSpecific).toDto(), billDto.getVehicleSpecificId());
            billDto.setCart(false);
            billService.update(billDto, billDto.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().body("Placed Successfully");
    }
}
