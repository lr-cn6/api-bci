package cl.globallogic.recruiting.apibci.service;

import cl.globallogic.recruiting.apibci.exception.ApiBciException;
import cl.globallogic.recruiting.apibci.model.User;
import cl.globallogic.recruiting.apibci.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

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
        return userRepository.findById(id).get();
    }

    @Override
    public User addUser(User p) throws ApiBciException{
        User response;

        p.setId(UUID.randomUUID().toString());
        p.setActive(true);
        try {
            userRepository.save(p);
        }catch (Exception e){
            throw new ApiBciException(e);
        }

        response = userRepository.findById(p.getId()).get();
        response.setPassword(null);
        return response;
    }
}
