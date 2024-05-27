package cardealership.mapper;

import cardealership.dto.VehicleSpecificAddDto;
import cardealership.dto.VehicleSpecificDto;
import cardealership.model.VehicleSpecific;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class VehicleSpecificMapper {

    private VehicleSpecific vehicleSpecific;
    private VehicleSpecificDto vehicleSpecificDto;
    private VehicleSpecificAddDto vehicleSpecificAddDto;

    public VehicleSpecificDto toDto() {
        return toVehicleSpecificDto(vehicleSpecific);
    }

    public VehicleSpecificAddDto toAddDto() {
        return toVehicleSpecificAddDto(vehicleSpecific);
    }

    public VehicleSpecific toEntity() {
        return toVehicleSpecificEntity(vehicleSpecificDto);
    }

    public VehicleSpecific addToEntity() {
        return addToVehicleSpecificEntity(vehicleSpecificAddDto);
    }

    private VehicleSpecificDto toVehicleSpecificDto(VehicleSpecific vehicleSpecific) {
        VehicleSpecificDto vehicleSpecificDto = new VehicleSpecificDto();

        vehicleSpecificDto.setVehicleId(vehicleSpecific.getVehicleId());
        vehicleSpecificDto.setVehicleId(vehicleSpecific.getVehicleId());
        vehicleSpecificDto.setColor(vehicleSpecific.getColor());
        vehicleSpecificDto.setPrice(vehicleSpecific.getPrice());
        vehicleSpecificDto.setYear(vehicleSpecific.getYear());
        vehicleSpecificDto.setTrim(vehicleSpecific.getTrim());
        vehicleSpecificDto.setEngineId(vehicleSpecific.getEngineId());
        vehicleSpecificDto.setSold(vehicleSpecific.getSold());

        return vehicleSpecificDto;
    }

    private VehicleSpecificAddDto toVehicleSpecificAddDto(VehicleSpecific vehicleSpecific) {
        VehicleSpecificAddDto vehicleSpecificDto = new VehicleSpecificAddDto();

        vehicleSpecificDto.setColor(vehicleSpecific.getColor());
        vehicleSpecificDto.setPrice(vehicleSpecific.getPrice());
        vehicleSpecificDto.setYear(vehicleSpecific.getYear());
        vehicleSpecificDto.setTrim(vehicleSpecific.getTrim());
        vehicleSpecificDto.setEngineId(vehicleSpecific.getEngineId());
        vehicleSpecificDto.setSold(vehicleSpecific.getSold());

        return vehicleSpecificDto;
    }

    private VehicleSpecific toVehicleSpecificEntity(VehicleSpecificDto vehicleSpecificDto) {
        VehicleSpecific vehicleSpecific = new VehicleSpecific();

        vehicleSpecific.setVehicleId(vehicleSpecificDto.getVehicleId());
        vehicleSpecific.setYear(vehicleSpecificDto.getYear());
        vehicleSpecific.setTrim(vehicleSpecificDto.getTrim());
        vehicleSpecific.setPrice(vehicleSpecificDto.getPrice());
        vehicleSpecific.setColor(vehicleSpecificDto.getColor());
        vehicleSpecific.setEngineId(vehicleSpecificDto.getEngineId());
        vehicleSpecific.setVehicleId(vehicleSpecificDto.getVehicleId());
        vehicleSpecific.setSold(vehicleSpecificDto.getSold());

        return vehicleSpecific;
    }

    private VehicleSpecific addToVehicleSpecificEntity(VehicleSpecificAddDto vehicleSpecificDto) {
        VehicleSpecific vehicleSpecific = new VehicleSpecific();

        vehicleSpecific.setYear(vehicleSpecificDto.getYear());
        vehicleSpecific.setTrim(vehicleSpecificDto.getTrim());
        vehicleSpecific.setPrice(vehicleSpecificDto.getPrice());
        vehicleSpecific.setColor(vehicleSpecificDto.getColor());
        vehicleSpecific.setEngineId(vehicleSpecificDto.getEngineId());
        vehicleSpecific.setVehicleId(vehicleSpecificDto.getVehicleId());
        vehicleSpecific.setSold(vehicleSpecificDto.getSold());

        return vehicleSpecific;
    }
}
