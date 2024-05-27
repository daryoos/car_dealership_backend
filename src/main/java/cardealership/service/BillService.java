package cardealership.service;

import cardealership.dto.BillDto;
import cardealership.dto.UserDto;
import cardealership.model.Bill;
import cardealership.model.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BillService {
    Bill getById(Long id);

    void add(Bill bill) throws Exception;

    void update(BillDto billDto, Long id) throws Exception;

    void delete(Long id) throws Exception;

    List<Bill> getAll();

    List<BillDto> getAllDto();

    List<Bill> getByUserId(Long id);

    Bill getCart(Long id);
}
