package cardealership.service;

import cardealership.dto.UserDto;
import cardealership.dto.WarrantyDto;
import cardealership.model.User;
import cardealership.model.Warranty;
import org.springframework.stereotype.Component;

@Component
public interface WarrantyService {
    Warranty getById(Long id);

    void add(Warranty warranty) throws Exception;

    void update(WarrantyDto warrantyDto, Long id) throws Exception;

    void delete(Long id) throws Exception;
}
