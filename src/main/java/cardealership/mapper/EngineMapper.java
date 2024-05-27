package cardealership.mapper;

import cardealership.dto.EngineDto;
import cardealership.model.Engine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EngineMapper {
    private Engine engine;
    private EngineDto engineDto;

    public EngineDto toDto() {
        return toEngineDto(engine);
    }

    public Engine toEntity() {
        return toEngineEntity(engineDto);
    }

    private EngineDto toEngineDto(Engine engine) {
        EngineDto engineDto = new EngineDto();

        engineDto.setId(engine.getId());
        engineDto.setCapacity(engine.getCapacity());
        engineDto.setCombustion(engine.getCombustion());
        engineDto.setPrice(engine.getPrice());
        engineDto.setHorsePower(engine.getHorsePower());

        return engineDto;
    }

    private Engine toEngineEntity(EngineDto engineDto) {
        Engine engine = new Engine();

        engine.setId(engineDto.getId());
        engine.setCapacity(engineDto.getCapacity());
        engine.setCombustion(engineDto.getCombustion());
        engine.setPrice(engineDto.getPrice());
        engine.setHorsePower(engineDto.getHorsePower());

        return engine;
    }
}
