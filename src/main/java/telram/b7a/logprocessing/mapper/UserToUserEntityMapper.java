package telram.b7a.logprocessing.mapper;

import org.mapstruct.Mapper;
import telram.b7a.logprocessing.model.User;
import telram.b7a.logprocessing.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserToUserEntityMapper {
    User userEntityToUser(UserEntity userEntity);
}
