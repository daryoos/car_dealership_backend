package cardealership.service;

import cardealership.dto.UserAddDto;
import cardealership.dto.UserDto;
import cardealership.dto.UserGetDto;
import cardealership.dto.VehicleDto;
import cardealership.model.User;
import cardealership.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    User getById(Long id);

    void add(User user) throws Exception;

    void update(UserAddDto userDto, Long id) throws Exception;

    void delete(Long id) throws Exception;

    List<User> getAll();

    List<UserGetDto> getAllDto();
}
