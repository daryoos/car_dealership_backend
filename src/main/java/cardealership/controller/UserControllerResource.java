package cardealership.controller;

import cardealership.dto.*;
import cardealership.model.User;
import cardealership.model.Vehicle;
import com.azure.core.annotation.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/users")
public interface UserControllerResource {

    @GetMapping(value = "/getById/{id}")
    ResponseEntity<User> getById(@PathVariable Long id);

    @PostMapping(value = "/add")
    ResponseEntity<String> add(@RequestBody UserDto userDto);

    @PutMapping(value = "/update/{id}")
    ResponseEntity<String> update(@RequestBody UserAddDto userDto, @PathVariable Long id);

    @DeleteMapping(value = "/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id);

    @PostMapping(value = "/login")
    ResponseEntity<UserLoggedDto> login(@RequestBody UserLoginDto userLoginDto) throws  Exception;

    @PostMapping(value = "/register")
    ResponseEntity<User> register(@RequestBody UserAddDto userAddDto) throws Exception;

    @PostMapping(value = "/logout")
    ResponseEntity<String> logout();

    @GetMapping(value = "/getAll")
    ResponseEntity<List<User>> getAll();

    @GetMapping(value = "/getAllDto")
    ResponseEntity<List<UserGetDto>> getAllDto();
}
