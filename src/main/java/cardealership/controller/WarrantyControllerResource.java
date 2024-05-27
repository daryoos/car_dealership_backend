package cardealership.controller;

import cardealership.dto.UserDto;
import cardealership.dto.WarrantyDto;
import cardealership.model.Warranty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/warranties")
public interface WarrantyControllerResource {

    @GetMapping(value = "/getById/{id}")
    ResponseEntity<Warranty> getById(@PathVariable Long id);

    @PostMapping(value = "/add")
    ResponseEntity<String> add(@RequestBody WarrantyDto warrantyDto);

    @PutMapping(value = "/update/{id}")
    ResponseEntity<String> update(@RequestBody WarrantyDto warrantyDto, @PathVariable Long id);

    @DeleteMapping(value = "/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id);

}
