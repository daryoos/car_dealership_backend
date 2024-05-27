package cardealership.controller;

import cardealership.dto.VehicleSpecificAddDto;
import cardealership.dto.VehicleSpecificDto;
import cardealership.model.VehicleSpecific;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/vehicleSpecific")
public interface VehicleSpecificControllerResource {
    @GetMapping(value = "/getById/{id}")
    ResponseEntity<VehicleSpecific> getById(@PathVariable Long id);

    @PostMapping(value = "/add")
    ResponseEntity<String> add(@RequestBody VehicleSpecificAddDto vehicleSpecificDto);

    @PutMapping(value = "/update/{id}")
    ResponseEntity<String> update(@RequestBody VehicleSpecificDto vehicleSpecificDto, @PathVariable Long id);

    @DeleteMapping(value = "/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id);

    @GetMapping(value = "/getAll")
    ResponseEntity<List<VehicleSpecific>> getAll();

    @GetMapping(value = "/getByVehicleId/{id}")
    ResponseEntity<List<VehicleSpecific>> getByVehicleId(@PathVariable Long id);
}
