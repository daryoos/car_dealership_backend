package cardealership.repository;

import cardealership.model.User;
import cardealership.model.Vehicle;
import cardealership.model.VehicleSpecific;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    @Query(value = "select vhcl from Vehicle vhcl where vhcl.id = :id ")
    Vehicle findById(@Param(value = "id") Long id);

    @Query(value = "select vhcl from Vehicle vhcl")
    List<Vehicle> findAll();

    @Query(value = "select vhcl.make from Vehicle vhcl")
    List<String> findAllMakes();

    @Query(value = "select vhcl from Vehicle vhcl where vhcl.make = :make")
    List<Vehicle> findByMake(@Param(value = "make") String make);

}
