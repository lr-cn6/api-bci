package cl.globallogic.recruiting.apibci.repository;

import cl.globallogic.recruiting.apibci.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.0.0 - 03-12-2019
 * @since 1.0.0 - 03-12-2019
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findById(String id);
    Optional<User> findByEmail(String id);

    boolean existsByEmail(String email);

}
