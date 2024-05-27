package cardealership.controller;

import cardealership.dto.UserDto;
import cardealership.dto.VehicleDto;
import cardealership.mapper.VehicleMapper;
import cardealership.model.User;
import cardealership.model.Vehicle;
import cardealership.repository.VehicleRepository;
import cardealership.service.UserService;
import cardealership.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class VehicleController implements VehicleControllerResource {

    private final VehicleService vehicleService;
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public ResponseEntity<Vehicle> getById(Long id) {
        Vehicle vehicle = vehicleService.getById(id);

        return ResponseEntity.status(200).body(vehicle);
    }

    @Override
    public ResponseEntity<String> add(VehicleDto vehicleDto) {

        Vehicle vehicle = vehicleMapper.withVehicleDto(vehicleDto).toEntity();

        try {
            vehicleService.add(vehicle);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Vehicle added successfully");
    }

    @Override
    public ResponseEntity<String> update(VehicleDto vehicleDto) {
        try {
            vehicleService.update(vehicleDto, vehicleDto.getId());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Vehicle updated successfully");
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            vehicleService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Vehicle deleted successfully");
    }

    @Override
    public ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> vehicles = vehicleService.getAll();
        return ResponseEntity.status(200).body(vehicles);
    }

    @Override
    public ResponseEntity<List<VehicleDto>> getAllDto() {
        List<VehicleDto> vehicleDtos = vehicleService.getAllDto();
        return ResponseEntity.status(200).body(vehicleDtos);
    }

    @Override
    public ResponseEntity<List<String>> getAllMakes() {
        List<String> makes = vehicleService.getAllMakes();
        return ResponseEntity.status(200).body(makes);
    }

    @Override
    public ResponseEntity<List<Vehicle>> getByMake(String make) {
        List<Vehicle> vehicles = vehicleService.getByMake(make);
        return ResponseEntity.status(200).body(vehicles);
    }
}
