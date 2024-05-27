package cardealership.controller;

import cardealership.dto.BillAddDto;
import cardealership.dto.BillDto;
import cardealership.dto.UserDto;
import cardealership.model.Bill;
import cardealership.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/bills")
public interface BillControllerResource {
    @GetMapping(value = "/getById/{id}")
    ResponseEntity<Bill> getById(@PathVariable Long id);

    @PostMapping(value = "/add")
    ResponseEntity<String> add(@RequestBody BillAddDto billDto);

    @PutMapping(value = "/update/{id}")
    ResponseEntity<String> update(@RequestBody BillDto billDto, @PathVariable Long id);

    @DeleteMapping(value = "/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id);

    @GetMapping(value = "/getAll")
    ResponseEntity<List<Bill>> getAll();

    @GetMapping(value = "/getByUserId/{id}")
    ResponseEntity<List<Bill>> getByUserId(@PathVariable Long id);

    @GetMapping(value = "/getCart/{id}")
    ResponseEntity<Bill> getCart(@PathVariable Long id);

    @PostMapping(value = "/placeOrder")
    ResponseEntity<String> placeOrder(@RequestBody BillDto billDto);
}
