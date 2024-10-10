package ru.wenant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.wenant.dto.UserDTO;
import ru.wenant.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);

}
