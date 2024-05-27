package cardealership.controller;

import cardealership.dto.VehicleSpecificAddDto;
import cardealership.dto.VehicleSpecificDto;
import cardealership.mapper.VehicleSpecificMapper;
import cardealership.model.VehicleSpecific;
import cardealership.repository.VehicleSpecificRepository;
import cardealership.service.VehicleSpecificService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class VehicleSpecificController implements VehicleSpecificControllerResource {

    private final VehicleSpecificService vehicleSpecificService;
    private final VehicleSpecificRepository vehicleSpecificRepository;
    private final VehicleSpecificMapper vehicleSpecificMapper;

    @Override
    public ResponseEntity<VehicleSpecific> getById(Long id) {
        VehicleSpecific vehicleSpecific = vehicleSpecificService.getById(id);

        return ResponseEntity.status(200).body(vehicleSpecific);
    }

    @Override
    public ResponseEntity<String> add(VehicleSpecificAddDto vehicleSpecificDto) {
        VehicleSpecific vehicleSpecific = vehicleSpecificMapper.withVehicleSpecificAddDto(vehicleSpecificDto).addToEntity();
        try {
            vehicleSpecificService.add(vehicleSpecific);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Vehicle specific added");
    }

    @Override
    public ResponseEntity<String> update(VehicleSpecificDto vehicleSpecificDto, Long id) {
        try {
            vehicleSpecificService.update(vehicleSpecificDto, id);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Vehicle specific updated");
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            vehicleSpecificService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Vehicle specific deleted");
    }

    @Override
    public ResponseEntity<List<VehicleSpecific>> getAll() {
        List<VehicleSpecific> vehicleSpecifics = vehicleSpecificService.getAll();
        return ResponseEntity.status(200).body(vehicleSpecifics);
    }

    @Override
    public ResponseEntity<List<VehicleSpecific>> getByVehicleId(Long id) {
        List<VehicleSpecific> vehicleSpecifics = vehicleSpecificService.getByVehicleId(id);

        return ResponseEntity.status(200).body(vehicleSpecifics);
    }
}
