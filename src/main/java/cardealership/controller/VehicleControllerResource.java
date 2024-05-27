package cardealership.controller;

import cardealership.dto.UserDto;
import cardealership.dto.VehicleDto;
import cardealership.dto.VehicleSpecificDto;
import cardealership.model.User;
import cardealership.model.Vehicle;
import cardealership.model.VehicleSpecific;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/vehicles")
public interface VehicleControllerResource {
    @GetMapping(value = "/getById/{id}")
    ResponseEntity<Vehicle> getById(@PathVariable Long id);

    @PostMapping(value = "/add")
    ResponseEntity<String> add(@RequestBody VehicleDto vehicleDto);

    @PutMapping(value = "/update")
    ResponseEntity<String> update(@RequestBody VehicleDto vehicleDto);

    @DeleteMapping(value = "/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id);

    @GetMapping(value = "/getAll")
    ResponseEntity<List<Vehicle>> getAll();

    @GetMapping(value = "/getAllDto")
    ResponseEntity<List<VehicleDto>> getAllDto();

    @GetMapping(value = "/getAllMakes")
    ResponseEntity<List<String>> getAllMakes();

    @GetMapping(value = "/getByMake/{make}")
    ResponseEntity<List<Vehicle>> getByMake(@PathVariable String make);
}
