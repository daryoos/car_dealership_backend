package cardealership.service;

import cardealership.dto.VehicleDto;
import cardealership.mapper.VehicleMapper;
import cardealership.model.Vehicle;
import cardealership.repository.UserRepository;
import cardealership.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public Vehicle getById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        System.out.println("LOG:\n" + vehicle + "\n");
        return vehicle;
    }

    @Override
    public void add(Vehicle vehicle) throws Exception {
        try {
            vehicleRepository.save(vehicle);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void update(VehicleDto vehicleDto, Long id) throws Exception {
        Vehicle vehicleToUpdate = vehicleRepository.findById(id);
        if (vehicleToUpdate != null) {
            vehicleToUpdate.setMake(vehicleDto.getMake());
            vehicleToUpdate.setModel(vehicleDto.getModel());
            vehicleRepository.save(vehicleToUpdate);
        }
        else {
            throw new Exception("Vehicle not found");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle != null) {
            vehicleRepository.delete(vehicle);
        }
        else {
            throw new Exception("Vehicle not found");
        }
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<VehicleDto> getAllDto() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for(Vehicle vehicle : vehicles) {
            VehicleDto vehicleDto = vehicleMapper.withVehicle(vehicle).toDto();
            vehicleDtos.add(vehicleDto);
        }
        return vehicleDtos;
    }

    @Override
    public List<String> getAllMakes() {
        List<String> makes = vehicleRepository.findAllMakes();
        return makes;
    }

    @Override
    public List<Vehicle> getByMake(String make) {
        List<Vehicle> vehicles = vehicleRepository.findByMake(make);
        return vehicles;
    }
}
