package cardealership.mapper;

import cardealership.dto.UserDto;
import cardealership.dto.UserGetDto;
import cardealership.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserMapper {
    private User user;
    private UserDto userDto;
    private UserGetDto userGetDto;

    public UserDto toDto() {
        return toUserDto(user);
    }

    public UserGetDto toGetDto() {
        return toUserGetDto(user);
    }

    public User toEntity() {
        return toUserEntity(userDto);
    }

    public User getToEntity() {
        return getToUserEntity(userGetDto);
    }

    private UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setIsAdmin(user.getIsAdmin());

        return userDto;
    }

    private UserGetDto toUserGetDto(User user) {
        UserGetDto userGetDto = new UserGetDto();

        userGetDto.setId(user.getId());
        userGetDto.setName(user.getName());
        userGetDto.setEmail(user.getEmail());
        userGetDto.setPassword(user.getPassword());
        userGetDto.setIsAdmin(user.getIsAdmin());

        return userGetDto;
    }

    private User toUserEntity(UserDto userDto) {
        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setIsAdmin(userDto.getIsAdmin());

        return user;
    }

    private User getToUserEntity(UserGetDto userGetDto) {
        User user = new User();

        user.setId(userGetDto.getId());
        user.setEmail(userGetDto.getEmail());
        user.setName(userGetDto.getName());
        user.setPassword(userGetDto.getPassword());
        user.setIsAdmin(userGetDto.getIsAdmin());

        return user;
    }

}
