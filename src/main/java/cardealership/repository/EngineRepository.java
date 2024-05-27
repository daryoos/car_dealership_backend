package cardealership.repository;

import cardealership.model.Engine;
import cardealership.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends CrudRepository<Engine, Integer> {

    @Query(value = "select eng from Engine eng where eng.id = :id ")
    Engine findById(@Param(value = "id") Long id);

}
