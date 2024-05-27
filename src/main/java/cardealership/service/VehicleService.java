package cardealership.service;

import cardealership.dto.UserDto;
import cardealership.dto.VehicleDto;
import cardealership.dto.VehicleSpecificDto;
import cardealership.model.User;
import cardealership.model.Vehicle;
import cardealership.model.VehicleSpecific;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VehicleService {
    Vehicle getById(Long id);

    void add(Vehicle vehicle) throws Exception;

    void update(VehicleDto vehicleDto, Long id) throws Exception;

    void delete(Long id) throws Exception;

    List<Vehicle> getAll();

    List<VehicleDto> getAllDto();

    List<String> getAllMakes();

    List<Vehicle> getByMake(String make);
}
