package telram.b7a.logproccessing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import telram.b7a.logproccessing.model.UserEntity;

//public  interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer>
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
