package cardealership.repository;

import cardealership.model.Bill;
import cardealership.model.User;
import cardealership.model.VehicleSpecific;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleSpecificRepository extends CrudRepository<VehicleSpecific, Integer> {
    @Query(value = "select vhclsp from VehicleSpecific vhclsp where vhclsp.id = :id ")
    VehicleSpecific findById(@Param(value = "id") Long id);

    @Query(value = "select vhclsp from VehicleSpecific vhclsp")
    List<VehicleSpecific> findAll();

    @Query(value = "select vhclsp from VehicleSpecific vhclsp where vhclsp.vehicleId = :id and vhclsp.sold = false")
    List<VehicleSpecific> findByVehicleId(@Param(value = "id") Long id);
}
