package com.crud.simplecrud.module.user.util;

import com.crud.simplecrud.module.user.persistence.UserModel;
import com.crud.simplecrud.module.user.domain.User;
import com.crud.simplecrud.shared.domain.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserModel toModel(User domain);
    UserDTO toDto(UserModel domain);
    User toDomain(UserModel model);
}
