package cardealership.repository;

import cardealership.dto.BillDto;
import cardealership.model.Bill;
import cardealership.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {

    @Query(value = "select bll from Bill bll where bll.id = :id ")
    Bill findById(@Param(value = "id") Long id);

    @Query(value = "select bll from Bill bll")
    List<Bill> findAll();

    @Query(value = "select bll from Bill bll where bll.userId = :id ")
    List<Bill> findByUserId(@Param(value = "id") Long id);

    @Query(value = "select bll from Bill bll where bll.userId = :id and bll.cart = true")
    Bill findCart(@Param(value = "id") Long id);
}
