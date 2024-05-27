package cardealership.controller;

import cardealership.dto.EngineDto;
import cardealership.dto.UserDto;
import cardealership.model.Engine;
import cardealership.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/engines")
public interface EngineControllerResource {
    @GetMapping(value = "/getById/{id}")
    ResponseEntity<Engine> getById(@PathVariable Long id);

    @PostMapping(value = "/add")
    ResponseEntity<String> add(@RequestBody EngineDto engineDto);

    @PutMapping(value = "/update/{id}")
    ResponseEntity<String> update(@RequestBody EngineDto engineDto, @PathVariable Long id);

    @DeleteMapping(value = "/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id);
}
