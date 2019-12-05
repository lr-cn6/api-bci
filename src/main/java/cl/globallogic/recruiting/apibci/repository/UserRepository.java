package cl.globallogic.recruiting.apibci.repository;

import cl.globallogic.recruiting.apibci.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Luis Riveros - luis.riveros_ex@scotiabank.cl
 * @version 1.0.0 - 03-12-2019
 * @since 1.0.0 - 03-12-2019
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByUser(String id);

}
