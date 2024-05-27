package cardealership.controller;

import cardealership.dto.EngineDto;
import cardealership.mapper.EngineMapper;
import cardealership.model.Engine;
import cardealership.repository.EngineRepository;
import cardealership.service.EngineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
public class EngineController implements EngineControllerResource{

    private final EngineService engineService;
    private final EngineMapper engineMapper;
    private final EngineRepository engineRepository;

    @Override
    public ResponseEntity<Engine> getById(Long id) {
        Engine engine = engineService.getById(id);

        return ResponseEntity.ok(engine);
    }

    @Override
    public ResponseEntity<String> add(EngineDto engineDto) {
        Engine engine = engineMapper.withEngineDto(engineDto).toEntity();

        try {
            engineService.add(engine);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Successfully added engine");
    }

    @Override
    public ResponseEntity<String> update(EngineDto engineDto, Long id) {
        try {
            engineService.update(engineDto, id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Successfully updated engine");
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            engineService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Successfully deleted engine");
    }
}
