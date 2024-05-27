package cardealership.service;

import cardealership.dto.VehicleSpecificDto;
import cardealership.model.Vehicle;
import cardealership.model.VehicleSpecific;
import cardealership.repository.VehicleSpecificRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleSpecificServiceImpl implements VehicleSpecificService {

    private final VehicleSpecificRepository vehicleSpecificRepository;

    @Override
    public VehicleSpecific getById(Long id) {
        VehicleSpecific vehicleSpecific = vehicleSpecificRepository.findById(id);
        System.out.println("LOG:\n" + vehicleSpecific + "\n");
        return vehicleSpecific;
    }

    @Override
    public void add(VehicleSpecific vehicleSpecific) throws Exception {
        try {
            vehicleSpecificRepository.save(vehicleSpecific);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void update(VehicleSpecificDto vehicleSpecificDto, Long id) throws Exception {
        VehicleSpecific vehicleSpecific = vehicleSpecificRepository.findById(id);
        if (vehicleSpecific != null) {
            vehicleSpecific.setColor(vehicleSpecificDto.getColor());
            vehicleSpecific.setTrim(vehicleSpecificDto.getTrim());
            vehicleSpecific.setPrice(vehicleSpecificDto.getPrice());
            vehicleSpecific.setYear(vehicleSpecificDto.getYear());
            vehicleSpecificRepository.save(vehicleSpecific);
        }
        else {
            throw new Exception("Vehicle specific not found");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        VehicleSpecific vehicleSpecific = vehicleSpecificRepository.findById(id);
        if (vehicleSpecific != null) {
            vehicleSpecificRepository.delete(vehicleSpecific);
        }
        else {
            throw new Exception("Vehicle specific not found");
        }
    }

    @Override
    public List<VehicleSpecific> getAll() {
        return vehicleSpecificRepository.findAll();
    }

    @Override
    public List<VehicleSpecific> getByVehicleId(Long id) {
        return vehicleSpecificRepository.findByVehicleId(id);
    }
}
