package cardealership.mapper;

import cardealership.dto.VehicleDto;
import cardealership.model.User;
import cardealership.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class VehicleMapper {

    private Vehicle vehicle;
    private VehicleDto vehicleDto;

    public VehicleDto toDto() {
        return toVehicleDto(vehicle);
    }

    public Vehicle toEntity() {
        return toVehicleEntity(vehicleDto);
    }

    private VehicleDto toVehicleDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setId(vehicle.getId());
        vehicleDto.setMake(vehicle.getMake());
        vehicleDto.setModel(vehicle.getModel());

        return vehicleDto;
    }

    private Vehicle toVehicleEntity(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(vehicleDto.getId());
        vehicle.setMake(vehicleDto.getMake());
        vehicle.setModel(vehicleDto.getModel());

        return vehicle;
    }
}
