package cl.globallogic.recruiting.apibci.service;

import cl.globallogic.recruiting.apibci.model.User;
import cl.globallogic.recruiting.apibci.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.0.0 - 03-12-2019
 * @since 1.0.0 - 03-12-2019
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserRs(String id) {
        //User u = userRepository.findByUser(id);
        return null;
    }

    @Override
    public void addUser(User p) {

        userRepository.save(p);

    }
}
