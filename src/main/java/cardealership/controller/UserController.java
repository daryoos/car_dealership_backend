package cardealership.controller;

import cardealership.dto.*;
import cardealership.mapper.UserMapper;
import cardealership.model.User;
import cardealership.model.Vehicle;
import cardealership.repository.UserRepository;
import cardealership.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UserController implements UserControllerResource{
    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseEntity<User> getById(Long id) {
        User user = userService.getById(id);

        return ResponseEntity.status(200).body(user);
    }

    @Override
    public ResponseEntity<String> add(UserDto userDto) {
        User user = userMapper.withUserDto(userDto).toEntity();
        user.setPassword(hashPassword(user.getPassword()));

        try {
            userService.add(user);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Created Successfully");
    }

    @Override
    public ResponseEntity<String> update(UserAddDto userDto, Long id) {
        try {
            userDto.setPassword(hashPassword(userDto.getPassword()));
            userService.update(userDto, id);
        } catch (Exception exception) {
            return ResponseEntity.status(400).body("User does not exist");
        }
        return ResponseEntity.status(200).body("Updated successfully");
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.toString());
        }

        return ResponseEntity.status(200).body("User has been deleted...");
    }

    @Override
    public ResponseEntity<UserLoggedDto> login(UserLoginDto userLoginDto) throws Exception {
        var loggingUser = userRepository.checkUserLoginCredentials(userLoginDto.getEmail(), hashPassword(userLoginDto.getPassword()));
        if (loggingUser != null) {

            var userLoggedDto = new UserLoggedDto().withIsAdmin(loggingUser.getIsAdmin())
                    .withName(loggingUser.getName())
                    .withPassword(loggingUser.getPassword())
                    .withEmail(loggingUser.getEmail())
                    .withId(loggingUser.getId());

            return ResponseEntity.status(200).body(userLoggedDto);

        } else {
            throw new Exception("Incorrect username or password...");

        }
    }

    @Override
    public ResponseEntity<User> register(UserAddDto userRegisterDto) throws Exception{
        UserDto userDto = new UserDto();
        userDto.setEmail(userRegisterDto.getEmail());
        userDto.setPassword(hashPassword(userRegisterDto.getPassword()));
        userDto.setName(userRegisterDto.getName());
        userDto.setIsAdmin(false);
        User user = userMapper.withUserDto(userDto).toEntity();
        try {
            userService.add(user);
            user = userRepository.findByEmail(user.getEmail());

        } catch (Exception e) {
            throw new Exception("Registered failed");
        }
        return ResponseEntity.status(200).body(user);
    }

    @Override
    public ResponseEntity<String> logout() {
        return ResponseEntity.status(200).body("logout");
    }

    @Override
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.status(200).body(users);
    }

    @Override
    public ResponseEntity<List<UserGetDto>> getAllDto() {
        List<UserGetDto> userGetDtos = userService.getAllDto();
        return ResponseEntity.status(200).body(userGetDtos);
    }
}
