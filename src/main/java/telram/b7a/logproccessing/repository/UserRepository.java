package telram.b7a.logproccessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import telram.b7a.logproccessing.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
