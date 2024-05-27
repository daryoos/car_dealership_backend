package cardealership.service;

import cardealership.dto.VehicleSpecificDto;
import cardealership.model.Bill;
import cardealership.model.VehicleSpecific;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VehicleSpecificService {
    VehicleSpecific getById(Long id);

    void add(VehicleSpecific vehicleSpecific) throws Exception;

    void update(VehicleSpecificDto vehicleSpecificDto, Long id) throws Exception;

    void delete(Long id) throws Exception;

    List<VehicleSpecific> getAll();

    List<VehicleSpecific> getByVehicleId(Long id);
}
