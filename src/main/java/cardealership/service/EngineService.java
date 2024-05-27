package cardealership.service;

import cardealership.dto.EngineDto;
import cardealership.dto.UserDto;
import cardealership.model.Engine;
import cardealership.model.User;
import org.springframework.stereotype.Component;

@Component
public interface EngineService {
    Engine getById(Long id);

    void add(Engine engine) throws Exception;

    void update(EngineDto engineDto, Long id) throws Exception;

    void delete(Long id) throws Exception;
}
