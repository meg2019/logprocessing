package telram.b7a.logproccessing.mapper;

import org.mapstruct.Mapper;
import telram.b7a.logproccessing.model.User;
import telram.b7a.logproccessing.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserToUserEntityMapper {
    User userEntityToUser(UserEntity userEntity);
}
