package cardealership.repository;

import cardealership.model.User;
import cardealership.model.Warranty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WarrantyRepository extends CrudRepository<Warranty, Integer> {

    @Query(value = "select wrt from Warranty wrt where wrt.id = :id ")
    Warranty findById(@Param(value = "id") Long id);

}
