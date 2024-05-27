package cardealership.service;

import cardealership.dto.EngineDto;
import cardealership.model.Engine;
import cardealership.repository.EngineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EngineServiceImpl implements EngineService {

    private final EngineRepository engineRepository;

    @Override
    public Engine getById(Long id) {
        Engine engine = engineRepository.findById(id);
        System.out.println(engine);
        return engine;
    }

    @Override
    public void add(Engine engine) throws Exception {
        try {
            engineRepository.save(engine);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void update(EngineDto engineDto, Long id) throws Exception {
        Engine engine = engineRepository.findById(id);
        if (engine != null) {
            engine.setCapacity(engineDto.getCapacity());
            engine.setCombustion(engineDto.getCombustion());
            engine.setPrice(engineDto.getPrice());
            engine.setHorsePower(engineDto.getHorsePower());
            engineRepository.save(engine);
        }
        else {
            throw new Exception("Engine not found");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Engine engine = engineRepository.findById(id);
        if (engine != null) {
            engineRepository.delete(engine);
        }
        else {
            throw new Exception("Engine not found");
        }
    }
}
