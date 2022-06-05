package telram.b7a.logprocessing.repository;

import org.springframework.data.repository.CrudRepository;
import telram.b7a.logprocessing.model.UserEntity;

//public  interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer>
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
