package cardealership.service;

import cardealership.dto.UserAddDto;
import cardealership.dto.UserDto;
import cardealership.dto.UserGetDto;
import cardealership.dto.VehicleDto;
import cardealership.mapper.UserMapper;
import cardealership.model.User;
import cardealership.model.Vehicle;
import cardealership.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User getById(Long id) {
        User user = userRepository.findById(id);
        System.out.println("LOG:\n" + user + "\n");
        return user;
    }

    @Override
    public void add(User user) throws Exception {
        try {
            if (userRepository.findByEmail(user.getEmail()) == null)
                userRepository.save(user);
            else
                throw new Exception("User with the same email address already exists...");
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    @Override
    public void update(UserAddDto userDto, Long id) throws Exception {
        User userToUpdate = userRepository.findById(id);
        if (userToUpdate != null) {
            userToUpdate.setEmail(userDto.getEmail());
            userToUpdate.setName(userDto.getName());
            userToUpdate.setPassword(userDto.getPassword());
            userRepository.save(userToUpdate);
        }
        else {
            throw new Exception("User not found...");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        User user = userRepository.findById(id);
        if(user != null) {
            userRepository.delete(user);
        }
        else {
            throw new Exception("User not found...");
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserGetDto> getAllDto() {
        List<User> users = userRepository.findAll();
        List<UserGetDto> userGetDtos = new ArrayList<>();
        for(User user : users) {
            UserGetDto userGetDto = userMapper.withUser(user).toGetDto();
            userGetDtos.add(userGetDto);
        }
        return userGetDtos;
    }
}
